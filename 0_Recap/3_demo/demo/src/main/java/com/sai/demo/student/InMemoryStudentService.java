package com.sai.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InMemoryStudentService implements StudentService {

    @Override
    public Student save(Student student) {
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        return List.of(
                new Student("Sai", "Rangineeni", "2004-02-20", LocalDate.of(2004, 2, 20), "sai@email.com", 19)
        );
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return student;
    }

    @Override
    public void deleteByEmail(String email) {
    }
}
