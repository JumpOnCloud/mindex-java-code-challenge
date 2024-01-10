package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ReportingStructure getReportingStructure(String id) {

        ReportingStructure reportingStructure = new ReportingStructure();
        Employee employee = employeeService.read(id);
        reportingStructure.setEmployee(employee);

        // first count immediate number of reports, set to 0 if List of reports is null
        int totalReports = 0;

        if (employee.getDirectReports() != null) {
            List<Employee> immediateReports = employee.getDirectReports();
            totalReports = immediateReports.size();

            // account for second level of reports by looping through employee details
            for (Employee e : immediateReports) {

                // get employee data to check for direct reports
                Employee employeeDetails = employeeService.read(e.getEmployeeId());

                if ((employeeDetails.getDirectReports() != null) && !employeeDetails.getDirectReports().isEmpty()) {
                    totalReports+=employeeDetails.getDirectReports().size();
                }
            }
        }

        reportingStructure.setNumberOfReports(totalReports);

        return reportingStructure;
    }
}