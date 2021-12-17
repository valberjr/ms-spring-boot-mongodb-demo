package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student create(Student student) {
        return studentRepository.insert(student);
    }

    public void delete(String id) {
        studentRepository.findById(id)
                .ifPresentOrElse(student -> {
                    studentRepository.delete(student);
                    System.out.println("Student deleted");
                }, () -> {
                    throw new IllegalStateException("Can't delete student");
                });
    }

    public void update(String id, Student student) {
        studentRepository.findById(id).ifPresentOrElse(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setEmail(student.getEmail());
            student1.setGender(student.getGender());
            student1.setAdress(student.getAdress());
            student1.getFavoriteSubjects().addAll(student.getFavoriteSubjects());
            student1.setTotalSpendInBooks(student.getTotalSpendInBooks());

            studentRepository.save(student1);
            System.out.println("Student updated");
        }, () -> {
            throw new IllegalStateException("Can't update student");
        });
    }
}
