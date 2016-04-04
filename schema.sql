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
