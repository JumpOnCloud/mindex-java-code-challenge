package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Compensation {

    Employee employee;

    private int salary;

//    @DateTimeFormat(pattern = "yyyyMMdd")
//    @JsonDeserialize(using = DateDeserializer.class)
    @JsonProperty("effectiveDate")
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate effectiveDate;

    public Compensation() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee e) {
        employee = e;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int amount) {
        salary = amount;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate date) {
        effectiveDate = date;
    }
}