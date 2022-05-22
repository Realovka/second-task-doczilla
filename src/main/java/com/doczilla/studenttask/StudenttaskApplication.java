package com.doczilla.studenttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.doczilla.dao")
public class StudenttaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudenttaskApplication.class, args);
    }

}
