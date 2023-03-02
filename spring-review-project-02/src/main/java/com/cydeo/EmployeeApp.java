package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        SalaryService service1 = context.getBean(SalaryService.class);
        service1.calculateRegularSalary();
        service1.calculateTotalSalary();


    }
}