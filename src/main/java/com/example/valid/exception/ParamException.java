package com.example.valid.exception;

public class ParamException extends RuntimeException {
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer code;
    public ParamException(Integer code) {
        super();
        this.code = code;
    }
}
