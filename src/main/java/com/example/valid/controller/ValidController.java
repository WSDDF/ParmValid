package com.example.valid.controller;


import com.example.valid.dao.InputParam;
import com.example.valid.dao.OutPutParam;
import com.example.valid.service.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "test")
public class ValidController {
    @Autowired
    private ValidService validService;

    @PostMapping(value = "valid")
    public OutPutParam valid(@RequestBody InputParam inputParam) {
        System.out.println(validService.testOther(inputParam.getTest1()));
        System.out.println(inputParam.getTest1());
        return validService.validTest(inputParam);
    }

}
