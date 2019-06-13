package com.cd.stmty.model;

import com.cd.stmty.common.BaseStatusError;
import com.cd.stmty.exception.ServiceException;
import com.cd.stmty.exception.StmtyException;
import org.apache.http.HttpStatus;
import org.springframework.core.style.ToStringCreator;

public class ApiResponse<T> {
    public static final String STATUS_COMPLETED = String.valueOf(HttpStatus.SC_OK);
    public static final String MESSAGE_COMPLETED = "Request completed !";

    private String code;
    private String message;
    private T data;

    public ApiResponse() {
        this.code = STATUS_COMPLETED;
        this.message = MESSAGE_COMPLETED;
    }

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiResponse(StmtyException e) {
        this.code = e.getMessageCode();
        this.message = e.getMessage();
    }

    public ApiResponse(BaseStatusError statusError) {
        this.code = statusError.getCode();
        this.message = statusError.getMessage();
    }

    public ApiResponse(String code, T data) {
        this.code = code;
        this.message = MESSAGE_COMPLETED;
        this.data = data;
    }

    public ApiResponse(ServiceException se) {
        this.code = se.getError().getStatusCode().toString();
        this.message = se.getError().getMessage();
    }

    public ApiResponse(T data) {
        this.code = STATUS_COMPLETED;
        this.message = MESSAGE_COMPLETED;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public ApiResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ApiResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("SimpleResponse{")

                .append("code='", code)

                .append("'\', data='", data)

                .append("'\', message='", message)

                .append("'\'}")

                .toString();
    }
}
