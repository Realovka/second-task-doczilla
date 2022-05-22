package com.doczilla.studenttask.controller;

import com.doczilla.studenttask.service.StudentService;
import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody StudentRequestDto student) {
        studentService.create(student);
    }

    @GetMapping
    public List<StudentResponseDto> findAll() {
        return studentService.findAll();
    }
}
