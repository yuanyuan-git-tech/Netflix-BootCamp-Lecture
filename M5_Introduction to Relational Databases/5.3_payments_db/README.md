# Payments DB

In this activity, you will use joins to query payment information and associated bank information via a common bank routing number.

## Overview

The starter folder contains the SQL files to create and populate your database:

* [schema.sql](./starter/schema.sql)

* [seed.sql](./starter/seed.sql)

## Instructions

1. Open DBeaver and connect to MySQL.

2. Create the `payments`, `banks`, and `customer` tables by executing the SQL statements in `schema.sql`.

    > **Note:** Remember to refresh to see the new database and tables; newly created databases will not immediately appear.

3. Populate the tables by executing the SQL statements in `seed.sql`.

4. Write SQL statements to perform the correct join for each of the following use cases:

    > **Note:** For the joins, assume that the left table is the `payments` table and the right table is the `banks` table.

    * `INNER JOIN`: Return all payment records with matching bank routing numbers in the `banks` table.

    * `LEFT JOIN`: Return all payment records regardless if there is a matching bank routing number in the `banks` table.

    * `RIGHT JOIN`: Return all bank records regardless if there is a matching bank routing number in the `payments` table.

    * `UNION OF LEFT & RIGHT JOINS`: Return all records from both tables regardless of whether there is a matching bank routing number in either table.

    > **Hint:** You can use the common `bank_routing_number` from the `payments` and `banks` tables to join them.

5. **Bonus**: Join the `customer` table with the `payments` and `banks` tables to find the customers who have Wells Fargo bank accounts. Return the following columns:

    * `payment_id`

    * `bank_number`

    * `bank_routing_number`

    * `bank_name`

    * `first_name`

    * `last_name`

---

© 2023 2U. All Rights Reserved.
