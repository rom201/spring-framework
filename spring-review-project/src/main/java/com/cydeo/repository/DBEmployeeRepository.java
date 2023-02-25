package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

//    Employee empl1 = new Employee();

    @Override
    public int getHourlyRate(Employee employee) {
//        empl1.setHourlyRate(employee.getHourlyRate());
        return employee.getHourlyRate();
//        return empl1.getHourlyRate();
    }
}
