package com.example.learning_rest_api.service.impl;

import com.example.learning_rest_api.dto.AddStudentRequestDto;
import com.example.learning_rest_api.dto.Student_dto;
import com.example.learning_rest_api.entity.Student;
import com.example.learning_rest_api.repository.Student_Repo;
import com.example.learning_rest_api.service.Student_Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
//using this bean would be created of this class
//it tells this class is implementing some logic

@RequiredArgsConstructor
//will create constructor
public class Student_Service_imp implements Student_Service {

    private final Student_Repo studentRepo;

    //final keyword is must
    private final ModelMapper modelMapper;

    @Override
    public List<Student_dto> getAllStudents()
    {
        List<Student> students= studentRepo.findAll();
        //but return Student_dto
        //learn about streams
        List<Student_dto> student_dtoList=students.stream().map(student ->new Student_dto(student.getId(),student.getName(),student.getEmail())).toList();;
        return student_dtoList;
    }

    @Override
    public Student_dto getStudentById(Long id) {

        //learn optional class
        Student student= studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id"));

         //convert Student to Student_dto
         //will use model mapper

//        there are same fieds in student and Student_dto class
        return modelMapper.map(student, Student_dto.class);

    }

    @Override
    public Student_dto createNewStudent(AddStudentRequestDto addStudentRequestDto)
    {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepo.save(newStudent);
        return modelMapper.map(student, Student_dto.class);
    }

    @Override
    public void deleteStudentById(Long id)
    {
        if(!studentRepo.existsById(id)) {
            throw new IllegalArgumentException("Student does not exists by id: "+id);
        }
        studentRepo.deleteById(id);

    }

    @Override
    public Student_dto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        modelMapper.map(addStudentRequestDto, student);

        student = studentRepo.save(student);
        return modelMapper.map(student, Student_dto.class);
    }

    @Override
    public Student_dto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepo.save(student);
        return modelMapper.map(savedStudent, Student_dto.class);
    }
}
