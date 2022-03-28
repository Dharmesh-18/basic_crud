package com.example.demo.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
//        System.out.println(student);
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if(!optionalStudent.isPresent()){
            System.out.println(student);
            System.out.println(optionalStudent);
//            System.out.println("new entry to the database: "+ optionalStudent.get());
            studentRepository.save(student);
        } else {
            throw new RuntimeException(optionalStudent.get().getId() + " Id  is taken already..");
        }
    }

    public ResponseEntity<Student> getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);
        }
        throw new RuntimeException("Student with id "+ id + " not present.");
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }

    public void deleteById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new RuntimeException("Student with id " + id + " does not exists.");
        }
        else{
            studentRepository.deleteById(id);
        }
    }
}
