package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

// Assume it comming from DB

    @Override
    public int getHourlyRate() {
        Employee employee1 = new Employee("Rom", "IT", 65);
        return employee1.getHourlyRate();
    }
}
