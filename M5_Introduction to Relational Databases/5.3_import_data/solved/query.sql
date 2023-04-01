USE customer_db;

-- Query and return all data from customer table
SELECT *
FROM customer;

-- Query and return all female customers
SELECT *
FROM customer
WHERE gender = 'Female';

-- Query and return all male customers from New Jersey
SELECT *
FROM customer
where gender = 'Male'
  AND state = 'NJ';

-- Query and return all male customers from New Jersey or Ohio
SELECT *
FROM customer
WHERE gender = 'Male'
  AND state = 'NJ' OR state = 'OH';

-- BONUS
-- Query and return all female customers from Maryland who are younger than 30 years old.
SELECT *
FROM customer
WHERE gender = 'Female'
  AND state = 'MD'
  AND age < 30;
