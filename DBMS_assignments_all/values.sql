USE StoreFront;
INSERT INTO category(title,parent_category_id) VALUES
  ('ELECTRONICS',NULL),
  ('Home Devices',NULL),
  ('Fashion',NULL);

INSERT INTO category(title,parent_category_id) VALUES
  ('Mobile',1),
  ('Laptop',1),
  ('Tv',2),
  ('AC',2),
  ('Clothes',3),
  ('Makeup',3);

INSERT INTO category(title,parent_category_id) VALUES
  ('Smartphone',4),
  ('Gaming',5),
  ('Office_use',5),
  ('LED',6),
  ('LCD',6),
  ('Split',7),
  ('Window',7),
  ('Men',8),
  ('Women',8),
  ('Eye',9),
  ('Face',9);

INSERT INTO product(title,description,price,is_active) VALUES
('Himalyan ','oil removal',60,TRUE),
('Nivya syrum','Glow skin',200,TRUE),
('iPhone 15','Latest Apple smartphone',100000,TRUE),
('samsung Galaxy S23','Premium samsung smartphone',60000,TRUE),
('Dell xp 13','High performance',65000,TRUE),
('Denim Jeans','new stylist jeans',1000,TRUE),
('Denim Jeans','new stylist jeans',1000,TRUE),
('Sony LCD','Quality effcient',20000,TRUE);


INSERT INTO product_category(product_id,category_id) VALUES
(3,10),(3,1),(3,4),(1,20),(1,3),(4,10),(4,1);


INSERT INTO image(product_id,image_url) VALUES
  (1,"iPhone15.jpg"),
  (2,"galaxy_s23.jpg"),
  (3,"dell_xps.jpg"),
  (4,"sony_lcd.jpg");

INSERT INTO inventory(product_id,quantity) VALUE
  (1,10),
  (2,13),
  (3,3),
  (4,30);

INSERT INTO shopper(name,email,contact) VALUES
    ("manav","manavmodi.com",3456784838),
    ("modi","modi12345.com",1234543210),
    ('bharat','bharat12.com','9767538919');

INSERT INTO orders(shopper_id,total) VALUES
    (1, 220000),
    (1,1000),
    (2, 105000),
    (2,500000),
    (2,20000);

INSERT INTO orders(shopper_id,shopping_date,total) VALUES
(3,'2025-02-26 16:05:20',40),
(3,'2025-01-26 16:05:20',400);

INSERT INTO order_detail(order_id,product_id,quantity,price,shipped) VALUES
	(3,5,2,2000,TRUE),
	(3,5,1,1000,TRUE),
    (1,1,1,100000,TRUE),
    (2,3,1,65000,TRUE),
    (2,4,2,40000,TRUE),
    (1,2,2,120000,TRUE),
    (2,3,1,100000,FALSE),
    (5,5,1,65000,FALSE),
    (5,1,1,60,FALSE);


