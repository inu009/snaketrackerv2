package com.psteide.snaketrackerapiv2.model.dto;

import com.psteide.snaketrackerapiv2.model.Note;
import lombok.Data;

import java.util.Objects;

@Data
public class NoteDto {
    private Long id;
    private String date;
    private String note;
    //private PlainSnakeDto plainSnakeDto;

    public static NoteDto from(Note note){
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setDate(note.getDate());
        noteDto.setNote(note.getNote());
        //if(Objects.nonNull(note.getSnake())){
        //  noteDto.setPlainSnakeDto(PlainSnakeDto.from(note.getSnake()));
        //}
        return noteDto;
    }
}