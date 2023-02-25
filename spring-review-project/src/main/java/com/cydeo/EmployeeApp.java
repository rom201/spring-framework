package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Employee;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {

        Employee empl1 = new Employee();
        empl1.setName("Tom");
        empl1.setDepartment("IT");
        empl1.setHourlyRate(30);


        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        SalaryService service1 = context.getBean(SalaryService.class);
        service1.calculateRegularSalary(empl1);

    }
}
