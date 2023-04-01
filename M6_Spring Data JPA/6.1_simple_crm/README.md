# Simple CRM

In this activity, you'll practice using Spring Data JPA by building a simple CRM API.

## Instructions

1. Navigate to the [Spring Initializr webpage](http://start.spring.io).

2. Create a new project as follows:

    - Project: `Maven`

    - Language: `Java`

    - Spring Boot: `2.7.7 (SNAPSHOT)`

    - Project Metadata:

      - Group: `com.company`

      - Artifact: `city-web-service`

        >Setting the Artifact value will automatically update the values for Name and Package Name.

      - Package name: `com.company.citywebservice`

      - Packaging: `Jar`

      - Java: `8`

3. Add the following dependencies:

   - `Spring Web [WEB]`

   - `Spring Data JPA [SQL]`

   - `MySQL Driver [SQL]`

4. Click Generate Project, and download to a location of your choice.

5. Unzip the project file.

6. Open the project in IntelliJ.

7. Open the `pom.xml` file.

8. Add the following dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

   ```xml
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.13</version>
       <scope>test</scope>
   </dependency>   
   ```

9. Add the springdoc-openapi-ui dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

10. Open the `application.properties` in the `main/resources` folder and add the following configuration for the MySQL connection:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/simple_crm?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
      spring.datasource.username=root
      spring.datasource.password=password

      spring.jpa.hibernate.ddl-auto=update

      spring.jpa.show-sql=true
      ```

11. Add a new `com.company.simplecrmapi.model.Customer.java` class to the project. Add the following code to the `Customer` class:

      ```java
      package com.company.simplecrmapi.model;

      import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

      import javax.persistence.*;
      import java.util.Objects;

      @Entity
      @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
      @Table(name="customer")
      public class Customer {

         @Id
         @GeneratedValue(strategy = GenerationType.AUTO)
         private Integer id;
         private String firstName;
         private String lastName;

         private String company;
         private String phone;

         public Integer getId() {
            return id;
         }

         public void setId(Integer id) {
            this.id = id;
         }

         public String getFirstName() {
            return firstName;
         }

         public void setFirstName(String firstName) {
            this.firstName = firstName;
         }

         public String getLastName() {
            return lastName;
         }

         public void setLastName(String lastName) {
            this.lastName = lastName;
         }

         public String getCompany() {
            return company;
         }

         public void setCompany(String company) {
            this.company = company;
         }

         public String getPhone() {
            return phone;
         }

         public void setPhone(String phone) {
            this.phone = phone;
         }

         @Override
         public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
            Customer customer = (Customer) o;
            return Objects.equals(getId(), customer.getId()) &&
                     Objects.equals(getFirstName(), customer.getFirstName()) &&
                     Objects.equals(getLastName(), customer.getLastName()) &&
                     Objects.equals(getCompany(), customer.getCompany()) &&
                     Objects.equals(getPhone(), customer.getPhone());
         }

         @Override
         public int hashCode() {
            return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getPhone());
         }
      }
      ```

12. Add a `CustomerRepository` interface to the `repository` package and include the following code:

      ```java
      package com.company.simplecrmapi.repository;

      import com.company.simplecrmapi.model.Customer;
      import org.springframework.data.jpa.repository.JpaRepository;
      import org.springframework.stereotype.Repository;

      import java.util.List;


      @Repository
      public interface CustomerRepository extends JpaRepository<Customer, Integer> {

      }
      ```

---

© 2023 2U. All Rights Reserved.
