package com.cd.stmty.exception;

import com.cd.stmty.model.JsonError;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private JsonError error = new JsonError();

    private Object[] arguments = new Object[0];

    public ServiceException() {
        super();
    }

    public ServiceException(Integer errorCode, String message) {
        super();
        this.error = new JsonError(errorCode, message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(JsonError error) {
        super();
        this.error = error;
    }

    public ServiceException(String message, Object... arguments) {
        super(message);
        this.arguments = arguments;
    }

    public ServiceException(String message, Throwable cause, Object... arguments) {
        super(message, cause);
        this.arguments = arguments;
    }

    public JsonError getError() {
        return error;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object... arguments) {
        this.arguments = arguments;
    }

}
