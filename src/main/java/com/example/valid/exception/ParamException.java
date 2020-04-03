package com.example.valid.exception;

public class ParamException extends RuntimeException {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer code;
    public String message;
    public ParamException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
