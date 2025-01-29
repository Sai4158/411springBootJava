package psu.edu.crudDemoEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    // Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

}

