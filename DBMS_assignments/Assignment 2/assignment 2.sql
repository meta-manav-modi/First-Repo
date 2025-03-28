-- Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top. 
-- SELECT p.product_id,p.title,c.title,p.price FROM product p JOIN product_category pc
-- ON pc.product_id = p.product_id JOIN category c ON pc.category_id = c.category_id
-- WHERE p.is_active = True
-- ORDER BY p.created_at DESC;



-- Display the list of products which don't have any images.
-- SELECT product_id,title FROM product
-- WHERE product_id NOT IN(SELECT product_id FROM image);




-- Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. 
-- (If Category is top category then Parent Category Title column should display “Top Category” as value.)
-- SELECT c.category_id,c.title, COALESCE(pc.title,"Top Category") AS parent_category_title
-- FROM category c LEFT JOIN category pc
-- ON pc.category_id = c.parent_category_id
-- ORDER BY parent_category_title, c.title;




-- Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
-- SELECT c.category_id,c.title,pc.title AS parent_category_title FROM category c JOIN category pc
-- ON pc.category_id = c.parent_category_id
-- WHERE c.category_id NOT IN(SELECT parent_category_id FROM category WHERE parent_category_id IS NOT NULL);




--  Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
-- SELECT p.title,p.price,p.description FROM product p JOIN product_category pc
-- ON pc.product_id = p.product_id JOIN category c ON pc.category_id = c.category_id
-- WHERE c.title = 'Mobile';


--  Display the list of Products whose Quantity on hand (Inventory) is under 50
-- SELECT p.product_id,p.title,i.quantity FROM product p JOIN inventory i
--     ON p.product_id = i.product_id
--     WHERE i.quantity < 50;