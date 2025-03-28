-- Assignment 4
USE StoreFront;
-- Create appropriate tables and relationships for the same and write a SQL
--          query for that returns a Resultset containing Zip Code, City Names and
--          States ordered by State Name and City Name.
-- 	(Create 3 tables to store State, District/City & Zip code separately)


-- CREATE TABLE state(
-- id INT PRIMARY KEY AUTO_INCREMENT,
-- name VARCHAR(20) NOT NULL
-- );
-- CREATE TABLE city(
-- id INT PRIMARY KEY AUTO_INCREMENT,
-- name VARCHAR(50) NOT NULL,
-- state_id INT NOT NULL,
-- FOREIGN KEY (state_id) REFERENCES state(id));

-- CREATE TABLE zip_code(
-- id INT PRIMARY KEY AUTO_INCREMENT,
-- code INT  NOT NULL,
-- city_id INT NOT NULL,
-- FOREIGN KEY (city_id) REFERENCES city(id));

-- INSERT INTO state(name) VALUES
-- ('Rajasthan'),('Haryana'),('Punjab');

-- INSERT INTO city(name,state_id) VALUES
-- ('Hanumangarh',1),('Sirsa',2),('Bhatinda',3),('Jaipur',1),('Pali',1);

-- INSERT INTO zip_code(code,city_id) VALUES
-- (335513,1),(125055,2),(151001,3),(302017,1),(306401,1);


SELECT s.name,c.name,z.code FROM state s JOIN city c 
ON c.state_id = s.id JOIN zip_code z ON
z.city_id = c.id
ORDER BY s.name, c.name DESC;
