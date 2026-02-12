package com.example.learning_rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//instead of getter and setter can also use
@Data

//replaces with all args constructor
@AllArgsConstructor

//should create no argument constructor
//sometimes  jpa,jackson need it.

@NoArgsConstructor

public class Student_dto
{
    private long id;
    private String name;
    private String email;

    //for "generate" to create constructors--> alt+insert
    //to select multiple fields do shift + up arrow


//    public Student_dto(long id,String name,String email) {
//        this.email = email;
//        this.name=name;
//        this.id=id;
//    }

//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
