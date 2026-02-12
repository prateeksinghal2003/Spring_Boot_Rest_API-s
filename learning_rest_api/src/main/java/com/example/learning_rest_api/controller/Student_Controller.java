package com.example.learning_rest_api.controller;


import com.example.learning_rest_api.dto.AddStudentRequestDto;
import com.example.learning_rest_api.dto.Student_dto;
import com.example.learning_rest_api.service.Student_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//It is a Spring Annotation
//👉 Used to create REST API Controller
//to see output http://localhost:8080/student

@RequiredArgsConstructor

public class Student_Controller
{

  //  private final Student_Repo stud_repo;

//    public Student_Controller(Student_Repo stud_repo) {
//        this.stud_repo = stud_repo;
//    }
    //Student_Repo ka bean jaaayegaa

   //earlier controller was connecting to repo , but now to service layer
    private final Student_Service studentService;

    //will handle get request
    @GetMapping("/students")
//    public Student_dto getStudent()
//    {
//        //this java object is converted to json format by http message converter
//        return  new Student_dto(41,"Prateek","prat746@gmail.com");
//    }


//    public List<Student_dto> getAllStudents(){
//        //return stud_repo.findAll();
//
//        return studentService.getAllStudents();
//    }

    // With ResponseEntity we can send multiple status codes manually.
    // Without it → Mostly 200 (unless error occurs).

    public ResponseEntity<List<Student_dto>> getAllStudents() {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    //{id} is a path variable
    @GetMapping("/students/{id}")
//    public Student_dto getStudentById(@PathVariable Long id){
//    return new Student_dto(41,"Anuj","anuj@gmail.com");
//
//        return "Path variable"+id;
//        return studentService.getStudentById(id);
//    }

    public ResponseEntity<Student_dto> getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    //to create post api's
    //we need client , use postman

    // @RequestBody
//    Take JSON from client , convert → Java Object
    public ResponseEntity<Student_dto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/students/{id}")
    //Long used because it can be null and works better with DB + Spring.

    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    //when want to change all fields of an existing object

    public ResponseEntity<Student_dto> updateStudent(@PathVariable Long id,
                                                    @RequestBody AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<Student_dto> updatePartialStudent(@PathVariable Long id,
                                                           @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }



}
