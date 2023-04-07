package com.psteide.snaketrackerapiv2.model.exception;

import java.text.MessageFormat;

public class NoteAlreadyAssignedException extends RuntimeException {

    public NoteAlreadyAssignedException(final Long noteId, final long snakeId ){
        super(MessageFormat.format("Note: {0} is already assigned to snake: {1}", noteId, snakeId));
    }
}
