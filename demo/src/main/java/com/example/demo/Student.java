package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Adress adress;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpendInBooks;
    private LocalDateTime created;

    public Student(
            String firstName,
            String lastName,
            String email,
            Gender gender,
            Adress adress,
            List<String> favoriteSubjects,
            BigDecimal totalSpendInBooks,
            LocalDateTime created
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.adress = adress;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpendInBooks = totalSpendInBooks;
        this.created = created;
    }
}
