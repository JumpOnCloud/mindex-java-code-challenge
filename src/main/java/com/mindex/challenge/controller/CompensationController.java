package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class CompensationController {

    @Autowired
    CompensationService service;

    /*
     This endpoint takes a request body containing salary details, persists
     it to the salary database, and returns a Compensation object containing
     the salary information.
     */
    @PostMapping("/salary")
    public Compensation create(@NotNull @RequestBody Compensation compensation) {

        return service.create(compensation);
    }

    /*
     This endpoint takes a String employee ID, fetches the salary data for
     the given employee, and returns a Compensation objects containing the
     salary information for the employee with the given ID.
     */
    @GetMapping("/salary/{id}")
    public Compensation read(@NotNull @PathVariable String id) {

        return service.read(id);
    }
}