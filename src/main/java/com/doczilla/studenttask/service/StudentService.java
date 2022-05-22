package com.doczilla.studenttask.service;

import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    boolean create(StudentRequestDto student);

    List<StudentResponseDto> findAll();
}
