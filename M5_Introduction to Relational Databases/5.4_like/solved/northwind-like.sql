USE northwind;

-- List all customers with last names that start with 'Si'.
SELECT *
FROM customers
WHERE last_name
LIKE 'Si%';

-- List all employees with .edu email addresses.
SELECT *
FROM employees
WHERE email
LIKE '%.edu';
