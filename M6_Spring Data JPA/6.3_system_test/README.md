# System Test

In this activity, we'll use Insomnia and DBeaver to manually perform system tests.

**Note:** In this activity, we'll have a lot of windows open. We'll be running our application in IntelliJ. We'll have Insomnia open to test the application. We'll also have DBeaver open to validate the database.

## Instructions

### Setup

1. Open the `starter/simple-crm-api` project in IntelliJ.

   > In order for our system tests to work, you will need the controllers provided in the starter files.

2. Run the project to make the Simple CRM API available for testing.

3. Open Insomnia and create a new request collection called "Simple CRM".

4. Add a "Customer" folder to the "Simple CRM" request collection.

5. Under the "Customer" folder, create a new request with the following settings:

   - Request name of "Create Customer"

   - Request type of "POST"

   - Request URL of "http://localhost:8080/customers"

   - Request Body of JSON with the following data:

      ```json
      {
         "firstName": "Joe",
         "lastName": "Smith",
         "company": "BigCo",
         "phone": "111-222-3456",
         "notes": [
            {
               "content": "This is the SECOND test note.",
               "customerId": "1"
            },
            {
               "content": "This is a test note",
               "customerId": "1"
            }
         ]
      }
      ```

6. Under the "Customer" folder, create a new request with the following settings:

   - Request name of "Get All Customers"

   - Request type of "GET"

   - Request URL of "http://localhost:8080/customers"

   - Request Body is empty

7. Under the "Customer" folder, create a new request with the following settings:

   - Request name of "Update Customer"

   - Request type of "PUT"

   - Request URL of "http://localhost:8080/customers"

   - Request Body of JSON with the following data:

      ```json
      {
         "id": 1,
         "firstName": "UPDATED",
         "lastName": "Smith",
         "company": "BigCo",
         "phone": "111-222-3456"
      }
      ```

8. Under the "Customer" folder, create a new request with the following settings:

   - Request name of "Delete Customer"

   - Request type of "DELETE"

   - Request URL of "http://localhost:8080/customers/1"

   - Request Body is empty

9. Add a "Notes" folder to the "Simple CRM" request collection.

10. Under the "Notes" folder, create a new request with the following settings:

    - Request name of "Create Note"
    - Request type of "POST"
    - Request URL of "http://localhost:8080/notes"
    - Request Body of JSON with the following data:

      ```json
      {
         "customerId": 1,
         "content": "This is from create note."
      }
      ```

11. Under the "Notes" folder, create a new request with the following settings:

    - Request name of "Get All Notes"
    - Request type of "GET"
    - Request URL of "http://localhost:8080/notes"
    - Request Body is empty

12. Under the "Notes" folder, create a new request with the following settings:

    - Request name of "Update Note"
    - Request type of "PUT"
    - Request URL of "http://localhost:8080/notes"
    - Request Body of JSON with the following data:

      ```json
      {
         "id": 3,
         "content": "This is the UPDATED SECOND test note.",
         "customerId": 1
      }
      ```

13. Under the "Notes" folder, create a new request with the following settings:

    - Request name of "Delete Note"
    - Request type of "DELETE"
    - Request URL of "http://localhost:8080/notes/1"
    - Request Body is empty

14. Open DBeaver and connect to the MySQL database for "simple_crm".

### Testing

1. In Insomnia, run the "Create Customer" test under the "Customer" folder.

2. In Insomnia, verify that you receive a successful response.

3. In DBeaver, run the following SQL to validate that a customer was created in the database:

   ```sql
   select * from customer;
   ```

4. In DBeaver, run the following SQL to validate that notes were also created for your customer in the database:

   ```sql
   select * from note;
   ```

5. Repeat this process for all of the tests in Insomnia and validate the results in the database.

---

© 2023 2U. All Rights Reserved.
