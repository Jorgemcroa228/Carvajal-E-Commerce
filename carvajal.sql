CREATE DATABASE carvajal;

USE carvajal;

CREATE TABLE user (
  id_user bigint auto_increment primary key,
  name varchar(100) not null,
  email varchar(255) unique not null,
  password varchar(255) not null
);


CREATE TABLE products (
  id_product bigint auto_increment  primary key,
  name varchar(80) not null,
  price decimal(5, 2) not null,
  amount int not null
);


CREATE TABLE wishes (
  id_wishes BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_user BIGINT NOT NULL,
  id_product BIGINT NOT NULL,
  date_add DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_user) REFERENCES user(id_user),
  FOREIGN KEY (id_product) REFERENCES products(id_product)
);

CREATE TABLE wish_list (
    id_wishList BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_user BIGINT NOT NULL,
    id_product BIGINT NOT NULL,
    action VARCHAR(20) NOT NULL,
    date DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_user) REFERENCES user(id_user),
    FOREIGN KEY (id_product) REFERENCES products(id_product)
);


INSERT INTO products(name, price, amount) 
VALUES
('Laptop', 10, 2500.00),
('Mouse', 50, 25.00),
('Teclado', 30, 80.00),
('Monitor', 15, 900.00);


