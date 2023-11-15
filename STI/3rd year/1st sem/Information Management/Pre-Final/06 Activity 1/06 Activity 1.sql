CREATE TABLE Flavors (
    ItemCode INT PRIMARY KEY,
    ItemDesc VARCHAR(255),
	Price FLOAT CHECK (Price >= 65)
);

SELECT * FROM Flavors;

ALTER TABLE Flavors
DROP COLUMN ItemDesc;