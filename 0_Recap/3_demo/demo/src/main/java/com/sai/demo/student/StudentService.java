package com.sai.demo.student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAllStudents();

    Student findByEmail(String email);

    Student update(Student student);

    void deleteByEmail(String email);
}
