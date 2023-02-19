package com.cydeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.SocketTimeoutException;

public class DealerApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCar.class);

        Car c = context.getBean(Car.class);
        Person p = context.getBean(Person.class);


        System.out.println("Name "+p.getName());
        System.out.println("Car make: "+c.getMake());
        System.out.println("Persons car is: "+p.getCar().getMake());



    }
}
