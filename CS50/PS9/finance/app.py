import os

from cs50 import SQL
from flask import Flask, flash, redirect, render_template, request, session
from flask_session import Session
from werkzeug.security import check_password_hash, generate_password_hash

from helpers import apology, login_required, lookup, usd

# Configure application
app = Flask(__name__)

# Custom filter
app.jinja_env.filters["usd"] = usd

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Configure CS50 Library to use SQLite database
db = SQL("sqlite:///finance.db")


@app.after_request
def after_request(response):
    """Ensure responses aren't cached"""
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response


@app.route("/")
@login_required
def index():
    stocks = db.execute("SELECT symbol, SUM(shares) as total_shares FROM transactions WHERE user_id = :user_id GROUP BY symbol HAVING total_shares > 0",
                        user_id=session["user_id"])

    cash = db.execute("SELECT cash FROM users WHERE id = :user_id",
                      user_id=session["user_id"])[0]["cash"]

    total_value = cash

    for stock in stocks:
        quote = lookup(stock["symbol"])
        stock["price"] = quote["price"]
        stock["value"] = stock["price"] * stock["total_shares"]
        total_value += stock["value"]

    return render_template("index.html", stocks=stocks, cash=cash, total_value=total_value)


@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():
    if request.method == "POST":

        type = "Buy"
        symbol = request.form.get("symbol").upper()
        shares = request.form.get("shares")

        try:
            shares = float(shares)
            if shares <= 0 or not shares.is_integer():
                return apology("invalid share(s) amount", 400)
            shares = int(shares)
        except ValueError:
            return apology("invalid share(s) amount", 400)

        if not symbol:
            return apology("must provide valid symbol", 400)

        quote = lookup(symbol)

        if not quote:
            return apology("invalid symbol", 400)

        price = quote['price']
        total_cost = shares * price
        cash = db.execute("SELECT cash FROM users WHERE id = :user_id",
                          user_id=session["user_id"])[0]["cash"]

        if cash < total_cost:
            return apology("not enough cash")

        db.execute("UPDATE users SET cash = cash - :total_cost WHERE id = :user_id",
                   total_cost=total_cost, user_id=session["user_id"])

        db.execute("INSERT INTO transactions (user_id, type, symbol, shares, price) VALUES(?,?,?,?,?)",
                   session["user_id"], type, quote['symbol'], shares, quote['price'])

        flash(f"Bought {shares} shares of {symbol} for {usd(total_cost)}!")
        return redirect("/")

    else:
        return render_template("buy.html")


@app.route("/history")
@login_required
def history():
    transactions = db.execute(
        "SELECT * FROM transactions WHERE user_id = :user_id ORDER BY timestamp DESC",
        user_id=session["user_id"]
    )

    for transaction in transactions:
        print(f'Price: {transaction["price"]}, Shares: {transaction["shares"]}')
        transaction["value"] = transaction["price"] * transaction["shares"]
        print(f'Calculated Value: {transaction["value"]}')

    return render_template("history.html", transactions=transactions)


@app.route("/login", methods=["GET", "POST"])
def login():

    session.clear()

    if request.method == "POST":

        username = request.form.get("username")
        password = request.form.get("password")
        user = db.execute("SELECT * FROM users WHERE username = ?", username)

        if not username or not password:
            return apology("mising field(s)", 400)

        if len(user) != 1:
            return apology("invalid username", 400)

        if not check_password_hash(user[0]["hash"], password):
            return apology("invalid password", 400)

        session["user_id"] = user[0]["id"]

        return redirect("/")

    else:
        return render_template("login.html")


@app.route("/logout")
def logout():

    session.clear()
    return redirect("/")


@app.route("/quote", methods=["GET", "POST"])
@login_required
def quote():
    if request.method == "POST":
        quote = lookup(request.form.get("symbol").upper())

        if not quote:
            return apology("invalid symbol", 400)

        return render_template("quote.html", quote=quote)

    else:
        return render_template("quote.html")


@app.route("/register", methods=["GET", "POST"])
def register():

    if request.method == "POST":

        username = request.form.get("username")
        password = request.form.get("password")
        confirmation = request.form.get("confirmation")
        user = db.execute("SELECT * FROM users WHERE username = ?", username)
        hash = generate_password_hash(password)

        if not username or not password or not confirmation:
            return apology("missing field(s)", 400)

        if len(user) >= 1:
            return apology("username already taken", 400)

        if password != confirmation:
            return apology("passwords do not match", 400)

        db.execute("INSERT INTO users (username, hash) VALUES(?,?)", username, hash)

        return redirect("/")

    else:
        return render_template("register.html")


@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    if request.method == "POST":

        type = "Sell"
        symbol = request.form.get("symbol", "").upper()
        shares = request.form.get("shares")

        if not shares.isdigit() or int(shares) < 1:
            return apology("invalid shares amount", 400)

        quote = lookup(symbol)
        if not quote:
            return apology("invalid symbol", 400)

        user_shares = db.execute("SELECT SUM(shares) as total_shares FROM transactions WHERE user_id = :user_id AND symbol = :symbol",
                                 user_id=session["user_id"], symbol=symbol)[0]["total_shares"]

        if user_shares is None or int(user_shares) < int(shares):
            return apology("not enough shares", 400)

        price = quote['price']
        total_cost = int(shares) * int(price)
        cash = db.execute("SELECT cash FROM users WHERE id = :user_id",
                          user_id=session["user_id"])[0]["cash"]

        db.execute("UPDATE users SET cash = cash + :total_cost WHERE id = :user_id",
                   total_cost=total_cost, user_id=session["user_id"])

        db.execute("INSERT INTO transactions (user_id, type, symbol, shares, price) VALUES(?,?,?,?,?)",
                   session["user_id"], type, quote['symbol'], -int(shares), quote['price'])

        flash(f"Sold {shares} shares of {symbol} for {usd(total_cost)}!")

        return redirect("/")

    else:
        stocks = db.execute("SELECT symbol, SUM(shares) as total_shares FROM transactions WHERE user_id = :user_id GROUP BY symbol HAVING total_shares > 0",
                            user_id=session["user_id"])

        return render_template("sell.html", stocks=stocks)


@app.route("/deposit", methods=["GET", "POST"])
@login_required
def deposit():
    if request.method == "POST":

        cash = db.execute("SELECT cash FROM users WHERE id = :user_id",
                          user_id=session["user_id"])[0]["cash"]
        amount = request.form.get("amount")

        if not amount.isdigit() or int(amount) < 1:
            return apology("invalid deposit amount", 400)

        db.execute("UPDATE users SET cash = cash + :amount WHERE id = :user_id",
                   amount=amount, user_id=session["user_id"])

        flash(f"Deposited {amount}")

    return render_template("deposit.html")
