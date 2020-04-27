package com.example.alarmfailureservice.controllers;

import com.example.alarmfailureservice.services.FailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ApiController {

    private final FailService service;

    public ApiController(FailService service) {
        this.service = service;
    }

    @GetMapping("/api/{number}")
    public ResponseEntity<String> api(@PathVariable Long number) {
        if (number % 2 == 0) {
            return ResponseEntity.ok("EVEN NUMBER");
        } else {
            service.registerFailureTime(System.currentTimeMillis());
            return ResponseEntity.ok("ODD NUMBER");
        }
    }

}
