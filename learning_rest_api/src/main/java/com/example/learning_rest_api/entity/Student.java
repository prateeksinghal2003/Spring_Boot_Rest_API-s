package com.example.learning_rest_api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//in database table would be formed
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private  String email;
}

//Lombok is a Java library that automatically writes repetitive code for you during compilation.
//
//You write small code → Lombok generates big code behind the scenes.
//
//What repetitive code?
//
//Normally Java classes need:
//
//getters
//
//        setters
//
//constructors
//
//        toString
//
//equals & hashCode
//
//builder pattern
//
//Instead of writing 50 lines… you write 2 lines.