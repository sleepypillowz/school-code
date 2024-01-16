<!DOCTYPE html>

<html>

<head>

    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

     <form action="login.php" method="post">

        <h2>LOGIN</h2>

        <?php if (isset($_GET['error'])) { ?>

            <p class="error"><?php echo $_GET['error']; ?></p>

        <?php } ?>

        <label>User Name</label>

        <input type="text" name="uname" placeholder="User Name"><br>

        <label>Password</label>

        <input type="password" name="password" placeholder="Password"><br> 

        <button type="submit" name="btnLogin" value="Login">Login</button>

        <button type="submit" name="btnRegister" value="Regsister">Register</button>

     </form>

</body>

</html>