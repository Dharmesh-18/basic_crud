package com.example.demo.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        return List.of(new Student(1L, "abc", "abc@xyz.com"));
    }


}
