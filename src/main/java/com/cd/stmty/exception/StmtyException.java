package com.cd.stmty.exception;

import com.cd.stmty.common.BaseStatusError;

public class StmtyException extends RuntimeException {

    private static final long serialVersionUID = 5926563242473060260L;
    protected String messageCode;

    public StmtyException(Exception e) {
        super(e);
    }

    public StmtyException(String messageCode, String messageContent) {
        super(messageContent);
        this.messageCode = messageCode;
    }

    public StmtyException(BaseStatusError baseStatusError) {
        super(baseStatusError.getMessage());
        this.messageCode = baseStatusError.getCode();
    }

    public StmtyException(String messageContent) {
        super(messageContent);
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
