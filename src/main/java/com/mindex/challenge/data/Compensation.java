package com.mindex.challenge.data;

import java.time.LocalDate;

public class Compensation {

    private Employee employee;

    private int salary;

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