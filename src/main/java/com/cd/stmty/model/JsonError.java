package com.cd.stmty.model;

public class JsonError {
    private Integer statusCode;
    private String message;


    public JsonError() {
    }

    public JsonError(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonErrorDto [statusCode=" + statusCode + ", message=" + message + "]";
    }
}
