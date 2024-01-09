CREATE DATABASE Gallery;

CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    Username VARCHAR(16),
	DateCreated DATE
);

CREATE TABLE Pictures (
    PictureID VARCHAR(8) PRIMARY KEY,   
    FileName VARCHAR(32),
	UserID INT,
	DateCreated DATE
);

INSERT INTO Users (UserID, Username, DateCreated)
VALUES 
(001, 'sparsley', '2019-02-19'),
(002, 'dsumshon1', '2018-12-24'),
(003, 'hpointing2', '2018-12-11'),
(004, 'smannagh3', '2018-08-05'),
(005, 'gstarsmore4', '2017-07-09'),
(006, 'dzuann5', '2019-01-09');

INSERT INTO Pictures (PictureID, FileName, UserID, DateCreated)
VALUES 
(1001, 'laptop.jpeg', 003, '2019-02-07'),
(1002, 'sti_orca.jpeg', 007, '2019-09-04'),
(1003, 'home.jpeg', 005, '2019-2-16'),
(1004, 'bsit.jpeg', 001, '2019-10-19');

SELECT * FROM Users
INNER JOIN Pictures ON Users.UserID = Pictures.UserID;

SELECT * FROM Users
LEFT JOIN Pictures ON Users.UserID = Pictures.UserID;

SELECT * FROM Users
RIGHT JOIN Pictures ON Users.UserID = Pictures.UserID;

SELECT * FROM Users
FULL JOIN Pictures ON Users.UserID = Pictures.UserID;
