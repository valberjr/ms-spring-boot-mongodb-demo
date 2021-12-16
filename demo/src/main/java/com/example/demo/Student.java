package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
    private ZonedDateTime created;
}
