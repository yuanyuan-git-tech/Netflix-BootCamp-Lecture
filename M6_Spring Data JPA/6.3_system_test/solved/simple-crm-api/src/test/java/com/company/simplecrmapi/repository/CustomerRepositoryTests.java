package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.model.Customer;
import com.company.simplecrmapi.model.Note;
import com.company.simplecrmapi.repository.CustomerRepository;
import com.company.simplecrmapi.repository.NoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    NoteRepository noteRepo;

    @Before
    public void setUp() throws Exception {
        noteRepo.deleteAll();
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setNotes(new HashSet<Note>());

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getAllCustomers() {
        //Arrange...

        //Act...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");

        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer.setFirstName("Bob");
        customer.setLastName("Marley");
        customer.setPhone("222-333-4567");
        customer.setCompany("Independent");

        customerRepo.save(customer2);

        List<Customer> customerList = customerRepo.findAll();

        //Assert...
        assertEquals(2, customerList.size());
    }

    @Test
    public void updateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setNotes(new HashSet<Note>());

        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");

        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }
}
