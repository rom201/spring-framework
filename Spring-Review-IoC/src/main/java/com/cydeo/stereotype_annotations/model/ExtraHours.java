package com.cydeo.stereotype_annotations.model;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ExtraHours {

    public Integer getExtra(){
        return 25;
    }
}
