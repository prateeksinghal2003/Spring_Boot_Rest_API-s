package com.example.learning_rest_api.repository;

import com.example.learning_rest_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//this is repo will be connected to controller

//first parameter is the  name of the entity.
public interface Student_Repo extends JpaRepository<Student,Long>
{

}
