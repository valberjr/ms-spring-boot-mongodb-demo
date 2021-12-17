package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Adress adress = new Adress(
                    "England",
                    "London",
                    "NE9"
            );

            String email = "jess@email.com";
            Student student = new Student(
                    "Jess",
                    "P",
                    email,
                    Gender.FEMALE,
                    adress,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            repository.findStudentByEmail(email)
                    .ifPresentOrElse(s -> System.out.println(s + " already exists"), () -> {
                        System.out.println("Inserting student " + student);
                        repository.insert(student);
                    });
        };
    }

}
