package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingStructureController {

    @Autowired
    ReportingStructureService service;

    /*
     This endpoint takes a String employee ID, fetches the employee data,
     and returns a ReportingStructure with the calculated total number of
     reports for the employee with the given ID.
     */
    @GetMapping("/reporting-structure/{id}")
    public ReportingStructure getReportingStructure(@PathVariable String id) {

        return service.getReportingStructure(id);
    }
}