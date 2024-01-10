package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Component
public class DataBootstrap {
    private static final String EMPLOYEE_DATASTORE_PATH = "/static/employee_database.json";
    private static final String SALARY_DATASTORE_PATH = "/static/employee_salary_database.json";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream employeeInputStream = this.getClass().getResourceAsStream(EMPLOYEE_DATASTORE_PATH);
        InputStream salaryInputStream = this.getClass().getResourceAsStream(SALARY_DATASTORE_PATH);

        Employee[] employees;

        try {
            employees = objectMapper.readValue(employeeInputStream, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }

        Compensation[] salaries;

        try {
            salaries = objectMapper.readValue(salaryInputStream, Compensation[].class);
            System.out.println(Arrays.toString(salaries));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Compensation salary : salaries) {
            compensationRepository.insert(salary);
        }
    }
}