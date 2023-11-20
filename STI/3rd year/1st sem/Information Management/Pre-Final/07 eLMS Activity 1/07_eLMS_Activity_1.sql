CREATE TABLE Artists (
    Artist VARCHAR(255),
    Album VARCHAR(255)
);

CREATE TABLE Regions (
    Province VARCHAR(255),
    Municipality VARCHAR(255)
);

INSERT INTO Artists (Artist, Album) 
VALUES
('Ed Sheeran', 'Divide'),
('Ed Sheeran', 'Equal'),
('Linkin Park', 'Hybrid Theory');


INSERT INTO Regions (Province, Municipality) 
VALUES
('Rizal', 'Binangonan'),
('Metro Manila', 'Quezon City'),
('Laguna', 'Santa Rosa');

SELECT DISTINCT Album FROM Artists WHERE Artist = 'Ed Sheeran';
SELECT * FROM Regions WHERE Province = 'Rizal';
SELECT * FROM Artists ORDER BY Album DESC;
UPDATE Regions SET Municipality = 'Cainta' WHERE Province = 'Rizal';
SELECT * FROM Regions WHERE Province LIKE 'L%a';