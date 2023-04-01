package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}
