CREATE DATABASE myDB;

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(255),
	LastName VARCHAR(255),
	Email VARCHAR(255),
	Gender VARCHAR(255),
	Birthdate VARCHAR(255)
);

CREATE TABLE Vendor (
    VendorID INT PRIMARY KEY,   
    Name VARCHAR(255),
	ContactNum VARCHAR(255),
	CityAddress VARCHAR(255)
);

CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    Description VARCHAR(255),
	Quantity VARCHAR(255),
	Price VARCHAR(255),
    VendorID INT, -- Declare VendorID as its NULL
    FOREIGN KEY (VendorID) REFERENCES Vendor(VendorID)
);

SELECT * FROM Customers;
SELECT * FROM Vendor;
SELECT * FROM Products;