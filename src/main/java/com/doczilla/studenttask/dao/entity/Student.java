package com.doczilla.studenttask.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String surname;
    private Date birthday;
    private String group;
}
