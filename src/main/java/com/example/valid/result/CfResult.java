package com.example.valid.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class CfResult implements Serializable {
    private static final long serialVersionUID = 4290385072685187043L;
    private Boolean success;
    private Integer code;
    private String msg;
}
