package com.psteide.snaketrackerapiv2.model.exception;

import java.text.MessageFormat;

public class ShedAlreadyAssignedException extends RuntimeException {

    public ShedAlreadyAssignedException(final Long shedId, final long snakeId ){
        super(MessageFormat.format("Shed: {0} is already assigned to snake: {1}", shedId, snakeId));
    }
}
