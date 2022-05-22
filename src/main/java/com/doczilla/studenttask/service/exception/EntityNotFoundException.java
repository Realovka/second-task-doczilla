package com.doczilla.studenttask.service.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private String messageKey;
    private long id;

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public EntityNotFoundException(String messageKey, long id) {
        this.messageKey = messageKey;
        this.id = id;
    }

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
