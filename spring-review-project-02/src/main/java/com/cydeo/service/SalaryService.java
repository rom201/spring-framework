package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository regularHours;
    private final HoursRepository overtimeHours;

    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("Regular") HoursRepository regularHours,
                         @Qualifier ("Overtime") HoursRepository overtimeHours) {
        this.employeeRepository = employeeRepository;
        this.regularHours = regularHours;
        this.overtimeHours = overtimeHours;
    }
//
    public void calculateRegularSalary(){
        Integer result = employeeRepository.getHourlyRate()*regularHours.getHours();
        System.out.println("Regular salary is :" +  result);
    }

    public void calculateTotalSalary(){
        Integer result = employeeRepository.getHourlyRate()*(regularHours.getHours()+ overtimeHours.getHours());
        System.out.println("Total salary is :" + result);
    }
}


