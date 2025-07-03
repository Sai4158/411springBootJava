package com.sai.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InMemoryStudentService implements StudentService {

    private final inMemoryStudentDao dao;

    public InMemoryStudentService(inMemoryStudentDao dao) {
        this.dao = dao;
    }


    @Override
    public Student save(Student student) {
        return this.dao.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return this.dao.findAllStudents();
    }

    @Override
    public Student findByEmail(String email) {
        return this.dao.findByEmail(email);
    }

    @Override
    public Student update(Student student) {
        return this.dao.update(student);
    }

    @Override
    public void deleteByEmail(String email) {
        dao.deleteByEmail(email);
    }
}
