package com.example.valid.service;

import com.example.valid.dao.InputParam;
import com.example.valid.dao.OutPutParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ValidServiceTest {
    @Resource
    ValidService validService;

    @Test
    public void test() {
        System.out.println("rebase master");
        InputParam inputParam = new InputParam();
        inputParam.setId(0);
        inputParam.setMobile("1");
        InputParam.Test1 test1 = new InputParam.Test1();
        test1.setNum(0);
        inputParam.setTest1(test1);
        OutPutParam outPutParam = validService.validTest(inputParam);

//        System.out.println(outPutParam);
//        return outPutParam;
    }
}
