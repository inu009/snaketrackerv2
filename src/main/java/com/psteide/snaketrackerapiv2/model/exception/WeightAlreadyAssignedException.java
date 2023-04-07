package com.psteide.snaketrackerapiv2.model.exception;

import java.text.MessageFormat;

public class WeightAlreadyAssignedException extends RuntimeException {

    public WeightAlreadyAssignedException(final Long weightId, final long snakeId ){
        super(MessageFormat.format("Weight: {0} is already assigned to snake: {1}", weightId, snakeId));
    }
}
