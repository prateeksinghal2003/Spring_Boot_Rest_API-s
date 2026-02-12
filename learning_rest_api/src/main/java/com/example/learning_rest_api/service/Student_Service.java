package com.example.learning_rest_api.service;

import com.example.learning_rest_api.dto.AddStudentRequestDto;
import com.example.learning_rest_api.dto.Student_dto;

import java.util.List;
import java.util.Map;

public interface Student_Service
{
     List<Student_dto> getAllStudents();

     Student_dto getStudentById(Long id);

     Student_dto createNewStudent(AddStudentRequestDto addStudentRequestDto);

     void deleteStudentById(Long id);

     Student_dto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

     Student_dto updatePartialStudent(Long id, Map<String, Object> updates);
}
