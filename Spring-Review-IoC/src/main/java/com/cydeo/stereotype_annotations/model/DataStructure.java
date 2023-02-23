package com.cydeo.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
@Data
public class DataStructure {

    @NonNull
    ExtraHours extraHours;

//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }
    public void getTotalHours(){
        System.out.println("Total hours : " + (20 + extraHours.getExtra()));

    }
}
