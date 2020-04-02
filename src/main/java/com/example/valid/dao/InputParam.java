package com.example.valid.dao;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
//import javax.validation.constraints.Positive;

@Data
public class InputParam {
    @Valid
    @Positive
    private Integer id;

    @Valid
    @Pattern(regexp = "^1[3|4|5|7|8]\\d{9}$", message = "格式错误")
    private String mobile;

    @Override
    public String toString() {
        return "InputParam{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
