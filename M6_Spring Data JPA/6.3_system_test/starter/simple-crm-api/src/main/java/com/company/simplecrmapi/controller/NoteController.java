package com.company.simplecrmapi.controller;

import com.company.simplecrmapi.model.Note;
import com.company.simplecrmapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    @Autowired
    NoteRepository repo;

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return repo.findAll();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable int id) {

        Optional<Note> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public Note addNote(@RequestBody Note Note) {
        return repo.save(Note);
    }

    @PutMapping("/notes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNote(@RequestBody Note Note) {
        repo.save(Note);
    }

    @DeleteMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable int id) {
        repo.deleteById(id);
    }
}
