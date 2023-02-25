package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository, HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(Employee employee){
        Integer result = employeeRepository.getHourlyRate(employee)*hoursRepository.getHours();
        System.out.println("Salary for " + employee.getName() + " is " + result);
    }



}
