CREATE DATABASE StoreFront;
 USE StoreFront;

 CREATE TABLE category(
     category_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
     parent_category_id INT NULL,
     FOREIGN KEY (parent_category_id) REFERENCES category(category_id)
     );

 CREATE TABLE product(
     product_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
     description TEXT,
    price DECIMAL(10,2) NOT NULL,
     is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    
    CREATE TABLE product_category(
     id INT PRIMARY KEY AUTO_INCREMENT,
     product_id INT NOT NULL,
     category_id INT NOT NULL,
     FOREIGN KEY (product_id) REFERENCES product(product_id),
     FOREIGN KEY (category_id) REFERENCES category(category_id)
     );

CREATE TABLE image(
     image_id INT PRIMARY KEY AUTO_INCREMENT,
     product_id INT NOT NULL,
     image_url VARCHAR(100) NOT NULL,
     FOREIGN KEY (product_id) REFERENCES product(product_id)
     );

CREATE TABLE shopper(
    shopper_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    contact VARCHAR(20) UNIQUE NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE inventory(
id INT PRIMARY KEY auto_increment,
quantity INT NOT NULL,
product_id INT NOT NULL,
FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    shopper_id INT NOT NULL,
    shopping_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
    );

CREATE TABLE order_detail(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    shipped BOOLEAN DEFAULT FALSE,
    completed BOOLEAN DEFAULT FALSE,
    cancelled BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
    );