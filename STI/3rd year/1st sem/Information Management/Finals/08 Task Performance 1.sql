CREATE DATABASE AcojidoDB;

CREATE TABLE StudentGrade (
    CourseCode VARCHAR(16) PRIMARY KEY,
    CourseTitle VARCHAR(64),
	  Units INT,
    Grade DECIMAL(3, 2)
);

INSERT INTO StudentGrade (CourseCode, CourseTitle, Units, Grade)
VALUES 
('COSC1003', 'Data Structures and Algorithms', 3, 1.50),
('GEDC1006', 'Readings in Philippine History', 3, 2.25),
('PHED1003', 'Physical Education 3', 2, 1.25),
('GEDC1014', 'Rizal''s Life and Works', 3, 1.50),
('COSC1007', 'Human-Computer Interaction', 3, 1.25),
('INTE1044', 'Object-Oriented Programming', 3, 1.75),
('COSC1001', 'Principles of Communication', 3, 2.25),
('COSC1008', 'Platform Technology', 3, 1.50);

SELECT COUNT(*) AS CourseCount
FROM StudentGrade;

SELECT SUM(Units) AS TotalUnits
FROM StudentGrade;

SELECT COUNT(*) AS GradesHigherThanTwo
FROM StudentGrade WHERE Grade > 2;

SELECT COUNT(*) AS GradesLowerThanTwo
FROM StudentGrade WHERE Grade < 2;

SELECT SUM(Grade * Units) / SUM(Units) AS GeneralWeightedAverage
FROM StudentGrade;