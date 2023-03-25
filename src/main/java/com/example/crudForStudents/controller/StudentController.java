package com.example.crudForStudents.controller;

import com.example.crudForStudents.dto.StudentRequest;
import com.example.crudForStudents.entity.Student;
import com.example.crudForStudents.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private  StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public List<Student> getAll(){
        return studentService.findAll();
    }
    @GetMapping("/{id}")
    public Student findById( @PathVariable Integer id){
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Integer id){
        studentService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student student){
         studentService.update(id, student);
         return studentService.save(student);
    }
//    @PostMapping ("/email")
//    public Student findByEmail(@RequestBody StudentRequest dto){
////        return studentService.findByEmail(email);
//
//        String name = dto.getField1();
//        String email = dto.getField2();
//        return null;
//    }
    @PostMapping ("/email")
    public Student findByEmail(@RequestBody Student student){
        return studentService.findByEmail(student.getEmail());
    }

}
