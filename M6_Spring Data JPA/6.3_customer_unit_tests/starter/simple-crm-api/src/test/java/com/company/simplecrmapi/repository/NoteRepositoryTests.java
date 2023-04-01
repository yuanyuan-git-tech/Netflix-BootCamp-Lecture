package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.model.Customer;
import com.company.simplecrmapi.model.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTests {

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
    public void addNote() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setNotes(new HashSet<Note>());

        customerRepo.save(customer);

        //Act...
        Note note = new Note();
        note.setContent("This is a test note");
        note.setCustomerId(customer.getId());

        note = noteRepo.save(note);

        //Assert...
        Optional<Note> note1 = noteRepo.findById(note.getId());

        assertEquals(note1.get(), note);
    }

    @Test
    public void getAllNotes() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setNotes(new HashSet<Note>());

        customerRepo.save(customer);

        //Act...
        Note note = new Note();
        note.setContent("This is a test note");
        note.setCustomerId(customer.getId());

        noteRepo.save(note);

        Note note2 = new Note();
        note2.setContent("This is the SECOND test note.");
        note2.setCustomerId(customer.getId());

        noteRepo.save(note2);

        List<Note> noteList = noteRepo.findAll();

        //Assert...
        assertEquals(2, noteList.size());
    }

    @Test
    public void updateNote() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setNotes(new HashSet<Note>());

        customerRepo.save(customer);

        //Act...
        Note note = new Note();
        note.setContent("This is a test note");
        note.setCustomerId(customer.getId());

        noteRepo.save(note);

        note.setContent("This is an updated test note");

        noteRepo.save(note);

        //Assert...
        Optional<Note> note1 = noteRepo.findById(note.getId());

        assertEquals(note1.get(), note);
    }

    @Test
    public void deleteNote() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setNotes(new HashSet<Note>());

        customerRepo.save(customer);

        Note note = new Note();
        note.setContent("This is a test note");
        note.setCustomerId(customer.getId());

        noteRepo.save(note);

        //Act...
        noteRepo.deleteById(note.getId());

        //Assert...
        Optional<Note> note1 = noteRepo.findById(note.getId());
        assertFalse(note1.isPresent());
    }
}
