package com.psteide.snaketrackerapiv2.model;

import javax.persistence.*;

import com.psteide.snaketrackerapiv2.model.dto.NoteDto;
import lombok.Data;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String note;
    @ManyToOne
    private Snake snake;

    public static Note from(NoteDto noteDto){
        Note note = new Note();
        note.setDate(noteDto.getDate());
        note.setNote(noteDto.getNote());
        return note;
    }
}
