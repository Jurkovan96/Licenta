
-- INSERT INTO Product_Orders(Productproduct_id, Ordersorder_id, price, pay_method)
--        VALUES ((select product_id from products where name='Furtuna'), (select order_id from orders where number = 1200), 5000, 'Cash');
-- INSERT INTO Product_Orders(Productproduct_id, Ordersorder_id, price, pay_method)
--        VALUES ((select product_id from products where name='Fete2'), (select order_id from orders where number = 1201), 3000, 'Cash');
--
--
-- INSERT INTO Orders(number, user_id, value, "date")
--        VALUES (1200, 1, 5000, '20-05-11');
-- INSERT INTO Orders(number, user_id, value, "date")
--        VALUES (1201, 2, 4000, '20-05-12');


INSERT INTO Adress(street, number, city, country, Useruser_id)
       VALUES ('Zugravi', 17, 'Iasi', 'Romania', 1);
INSERT INTO Adress(street, number, city, country, Useruser_id)
       VALUES ('ModaraDeFoc', 9, 'Iasi', 'Romania', 2);


INSERT INTO Product_Bids(Productproduct_id, Bidbid_id, value, start_date, end_dat)
        VALUES( (SELECT product_id from products where name='Furtuna'), 2 , 4000, '2020-03-10', '20-05-10');
INSERT INTO Product_Bids(Productproduct_id, Bidbid_id, value, start_date, end_dat)
        VALUES( (SELECT product_id from products where name='Sfinxul'), 3 , 1000, '2020-03-10', '20-05-10');

//Check run
select * from product_bids inner join bids on
product_bids.bidbid_id = bids.bid_id


INSERT INTO Bids(value, state, user_id)
        VALUES(4000, 1, 1);
INSERT INTO Bids(value, state, user_id)
        VALUES(1000, 0, 2);


INSERT INTO Products(name, length, width, year, artist, tehniq, b64code, start_value)
        VALUES ('Furtuna', 80, 80, 2015, 'V.Vasiliu', 'OilCanvas', '/static/images/img1', 2500);
INSERT INTO Products(name, length, width, year, artist, tehniq, b64code, start_value)
        VALUES ('Maiestos', 80, 80, 2017, 'V.Vasiliu', 'OilCanvas', '/static/images/img2', 3000);
INSERT INTO Products(name, length, width, year, artist, tehniq, b64code, start_value)
        VALUES ('Topile', 80, 80, 2015, 'V.Vasiliu', 'OilCanvas', '/static/images/img3', 3500);
INSERT INTO Products(name, length, width, year, artist, tehniq, b64code, start_value)
        VALUES ('Fete2', 80, 80, 2015, 'V.Vasiliu', 'OilCanvas', '/static/images/img4', 4500);
INSERT INTO Products(name, length, width, year, artist, tehniq, b64code, start_value)
        VALUES ('Sfinxul', 100, 100, 2015, 'V.Vasiliu', 'OilCanvas', '/static/images/img5', 5000);


INSERT INTO Users(name, password, email, phone_number)
VALUES ('Test1', 'test1', 'test1@test.com', 12345);
INSERT INTO Users(name, password, email, phone_number)
VALUES ('Test2', 'test2', 'test2@test.com', 54321);

