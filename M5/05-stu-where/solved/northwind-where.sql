USE northwind;

-- List all the orders shipped to Brazil
SELECT *
FROM orders
WHERE ship_country = 'Brazil';

-- List all the orders shipped to Alice Warren or Wanda Hill
SELECT *
FROM orders
WHERE ship_name = 'Alice Warren'
OR ship_name = 'Wanda Hill';

-- List all the customers from Ohio, Iowa, and Texas
SELECT *
FROM customers
WHERE state IN('Ohio','Iowa','Texas');
