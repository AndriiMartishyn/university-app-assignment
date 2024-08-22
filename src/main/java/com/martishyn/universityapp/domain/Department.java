package com.martishyn.universityapp.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name  = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Lector departmentHead;

    @OneToMany(mappedBy = "department")
    private List<Lector> lectors = new ArrayList<>();

}
