package com.psteide.snaketrackerapiv2.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super(MessageFormat.format("Could not find resource with id: {0}", id));
    }
}
