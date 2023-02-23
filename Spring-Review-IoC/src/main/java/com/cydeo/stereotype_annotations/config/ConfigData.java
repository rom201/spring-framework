package com.cydeo.stereotype_annotations.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = "com.cydeo.stereotype_annotations")
public class ConfigData {

    //here will be not my own class with @Bean annotation, different library

}
