package com.doczilla.studenttask.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private String surname;
    private LocalDate birthday;
    private String group;
}
