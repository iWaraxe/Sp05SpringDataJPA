package com.coherentsolutions.spring.school.section12orm;


import jakarta.persistence.*;

@Entity
@Table(name = "users") // Specify the table name if different from the class name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    @Column(name = "id") // Optional: Specify the column name if different from the field name
    private int id;

    @Column(name = "name", nullable = false) // Map the field to the 'name' column and make it non-nullable
    private String name;

    @Column(name = "email", nullable = false, unique = true) // Map the field to the 'email' column, make it non-nullable, and unique
    private String email;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
