-- Keep a log of any SQL queries you execute as you solve the mystery.
/*

July 28 Humphrey Street
Who is the Thief?
Where did the thief escaped to?
Who is the accomplice?

.sqlite3 fiftyville.db
.tables

.schema crime_scene_reports

SELECT description
FROM crime_scene_reports
WHERE month = 7 AND day = 28
AND street = 'Humphrey Street';

10:15am Bakery (3 witness interviews)

.schema interviews

SELECT transcript
FROM interviews
WHERE month = 7 AND day = 28;

theft 10min got into his car
the thief earlier this morning is at ATM of leggett Street
the thief called someone as he left for less than a minute
the thief and accomplice took the earliest flight of fiftyville tomorrow
the accomplice bought the ticket

.schema bakery_security_logs

SELECT activity, license_plate
FROM bakery_security_logs
WHERE month = 7 AND day = 28 AND hour = 10 AND minute BETWEEN 15 AND 25 AND activity = 'exit';

8 suspects

.schema atm_transactions

SELECT account_number, transaction_type, amount
FROM atm_transactions
WHERE month = 7 AND day = 28 AND atm_location = 'Leggett Street';

SELECT p.name, b.creation_year, p.phone_number
FROM people AS p
INNER JOIN bank_accounts AS b ON b.person_id = p.id
WHERE b.account_number IN (
    SELECT account_number
    FROM atm_transactions
    WHERE month = 7 AND day = 28 AND atm_location = 'Leggett Street'
);

.schema phone_calls

SELECT caller, receiver, duration
FROM phone_calls
WHERE month = 7 AND day = 28 AND duration < 60;

.schema airports
.schema flights

SELECT f.id AS id, o.city AS origin, d.city AS destination
FROM flights AS f
INNER JOIN airports AS o ON f.origin_airport_id = o.id
INNER JOIN airports AS d ON f.destination_airport_id = d.id
WHERE o.city = 'Fiftyville' AND month = 7 AND day = 29
ORDER BY hour ASC
LIMIT 1;

.schema passengers

SELECT p.passport_number
FROM passengers AS p
INNER JOIN flights AS f ON f.id = p.flight_id
WHERE f.id = 37 AND passport_number = 3592750733 OR passport_number = 5773159633;

SELECT name, passport_number
FROM people
WHERE license_plate IN (
    SELECT license_plate
    FROM bakery_security_logs
    WHERE month = 7 AND day = 28 AND hour = 10 AND minute BETWEEN 15 AND 25 AND activity = 'exit'
)
AND phone_number IN (
    SELECT caller
    FROM phone_calls
    WHERE month = 7
        AND day = 28
        AND duration < 60
        AND caller IN (
            SELECT p.phone_number
            FROM people AS p
            INNER JOIN bank_accounts AS b ON b.person_id = p.id
            WHERE b.account_number IN (
                SELECT account_number
                FROM atm_transactions
                WHERE month = 7
                    AND day = 28
                    AND atm_location = 'Leggett Street'
            )
        )
);

SELECT phone_number
FROM people
WHERE name = 'Bruce';

SELECT name
FROM people
WHERE phone_number = '(375) 555-8161';

Key Clues
The Robbery Happened
At July 28 10:15 AM
In Humphrey Street Bakery
Flight: #36 July 29, 8:20AM Fiftyville to NY
Thief Number: (367) 555-5533
Accomplice Number: (375) 555-8161

Answer
Thief: Bruce
Accomplice: Robin

Diary
My train of thought goes like this first I gather as much information as I can then I'll solve it from there.
I started off with the guided instructions from the cs50 video then I am about to go to bakery_security_logs as
that's where it took place. If a hint leads to nothin as of now I'll come back to it later as I collect more info.
*/



