package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Compensation {
	private String employeeId;
    private double salary;
    private String effectiveDate;

    public Compensation() {
    }

    public Compensation(@JsonProperty("id") String employeeId, 
    @JsonProperty("salary") double salary, @JsonProperty("date") String effectiveDate) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Compensation employeeId(String employeeId) {
        setEmployeeId(employeeId);
        return this;
    }

    public Compensation salary(double salary) {
        setSalary(salary);
        return this;
    }

    public Compensation effectiveDate(String effectiveDate) {
        setEffectiveDate(effectiveDate);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " employeeId='" + getEmployeeId() + "'" +
            ", salary='" + getSalary() + "'" +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            "}";
    }


    
}