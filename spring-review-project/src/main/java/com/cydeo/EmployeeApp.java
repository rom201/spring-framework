package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Employee;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {

        Employee empl1 = new Employee("Tom","IT",20);
        Employee empl2 = new Employee("Ann","BA",30);
        Employee empl3 = new Employee("Lin","PM",40);
        Employee empl4 = new Employee("Kim","SM",50);


        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        SalaryService service1 = context.getBean(SalaryService.class);
        service1.calculateRegularSalary(empl1);
        service1.calculateRegularSalary(empl2);
        service1.calculateRegularSalary(empl3);
        service1.calculateRegularSalary(empl4);

    }
}
