package com.cydeo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor    //will be reason explanation
@AllArgsConstructor
@Data
public class Mentor {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String batch;   // enum should be
    private boolean graduated;
    private String company;
}
