package com.example.valid.service;

import com.example.valid.dao.InputParam;
import com.example.valid.dao.OutPutParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ValidService {
    public OutPutParam validTest(InputParam inputParam) {
        System.out.println(inputParam.toString());
        OutPutParam outPutParam = new OutPutParam();
        outPutParam.setCode(200);
        return outPutParam;
    }
}
