# Write your MySQL query statement below
select product_name,year,price
FROM Product ,Sales
where Product.product_id = Sales.product_id; 
