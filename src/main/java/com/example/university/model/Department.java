package com.example.university.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 512, unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "department")
    Set<Lector> lector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lector> getLector() {
        return lector;
    }

    public void setLector(Set<Lector> lector) {
        this.lector = lector;
    }
}
