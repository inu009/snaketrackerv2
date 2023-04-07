package com.psteide.snaketrackerapiv2.repository;

import com.psteide.snaketrackerapiv2.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
