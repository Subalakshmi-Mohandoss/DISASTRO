package com.example.disastrospringboot;

import jakarta.persistence.*;

@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int count;

    // Default constructor
    public Good() {}

    // Parameterized constructor
    public Good(Long id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for count
    public int getCount() {
        return count;
    }

    // Setter for count
    public void setCount(int count) {
        this.count =count;
    }
}
