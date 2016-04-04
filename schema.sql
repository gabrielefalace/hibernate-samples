create schema protein_tracker;

create table Users (
	id INT NOT NULL AUTO_INCREMENT, 
	name VARCHAR(100) NOT NULL, 
	total INT NOT NULL DEFAULT 0, 
	goal INT NOT NULL DEFAULT 100,
	PRIMARY KEY (id));

create table User_History (
	user_history_id INT NOT NULL AUTO_INCREMENT,
	entry_time date,
    user_fk INT NOT NULL,
    entry VARCHAR(100),
    PRIMARY KEY (user_history_id),
    constraint foreign key (user_fk) references Users(id)
);
