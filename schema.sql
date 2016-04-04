create table Users (
	id INT NOT NULL AUTO_INCREMENT, 
	name VARCHAR(100) NOT NULL, 
    protein_id int not null,
	PRIMARY KEY (id),
    constraint foreign key (protein_id) references Protein_Data(protein_id)
);
    
    
create table User_History (
	user_history_id INT NOT NULL AUTO_INCREMENT,
	entry_time date,
    user_fk INT NOT NULL,
    entry VARCHAR(100),
    PRIMARY KEY (user_history_id),
    constraint foreign key (user_fk) references Users(id)
);
    

create table Protein_Data (
	protein_id INT NOT NULL AUTO_INCREMENT,
    total INT NOT NULL DEFAULT 0, 
	goal INT NOT NULL DEFAULT 100,
    PRIMARY KEY (protein_id)
);


create table Goal_Alert (
	goal_id INT NOT NULL AUTO_INCREMENT,
	message VARCHAR(100),
    primary key (goal_id)
);

create table User_GoalAlert (
	user_fk INT not null,
	goal_alert_fk INT not null,
	primary key (user_fk, goal_alert_fk),
	constraint foreign key (user_fk) references Users(id),
	constraint foreign key (goal_alert_fk) references Goal_Alert(goal_id)
);
