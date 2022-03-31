package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@Validated
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
    public void registerNewStudent(@RequestBody @Valid Student student, BindingResult result){
        if (result.hasErrors())
        {
            System.out.println(result.getModel());
        }
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
    }






}
