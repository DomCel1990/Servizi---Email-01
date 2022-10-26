package com.example.email1.services;

import com.example.email1.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    static List<Student> students = Arrays.asList(
            new Student("1", "Domenico", "Celani", "////////////////"),
            new Student("2", "Francesco", "Petrella", "petrella.45@gmail.com"),
            new Student("4", "Giuseppe", "Verdi", "giuseppeverdi@gmail.com"),
            new Student("4", "Domini", "Celiuj", "dominicel@gmail.com")
    );

    public Student getStudentBtId(String id) {
        Optional<Student> student = students.stream().filter(student1 -> student1.getId().equals(id)).findAny();
        return student.orElse(null);
    }
}
