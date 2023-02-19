package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

//    @Bean(name = "PT1")   //this is first way to handle
    @Bean
    @Primary
    PartTimeMentor partTimeMentor(){
        System.out.println("TM");
        return new PartTimeMentor();
    }

//    @Bean(name = "PT2")     //this is first way to handle
    @Bean
    PartTimeMentor partTimeMentor2(){
        System.out.println("TM2");
        return new PartTimeMentor();
    }



}
