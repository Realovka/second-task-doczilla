package com.doczilla.studenttask.controller.advice;

import com.doczilla.studenttask.service.exception.EntityNotFoundException;
import com.doczilla.studenttask.service.exception.Message;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public RestResponseEntityExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Message> handleEntityNotFound(EntityNotFoundException ex) {
        long value = ex.getId();
        String message = ex.getMessageKey();
        return new ResponseEntity<>(new Message(message, value), HttpStatus.NOT_FOUND);
    }
}
