package com.sai.demo.student;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class inMemoryStudentDao {

    private List<Student> STUDENTS = new ArrayList<>();

    public Student save(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public List<Student> findAllStudents() {
        return STUDENTS;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(student -> student.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }


    public Student update(Student student) {

        var studentToUpdate = IntStream.range(0, STUDENTS.size())
                .filter(i -> STUDENTS.get(i).getEmail().equalsIgnoreCase(student.getEmail()))
                .findFirst()
                .orElse(-1);

        if(studentToUpdate > -1) {
            STUDENTS.set(studentToUpdate, student);
            return student;
        }

        return null;
    }

    public void deleteByEmail(String email) {

        var studentToDelete = findByEmail(email);

        if(studentToDelete != null) {
            STUDENTS.remove(studentToDelete);
        }


    }


}
