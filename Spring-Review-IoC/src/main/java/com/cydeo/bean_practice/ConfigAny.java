package com.cydeo.bean_practice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigAny {

    @Bean(name = "Welcome")
    public String str1 (){
        return " Welcome to CydeoApp";
    }

    @Bean
//    @Primary
    public String str2 (){
        return " Spring Core Practice";
    }


}
