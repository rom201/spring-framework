package com.cydeo.stereotype_annotation;

import com.cydeo.bean_annotation.FullTimeMentor;
import com.cydeo.bean_annotation.PartTimeMentor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
//  creating bean container
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);

        context.getBean(Java.class).getTeachingHours();

        context.getBean(Selenium.class).getTeachingHours();
        context.getBean(Agile.class).getTeachingHours();

//        context.getBean(PartTimeMentor.class).createAccount();
//        context.getBean(FullTimeMentor.class).createAccount();
//        Integer num = context.getBean(Integer.class);
//        System.out.println("num = " + num);


    }
}
