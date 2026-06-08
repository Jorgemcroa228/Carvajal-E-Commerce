CREATE DATABASE carvajal;

USE carvajal;

CREATE TABLE user (
  id_user int auto_increment primary key,
  name varchar(100) not null,
  email varchar(255) unique not null,
  password varchar(255) not null
);

CREATE TABLE products (
  id_product int auto_increment  primary key,
  name varchar(80) not null,
  price decimal(5, 2) not null,
  amount int not null
);

CREATE TABLE wishes (
  
);

