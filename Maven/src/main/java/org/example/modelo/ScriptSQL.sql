create database hibernate;

use hibernate;

create table persona(
	id int auto_increment primary key,
    nombre varchar(50),
    altura double,
    peso double,
    tez varchar(50)
);