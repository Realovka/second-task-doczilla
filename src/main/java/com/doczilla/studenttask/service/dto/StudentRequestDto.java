package com.doczilla.studenttask.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String group;
}
