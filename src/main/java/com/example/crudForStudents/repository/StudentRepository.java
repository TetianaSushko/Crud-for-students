package com.example.crudForStudents.repository;

import com.example.crudForStudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    default Student update(Integer id, Student student){
            student.setName(student.getName());
            student.setEmail(student.getEmail());
            return student;
    }

    Student findByEmail(String email);
}