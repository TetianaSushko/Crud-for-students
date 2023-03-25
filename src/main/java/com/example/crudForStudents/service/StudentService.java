package com.example.crudForStudents.service;

import com.example.crudForStudents.entity.Student;
import com.example.crudForStudents.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
    public void deleteById(Integer id){
        studentRepository.deleteById(id);
    }

    public Student update(Integer id, Student student) {
        return studentRepository.update(id, student);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
