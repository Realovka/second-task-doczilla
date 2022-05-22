package com.doczilla.studenttask.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDto {
    private long id;
    private String firstName;
    private String lastName;
    private String surname;
    private Date birthday;
    private String group;
}
