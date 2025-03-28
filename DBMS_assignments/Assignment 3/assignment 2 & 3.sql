USE StoreFront;

-- Assignment 2

 -- Display the list of products (Id, Title, Count of Categories) which fall in more than one Category.
-- SELECT p.product_id, p.title, p.price,COUNT(*) AS num_category FROM product p
-- INNER JOIN product_category pd ON p.product_id = pd.product_id
-- GROUP BY p.product_id HAVING COUNT(*) > 1;


-- Display Count of products as per below price range:
-- SELECT 
-- CASE
--    WHEN p.price BETWEEN 0 AND 100 THEN '0-100'
--    WHEN p.price BETWEEN 101 AND 500 THEN '101-500'
--    ELSE 'Above 500'
-- END AS price_range,count(*) AS count 
-- FROM product p
-- GROUP BY price_range;


-- Display the Categories along with number of products under each category.
-- SELECT c.category_id,c.title,COUNT(*) AS num_products FROM category c
-- JOIN product_category pd ON c.category_id = pd.category_id
-- GROUP BY c.category_id;


-- Assignment 3

-- Display Shopper’s information along with number of orders he/she placed during last 30 days.
-- SELECT s.shopper_id,s.name,s.email,s.contact,count(*)  FROM shopper s 
-- JOIN orders o ON s.shopper_id = o.shopper_id
-- WHERE o.shopping_date >= NOW() - INTERVAL 1 MONTH
-- GROUP BY s.shopper_id;

-- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
-- SELECT s.name,o.total FROM shopper s JOIN orders o
-- ON s.shopper_id = o.shopper_id
-- WHERE o.shopping_date >= NOW() - INTERVAL 1 MONTH
-- ORDER BY o.total DESC
-- LIMIT 10;

-- Display top 20 Products which are ordered most in last 60 days along with numbers.
-- SELECT p.title,COUNT(*) AS times FROM product p JOIN order_detail od
-- ON p.product_id = od.product_id
-- JOIN orders o ON o.id = od.order_id
-- WHERE o.shopping_date >= NOW() - INTERVAL 60 DAY 
-- GROUP BY p.product_id
-- ORDER BY times DESC
-- LIMIT 20;

-- Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
-- SELECT 
--   DATE_FORMAT(date(o.shopping_date), '%Y-%m') AS month,
--   SUM(o.total) AS total_revenue
-- FROM orders o
-- GROUP BY month
-- ORDER BY month DESC;

-- Mark the products as Inactive which are not ordered in last 90 days.
-- UPDATE product
-- SET is_active = FALSE
-- WHERE product_id NOT IN (
-- SELECT od.product_id FROM order_detail od JOIN orders o ON o.id = od.order_id
-- WHERE o.shopping_date < NOW() - INTERVAL 90 day);


-- Given a category search keyword, display all the Products present in this category/categories. 
-- SELECT p.product_id,p.title FROM product p INNER JOIN product_category pd
-- ON pd.product_id = p.product_id JOIN category c On c.category_id = pd.category_id
-- WHERE c.title = 'Electronics';


-- Display top 10 Items which were cancelled most.
-- SELECT od.product_id,p.title FROM order_detail od JOIN product p
-- ON p.product_id = od.product_id
-- WHERE od.cancelled = TRUE
-- ORDER BY od.id DESC
-- LIMIT 10;

