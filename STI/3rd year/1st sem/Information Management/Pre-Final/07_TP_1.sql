-- Start Part 1
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(16),
	LastName VARCHAR(16),
	Email VARCHAR(32),
	Gender VARCHAR(8),
	Birthdate DATE
);

CREATE TABLE Vendor (
    VendorID VARCHAR(8) PRIMARY KEY,   
    Name VARCHAR(32),
	ContactNum VARCHAR(16),
	CityAddress VARCHAR(16)
);

CREATE TABLE Products (
    ProductID VARCHAR(8) PRIMARY KEY,
    Description VARCHAR(32),
	Quantity INT,
    VendorID VARCHAR(8),
    FOREIGN KEY (VendorID) REFERENCES Vendor(VendorID)
);
-- End Part 1

-- Start Part 2
INSERT INTO Customers (CustomerID, FirstName, LastName, Email, Gender, Birthdate)
VALUES 
(02000311241, 'Iskra', 'Jarvi', 'iskrajarvi@gmail.com', 'Female', '2003-08-13'),
(02000311242, 'Patrik', 'Madsen', 'patrikmadsen@gmail.com', 'Male', '2002-07-04'),
(02000311243, 'Ema', 'Idowu', 'emaidowu@gmail.com', 'Female', '2002-11-26'),
(02000311244, 'Helmut', 'Saari', 'helmutsaari@gmail.com', 'Male', '2002-12-10'),
(02000311245, 'Anil', 'Banerjee', 'anilbanerjee@gmail.com', 'Male', '2003-08-13');

INSERT INTO Vendor (VendorID, Name, ContactNum, CityAddress)
VALUES 
('V00001', 'Universal Robina Corporation', 8633-7631, 'Pasig, MM'),
('V00002', 'Liwayway Marketing Corporation', 8844-8441, 'Pasay, MM'),
('V00003', 'Monde Nissin', 7759-7500, 'Makati, MM');

INSERT INTO Products (ProductID, Description, Quantity, VendorID)
VALUES 
('P000101', 'Jack n Jill Piattos', 1000, 'V00001'),
('P000102', 'Jack n Jill Nova', 1000, 'V00001'),
('P001005', 'Oishi Prawn Crackers', 700, 'V00002'),
('P030007', 'Nissin Eggnog Cookies', 850, 'V00003');

UPDATE Products
SET Quantity = Quantity + 274
WHERE ProductID = 'P000102';

UPDATE Products
SET Quantity = Quantity - 42
WHERE ProductID = 'P030007';

-- Determine which products have a quantity of less than 1000.
SELECT * FROM Products WHERE Quantity < 1000;

-- Determine which products have a quantity of less than 1000 then display the product's vendor ID and name.
SELECT P.ProductID, P.Description, P.Quantity, P.VendorID, V.Name -- Column Header
FROM Products AS P -- From Products alias P
JOIN Vendor AS V ON P.VendorID = V.VendorID -- Join Vendor alias V if Products VendorID is equal to Vendors VendorID
WHERE P.Quantity < 1000; -- Wherein the quantity of the Product is less than one thousand
-- note this is called inner join as similar VendorID is combined

DELETE FROM Customers WHERE CustomerID = 02000311241;
SELECT * FROM Customers;
-- End Part 2
