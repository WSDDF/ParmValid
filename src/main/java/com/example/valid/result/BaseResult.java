package com.example.valid.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -346277396723611788L;
    private CfResult cfResult;
}
