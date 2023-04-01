# Notes

In this activity, we will update the `simple-crm-api` to allow customers to have notes.

## Instructions

1. Open the `simple-crm-api` project in IntelliJ.

2. Add a `Note` class to the `model` package and include the following code:

   ```java
   package com.company.simplecrmapi.model;


   import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

   import javax.persistence.*;
   import java.util.Objects;

   @Entity
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @Table(name = "note")
   public class Note {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer id;
      private String content;
      private Integer customerId;


      public Integer getId() {
         return id;
      }

      public void setId(Integer id) {
         this.id = id;
      }

      public String getContent() {
         return content;
      }

      public void setContent(String content) {
         this.content = content;
      }

      public Integer getCustomerId() {
         return customerId;
      }

      public void setCustomerId(Integer customerId) {
         this.customerId = customerId;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Note)) return false;
         Note note = (Note) o;
         return Objects.equals(getId(), note.getId()) &&
                  Objects.equals(getContent(), note.getContent()) &&
                  Objects.equals(getCustomerId(), note.getCustomerId());
      }

      @Override
      public int hashCode() {
         return Objects.hash(getId(), getContent(), getCustomerId());
      }
   }
   ```

3. Now, we'll allow customers to have notes. Update the code in the `Customer` class to resemble the following:

   ```java
   package com.company.simplecrmapi.model;

   import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

   import javax.persistence.*;
   import java.util.Objects;
   import java.util.Set;

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

      @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
      private Set<Note> notes;


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

      public Set<Note> getNotes() {
         return notes;
      }

      public void setNotes(Set<Note> notes) {
         this.notes = notes;
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
                  Objects.equals(getPhone(), customer.getPhone()) &&
                  Objects.equals(getNotes(), customer.getNotes());
      }

      @Override
      public int hashCode() {
         return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getPhone(), getNotes());
      }
   }
   ```

4. Add a `NoteRepository` interface to the `repository` package and include the following code:

   ```java
   package com.company.simplecrmapi.repository;

   import com.company.simplecrmapi.model.Note;
   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;


   @Repository
   public interface NoteRepository extends JpaRepository<Note, Integer> {

   }
   ```

---

© 2023 2U. All Rights Reserved.
