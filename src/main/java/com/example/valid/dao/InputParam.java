package com.example.valid.dao;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @Valid
    @Pattern(regexp = "^[1-9]\\d{7,29}$", message = "格式错误")
    private String bankNum;
    @Valid
    @NotNull
    private Test1 test1;
    @Data
    public static class Test1 {
        @Positive
        private Integer num;
    }

    @Override
    public String toString() {
        return "InputParam{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", test1=" + test1 +
                '}';
    }
}
