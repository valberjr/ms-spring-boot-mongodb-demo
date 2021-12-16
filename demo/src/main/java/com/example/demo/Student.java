package com.example.demo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Adress adress;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpendInBooks;
    private ZonedDateTime created;
}
