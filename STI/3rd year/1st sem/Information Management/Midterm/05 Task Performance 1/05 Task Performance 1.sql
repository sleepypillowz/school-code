-- 2NF
CREATE TABLE student_info (
    student_number VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

CREATE TABLE student_programs (
    student_number VARCHAR(255),
    year VARCHAR(255),
    term VARCHAR(255),
    program VARCHAR(255),
    FOREIGN KEY (student_number) REFERENCES student_info(student_number)
);

CREATE TABLE student_subjects (
    student_number VARCHAR(255),
    subject VARCHAR(255),
    FOREIGN KEY (student_number) REFERENCES student_info(student_number)
);

-- 3NF
CREATE TABLE subject_table (
    sub_id INT PRIMARY KEY,
    subject_name VARCHAR(255)
);

CREATE TABLE program_table (
    prog_id INT PRIMARY KEY,
    program VARCHAR(255)
);

CREATE TABLE student_table (
    student_number VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

CREATE TABLE enrollment_table (
    enroll_id INT PRIMARY KEY,
    year VARCHAR(255),
    term VARCHAR(255),
    prog_id INT,
    sub_id INT,
    student_number VARCHAR(255),
    FOREIGN KEY (prog_id) REFERENCES program_table(prog_id),
    FOREIGN KEY (sub_id) REFERENCES subject_table(sub_id),
    FOREIGN KEY (student_number) REFERENCES student_table(student_number)
);

-- 2NF
INSERT INTO student_info (student_number, first_name, last_name)
VALUES ('035-20130-0205', 'Mairo', 'Eli');

INSERT INTO student_programs (student_number, year, term, program)
VALUES ('035-20130-0205', '2016-2017', '2nd', 'BSIT');

INSERT INTO student_subjects (student_number, subject)
VALUES
('035-20130-0205', 'Advanced Database Systems'),
('035-20130-0205', 'Management Information Systems'),
('035-20130-0205', 'Systems Analysis and Design');


-- 3NF
INSERT INTO subject_table (sub_id, subject_name)
VALUES
(1, 'Advanced Database Systems'),
(2, 'Management Information Systems'),
(3, 'Systems Analysis and Design');

INSERT INTO program_table (prog_id, program)
VALUES (1, 'BSIT');

INSERT INTO student_table (student_number, first_name, last_name)
VALUES ('035-20130-0205', 'Mairo', 'Eli');

INSERT INTO enrollment_table (enroll_id, year, term, prog_id, sub_id, student_number)
VALUES
(1, '2016-2017', '2nd', 1, 1, '035-20130-0205'),
(2, '2016-2017', '2nd', 1, 2, '035-20130-0205'),
(3, '2016-2017', '2nd', 1, 3, '035-20130-0205');

-- 2NF

SELECT * FROM student_info;

SELECT * FROM student_programs;

SELECT * FROM student_subjects;


-- 3NF

SELECT * FROM subject_table;
SELECT * FROM program_table;
SELECT * FROM student_table;
SELECT * FROM enrollment_table;
