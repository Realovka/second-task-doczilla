package com.doczilla.studenttask.service;

import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    long create(StudentRequestDto student);

    List<StudentResponseDto> findAll();

    boolean deleteById(long id);
}
