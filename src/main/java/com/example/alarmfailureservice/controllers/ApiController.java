package com.example.alarmfailureservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/fail")
    public String fail() {
        return "Fail";
    }

}
