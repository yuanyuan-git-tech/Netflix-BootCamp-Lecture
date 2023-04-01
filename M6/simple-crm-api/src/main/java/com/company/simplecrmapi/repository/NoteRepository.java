package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
}
