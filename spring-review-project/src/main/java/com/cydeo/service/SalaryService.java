package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.DBEmployeeRepository;
import com.cydeo.repository.OvertimeHours;
import com.cydeo.repository.RegularHours;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    private final DBEmployeeRepository dbEmployeeRepository;
    private final RegularHours regularHours;
    private  final OvertimeHours overtimeHours;

    public SalaryService(DBEmployeeRepository dbEmployeeRepository, RegularHours regularHours, OvertimeHours overtimeHours) {
        this.dbEmployeeRepository = dbEmployeeRepository;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
    }

    public void calculateRegularSalary(Employee employee){

        Integer result = dbEmployeeRepository.getHourlyRate(employee)*(regularHours.getHours()+overtimeHours.getHours());

        System.out.println("Salary for " + employee.getName() + " is " + result);
    }



}
