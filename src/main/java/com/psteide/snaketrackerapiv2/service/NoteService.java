package com.psteide.snaketrackerapiv2.service;

import com.psteide.snaketrackerapiv2.model.exception.ResourceNotFoundException;
import com.psteide.snaketrackerapiv2.repository.NoteRepository;
import com.psteide.snaketrackerapiv2.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getNotes() {
        return StreamSupport
                .stream(noteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Note getNote(Long id) {
        return noteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

    public Note deleteNote(Long id) {
        Note note = getNote(id);
        noteRepository.delete(note);
        return note;
    }

    @Transactional
    public Note editNote(Long id, Note note) {
        Note noteToEdit = getNote(id);
        noteToEdit.setDate(note.getDate());
        noteToEdit.setNote(note.getNote());
        return noteToEdit;
    }
}

    