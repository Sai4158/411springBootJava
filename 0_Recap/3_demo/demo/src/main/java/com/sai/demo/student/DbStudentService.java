package com.sai.demo.student;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("db")  // Optional: useful if you use @Qualifier
@Primary
public class DbStudentService implements StudentService {

    private final StudentRepository repository;

    public DbStudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
