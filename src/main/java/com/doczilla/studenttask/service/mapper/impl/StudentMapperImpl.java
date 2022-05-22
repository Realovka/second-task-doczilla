package com.doczilla.studenttask.service.mapper.impl;

import com.doczilla.studenttask.dao.entity.Student;
import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;
import com.doczilla.studenttask.service.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapperImpl implements Mapper {

    @Override
    public Student toEntity(StudentRequestDto student) {
        return Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .surname(student.getSurname())
                .birthday(Date.valueOf(student.getBirthday()))
                .group(student.getGroup())
                .build();
    }

    @Override
    public List<StudentResponseDto> toListDto(List<Student> students) {
        return students
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private StudentResponseDto toDto(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .surname(student.getSurname())
                .birthday(student.getBirthday())
                .group(student.getGroup())
                .build();
    }
}
