USE payments_db;

-- Perform an INNER JOIN
SELECT
  *
FROM payments AS a
INNER JOIN banks AS b ON a.bank_routing_number = b.bank_routing_number;

-- Perform a LEFT JOIN
SELECT
  *
FROM payments AS a
LEFT JOIN banks AS b ON a.bank_routing_number = b.bank_routing_number;

-- Perform a RIGHT JOIN
SELECT
  *
FROM payments AS a
RIGHT JOIN banks AS b ON a.bank_routing_number = b.bank_routing_number;

-- Perform a UNION of LEFT JOIN & RIGHT JOIN, and return all columns
SELECT *
FROM payments AS a
LEFT JOIN banks AS b ON a.bank_routing_number = b.bank_routing_number
UNION
SELECT *
FROM payments AS a
RIGHT JOIN banks AS b ON a.bank_routing_number = b.bank_routing_number;

-- BONUS
SELECT
  a.payment_id,
  a.bank_number,
  a.bank_routing_number,
  b.bank_name,
  c.first_name,
  c.last_name
FROM payments AS a
INNER JOIN banks AS b ON a.bank_routing_number = b.bank_routing_number
INNER JOIN customer AS c ON a.customer_id = c.customer_id;
