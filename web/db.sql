create table members 
   (id int(11) not null auto_increment primary key, 
	name varchar(4000), 
	password varchar(4000), 
	gender varchar(4000), 
	dob date, 
	address varchar(4000), 
	contact varchar(4000) 
   );
/

create table books 
   (isbn varchar(1000) not null primary key, 
	name varchar(4000), 
	author_name varchar(4000), 
	publisher varchar(4000), 
	price int(11), 
	edition varchar(4000), 
	subject varchar(4000), 
	copies int(11)
   );
/

create table issueReturn 
   (id int(11) not null,
   	isbn varchar(1000), 
	issue_date date, 
	return_date date, 
	expiry_date date,
	PRIMARY KEY (id, isbn),
	FOREIGN KEY (id) REFERENCES members(id),
	FOREIGN KEY (isbn) REFERENCES books(isbn)
   );
/

create table requestBook 
   (id int(11) not null,
   	isbn varchar(1000), 
	request_date date, 
	PRIMARY KEY (id, isbn),
	FOREIGN KEY (id) REFERENCES members(id),
	FOREIGN KEY (isbn) REFERENCES books(isbn)
   );
/

create table payment 
   (id int(11) not null,
   	isbn varchar(1000), 
	amount int(11), 
	payment_date date, 
	PRIMARY KEY (id, isbn),
	FOREIGN KEY (id) REFERENCES members(id),
	FOREIGN KEY (isbn) REFERENCES books(isbn)
   );
/