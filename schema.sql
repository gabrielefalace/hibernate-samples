create schema protein_tracker;

create table Users (
	id INT NOT NULL AUTO_INCREMENT, 
	name VARCHAR(100) NOT NULL, 
	total INT NOT NULL DEFAULT 0, 
	goal INT NOT NULL DEFAULT 100,
	PRIMARY KEY (id));
