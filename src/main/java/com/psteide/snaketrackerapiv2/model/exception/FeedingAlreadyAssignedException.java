package com.psteide.snaketrackerapiv2.model.exception;

import java.text.MessageFormat;

public class FeedingAlreadyAssignedException extends RuntimeException {

    public FeedingAlreadyAssignedException(final Long feedingId, final long snakeId ){
        super(MessageFormat.format("Feeding: {0} is already assigned to snake: {1}", feedingId, snakeId));
    }
}
