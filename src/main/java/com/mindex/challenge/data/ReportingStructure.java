package com.mindex.challenge.data;


public class ReportingStructure {
	private int numberOfReports;
    private Employee employee;

    public ReportingStructure() {
    }

    public ReportingStructure(int numberOfReports, Employee employee) {
        this.numberOfReports = numberOfReports;
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return this.numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ReportingStructure numberOfReports(int numberOfReports) {
        setNumberOfReports(numberOfReports);
        return this;
    }

    public ReportingStructure employee(Employee employee) {
        setEmployee(employee);
        return this;
    }

 
    @Override
    public String toString() {
        return "{" +
            " numberOfReports='" + getNumberOfReports() + "'" +
            ", employee='" + getEmployee() + "'" +
            "}";
    }

}