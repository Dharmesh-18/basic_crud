package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService =  studentService;
    }


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){return studentService.getStudentById(id);}

    @PostMapping("/addUser")
    public void registerNewStudent(@RequestBody Student student){studentService.addNewStudent(student);}

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
    }






}
