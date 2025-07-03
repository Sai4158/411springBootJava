package com.sai.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

        @GetMapping
        public List<students> findAllStudents() {
            return List.of(
                    new students("Sai", "Rangineeni","2004-20-2", LocalDate.now(),"sai@email.com", 19)
            );
        }



}
