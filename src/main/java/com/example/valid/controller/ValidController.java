package com.example.valid.controller;


import com.example.valid.dao.InputParam;
import com.example.valid.dao.OutPutParam;
import com.example.valid.service.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class ValidController {
    @Autowired
    private ValidService validService;

    @GetMapping(value = "valid")
    public OutPutParam valid(InputParam inputParam) {
        return validService.validTest(inputParam);
    }

}
