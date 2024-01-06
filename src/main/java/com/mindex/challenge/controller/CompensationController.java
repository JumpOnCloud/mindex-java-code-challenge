package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompensationController {

    @Autowired
    CompensationService service;

    @PostMapping("/salary")
    public Compensation create() {

        // TODO: create method in CompensationService to set salary
        // temp
        return new Compensation();
    }

    @GetMapping("/salary/{id}")
    public Compensation read(String id) {

        // TODO: create method in CompensationService to read salary by employeeId
        // temp
        return new Compensation();
    }
}