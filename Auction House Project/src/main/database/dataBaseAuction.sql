ALTER TABLE Address DROP CONSTRAINT FKAdress854198;
ALTER TABLE Product_Orders DROP CONSTRAINT FKProduct_Or475090;
ALTER TABLE Product_Orders DROP CONSTRAINT FKProduct_Or468415;
ALTER TABLE Orders DROP CONSTRAINT FKOrders145166;
ALTER TABLE Bids DROP CONSTRAINT FKBids169750;
ALTER TABLE Product_Bids DROP CONSTRAINT FKProduct_Bi532421;
ALTER TABLE Product_Bids DROP CONSTRAINT FKProduct_Bi783075;
DROP TABLE IF EXISTS Address CASCADE;
DROP TABLE IF EXISTS Bids CASCADE;
DROP TABLE IF EXISTS Orders CASCADE;
DROP TABLE IF EXISTS Product_Bids CASCADE;
DROP TABLE IF EXISTS Product_Orders CASCADE;
DROP TABLE IF EXISTS Products CASCADE;
DROP TABLE IF EXISTS Users CASCADE;




CREATE TABLE Address (id SERIAL NOT NULL, street varchar(255) NOT NULL, number int4 NOT NULL, city varchar(255) NOT NULL, country varchar(255) NOT NULL, Useruser_id int4 NOT NULL, PRIMARY KEY (id));
CREATE TABLE Bids (bid_id SERIAL NOT NULL, value int4 NOT NULL, state int4 NOT NULL, user_id int4 NOT NULL, PRIMARY KEY (bid_id));
CREATE TABLE Orders (order_id SERIAL NOT NULL, number int4 NOT NULL, user_id int4 NOT NULL, value int4 NOT NULL, "date" date NOT NULL, PRIMARY KEY (order_id));
CREATE TABLE Product_Bids (Productproduct_id SERIAL NOT NULL, Bidbid_id int4 NOT NULL, productBid_id SERIAL NOT NULL, value int4 NOT NULL, start_date date NOT NULL, end_dat date NOT NULL, PRIMARY KEY (Productproduct_id, Bidbid_id, productBid_id));
CREATE TABLE Product_Orders (Productproduct_id int4 NOT NULL, Ordersorder_id int4 NOT NULL, product_order_id SERIAL NOT NULL, price int4 NOT NULL, pay_method varchar(255) NOT NULL, PRIMARY KEY (Productproduct_id, Ordersorder_id, product_order_id));
CREATE TABLE Products (product_id SERIAL NOT NULL, name varchar(255) NOT NULL, length int4 NOT NULL, width int4 NOT NULL, year int4 NOT NULL, artist varchar(255) NOT NULL, tehniq varchar(255) NOT NULL, b64code varchar(255) NOT NULL, start_value int4 NOT NULL, PRIMARY KEY (product_id));
CREATE TABLE Users (user_id SERIAL NOT NULL, name varchar(255) NOT NULL, password varchar(255) NOT NULL, email varchar(255) NOT NULL, phone_number numeric(19, 0) NOT NULL, PRIMARY KEY (user_id));
ALTER TABLE Address ADD CONSTRAINT FKAdress854198 FOREIGN KEY (Useruser_id) REFERENCES Users (user_id);
ALTER TABLE Product_Orders ADD CONSTRAINT FKProduct_Or475090 FOREIGN KEY (Ordersorder_id) REFERENCES Orders (order_id);
ALTER TABLE Product_Orders ADD CONSTRAINT FKProduct_Or468415 FOREIGN KEY (Productproduct_id) REFERENCES Products (product_id);
ALTER TABLE Orders ADD CONSTRAINT FKOrders145166 FOREIGN KEY (user_id) REFERENCES Users (user_id);
ALTER TABLE Bids ADD CONSTRAINT FKBids169750 FOREIGN KEY (user_id) REFERENCES Users (user_id);
ALTER TABLE Product_Bids ADD CONSTRAINT FKProduct_Bi532421 FOREIGN KEY (Bidbid_id) REFERENCES Bids (bid_id);
ALTER TABLE Product_Bids ADD CONSTRAINT FKProduct_Bi783075 FOREIGN KEY (Productproduct_id) REFERENCES Products (product_id);

