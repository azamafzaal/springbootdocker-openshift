CREATE TABLE STUDENT (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	name varchar(255),
	standard varchar(255),
	section varchar(255)
);

create sequence student_sequence start with 1 increment by 1;

insert into STUDENT (name, standard, section) values ('Babar Azam', '5th', 'A');
insert into STUDENT (name, standard, section) values ('Fakhar Zaman', '6th', 'B');
insert into STUDENT (name, standard, section) values ('Steve Smith', '4th', 'C');
insert into STUDENT (name, standard, section) values ('Lasith Malinga', '10th', 'B');
insert into STUDENT (name, standard, section) values ('Jos Buttler', '7th', 'A');