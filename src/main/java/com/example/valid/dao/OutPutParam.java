package com.example.valid.dao;

import com.example.valid.result.BaseResult;
import lombok.Data;

import java.io.Serializable;

@Data
public class OutPutParam extends BaseResult implements Serializable {
    private static final long serialVersionUID = 351045202655920584L;
    private String message;
}
