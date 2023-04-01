# Mortgage DB

In this activity, you will use joins to query sales and mortgage data.

## Overview

The starter folder contains the SQL files to create and populate your database:

* [schema.sql](./starter/schema.sql)

* [seed.sql](./starter/seed.sql)

## Instructions

1. Open DBeaver and connect to MySQL.

2. Execute the SQL statements in `schema.sql` to create the `mortgage_db` database.

    > **Note:** Remember to refresh to see the new database and tables; newly created databases will not immediately appear.

3. Execute the SQL statements in `seed.sql` to populate the tables.

4. Execute the following SQL, and note that both the `sales` table and the `mortgage` table have matching values within the `mortgage_id` column&mdash;so we can use the `mortgage_id` column to join these tables together:

    ```sql
    USE mortgage_db;

    -- Query all records from sales table
    SELECT *
    FROM sales;

    -- Query all records from mortgage table
    SELECT *
    FROM mortgage;
    ```

5. Execute the following query to `inner join` the two tables:

    ```sql
    -- Perform an INNER JOIN on the two tables
    SELECT
      sales.sales_id,
      sales.payment_id,
      sales.mortgage_id,
      sales.loan_amount,
      sales.loan_date,
      mortgage.mortgage_id,
      mortgage.mortgage_name,
      mortgage.mortgage_rate
    FROM sales
    INNER JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id;
    ```

    Note that the `INNER JOIN` clause in the previous query can be simplified by using aliases in place of the table names.  To do so we use the SQL keyword `AS` to create the aliases, which serve a temporary replacement names which can be used only throughout the rest of the query.
    
    Using aliases is not required, but it can reduce the amount of typing we have to do. The following SQL is the same as the previous SQL, but using aliases. By using `sales as a` and `mortgage as b` we can then use `a` and `b` respectively in place of `sales` and `mortgage` throughout the rest of the query:

    ```sql
    -- Perform an INNER JOIN on the two tables with aliasing
    SELECT
      a.sales_id,
      a.payment_id,
      a.mortgage_id,
      a.loan_amount,
      a.loan_date,
      b.mortgage_id,
      b.mortgage_name,
      b.mortgage_rate
    FROM sales as a
    INNER JOIN mortgage as b ON a.mortgage_id = b.mortgage_id;
    ```

    Remember that we can specify the columns to return or use `*` to return all columns. The following SQL is the same as the previous SQL, but returns all columns:

    ```sql
    -- Perform an INNER JOIN and return all columns
    SELECT *
    FROM sales
    INNER JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id  
    ```

6. A left join returns all records from the left table and the matched records from the right table. Unmatched left-side records will contain NULL values for right-side columns. Execute the following query to left-join the two tables:

    ```sql
    -- Perform a LEFT JOIN and return all columns
    SELECT *
    FROM sales
    LEFT JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id;
    ```

7. Remember that a right join returns all records from the right table and the matched records from the left table. Unmatched right-side records will contain NULL values for left-side columns. Execute the following query to `right join` the two tables:

    ```sql
    -- Perform a RIGHT JOIN and return all columns
    SELECT *
    FROM sales
    RIGHT JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id;
    ```

8. Execute the following query to perform a full outer join on the two tables:

    * `FULL OUTER JOIN` returns all records from the left and right tables, displaying both matched records and unmatched records with NULL values.

    * MySQL does not support full outer joins, so the following query will not work in MySQL:

      ```sql
      -- Perform a FULL OUTER JOIN and return all columns
      SELECT *
      FROM sales
      FULL OUTER JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id;
      ```

    * In MySQL you can get the same results as a full outer join by combining the results of the `LEFT JOIN` and `RIGHT JOIN` using the following query:

      ```sql
      -- Perform a UNION of LEFT JOIN & RIGHT JOIN, and return all columns
      SELECT *
      FROM sales
      LEFT JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id
      UNION
      SELECT *
      FROM sales
      RIGHT JOIN mortgage ON sales.mortgage_id = mortgage.mortgage_id;
      ```

    * Here the keyword `UNION` is used to combine the results of the `LEFT JOIN` and the `RIGHT JOIN` while removing any duplicates.  We are able to use `UNION` here because the two queries being combined have the same result structure, in this case with both using `SELECT * from sales`.

---

© 2023 2U. All Rights Reserved.
