package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);


    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Method that creates the Reporting Structure Object with the specified Employee and the number of reports
     * which is calculated with the help of getReportsPerEmployee private method
     * @param employeeId
     * @return Reporting Structure object
     */

    @Override
    public ReportingStructure getEmployeeReportingStructure(String employeeId){
        LOG.debug("Getting Reporting Structure for Employee of id [{}]", employeeId);
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);
        int numOfReports = getReportsPerEmployee(employee.getEmployeeId());
        reportingStructure.setNumberOfReports(numOfReports);
        return reportingStructure;

    
    }

    /**
     * Private helper method to get the total number of reports per employee.
     * Method uses recursion to get the number of reports under each employee and 
     * adds it up to get the total number of reports
     * @param employeeId
     * @return number of reports for the specified employeeId
     */

    private int getReportsPerEmployee(String employeeId){
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null || employee.getDirectReports()==null) {
            return 0;
        }
        // Direct reports count for current employee
        int reports = employee.getDirectReports().size();
        // Loop over the directReports List to get the reports count for subsequent employees under given employee using recursion
        for(int i = 0; i < employee.getDirectReports().size(); i++){
            String targetId = employee.getDirectReports().get(i).getEmployeeId();
            reports += getReportsPerEmployee(targetId);
        }
        return reports;
    }
	
}