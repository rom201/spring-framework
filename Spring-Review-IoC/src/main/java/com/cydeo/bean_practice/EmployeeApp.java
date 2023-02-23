package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigEmployee.class, ConfigAny.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();

        container.getBean(PartTimeEmployee.class).createAccount();
        
        String str1 = container.getBean("Welcome",String.class);
        System.out.println("str1 = " + str1);

        //default name in the bean method
        String str2 = container.getBean("str2",String.class);

        System.out.println("str2 = " + str2);


    }
}
