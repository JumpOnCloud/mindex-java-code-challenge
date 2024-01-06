package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;

    private int numberOfReports;

    public ReportingStructure() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee e) {
        employee = e;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int num) {
        numberOfReports = num;
    }
}