package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository regularHours;
    private final HoursRepository overtimeHours;

    public SalaryService(EmployeeRepository employeeRepository, @Qualifier ("Regular") HoursRepository regularHours,
                         @Qualifier ("Overtime") HoursRepository overtimeHours) {
        this.employeeRepository = employeeRepository;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
    }

    public void calculateRegularSalary(Employee employee){
        Integer result = employeeRepository.getHourlyRate(employee)*regularHours.getHours();
        System.out.println("Regular salary for " + employee.getName() + " is " + result);
    }

    public void calculateTotalSalary(Employee employee){
        Integer result = employeeRepository.getHourlyRate(employee)*(regularHours.getHours()+ overtimeHours.getHours());
        System.out.println("Total salary for " + employee.getName() + " is " + result);
    }

    public Integer getRegularSalary(Employee employee){
        return employeeRepository.getHourlyRate(employee)*regularHours.getHours();
    }

    public Integer getTotalSalary(Employee employee){
        return getRegularSalary(employee)+overtimeHours.getHours();
    }
}
