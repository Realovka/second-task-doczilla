package com.doczilla.studenttask.service.mapper;

import com.doczilla.studenttask.dao.entity.Student;
import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;

import java.util.List;

public interface Mapper {

    Student toEntity(StudentRequestDto student);

    List<StudentResponseDto> toListDto(List<Student> students);

}
