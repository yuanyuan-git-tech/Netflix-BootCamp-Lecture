USE northwind;

-- list all the discontinued products with the highest list price first
SELECT * FROM products
WHERE discontinued = 1
ORDER BY list_price desc;

-- list the company, first name, and last name of all the customers sorted by company, last name, and first name
SELECT
    company, first_name, last_name
FROM customers
ORDER BY company, last_name, first_name;

-- list the department, job title, first name, and last name of all the employees sorted by department, job title, last name, and first name
SELECT
    department, job_title, first_name, last_name
FROM employees
ORDER BY department, job_title, last_name, first_name;

-- list the ship name, ship city, order date, and shipped date of all the orders that are complete with the most recent shipped date first
SELECT
	ship_name, ship_city, order_date, shipped_date
FROM orders
WHERE order_status = 'Complete'
ORDER BY shipped_date desc;
