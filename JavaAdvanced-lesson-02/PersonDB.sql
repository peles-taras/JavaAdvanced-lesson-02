DROP DATABASE IF EXISTS PersonDB;
CREATE DATABASE PersonDB;
USE PersonDB;

CREATE TABLE Person(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
age INT NOT NULL
);

INSERT INTO Person(first_name, last_name, age) VALUES('testName', 'testSurname', 21);
SELECT * FROM Person;