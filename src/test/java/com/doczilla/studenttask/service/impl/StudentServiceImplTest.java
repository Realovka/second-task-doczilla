package com.doczilla.studenttask.service.impl;

import com.doczilla.studenttask.dao.dao.StudentDao;
import com.doczilla.studenttask.dao.entity.Student;
import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;
import com.doczilla.studenttask.service.exception.EntityNotFoundException;
import com.doczilla.studenttask.service.mapper.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    private StudentServiceImpl studentService;
    @Mock
    private StudentDao studentDao;
    @Mock
    private Mapper mapper;
    private StudentRequestDto studentRequestDto;
    private StudentResponseDto studentResponseDto;
    private Student student;
    private Student secondStudent;
    private List<StudentResponseDto> studentResponseDtos;
    private List<Student> students;

    @BeforeEach
    public void setUp() {
        studentService = new StudentServiceImpl(studentDao, mapper);
        studentRequestDto = new StudentRequestDto("Ivan", "Ivanov", "Ivanovich", LocalDate.of(2000, 6, 2), "a1");
        studentResponseDto = new StudentResponseDto(1L,"Sidor", "Sidorov", "Sidorovich", Date.valueOf("2000-5-1"), "a1");
        student = new Student(1L, "Ivan", "Ivanov", "Ivanovich", Date.valueOf("2000-6-2"), "a1");
        secondStudent = new Student(1L, "Sidor", "Sidorov", "Sidorovich", Date.valueOf("2000-5-1"), "a1");
        studentResponseDtos = List.of(studentResponseDto);
        students = List.of(secondStudent);
    }

    @Test
    void createTest() {
        when(mapper.toEntity(studentRequestDto)).thenReturn(student);
        when(studentDao.create(student)).thenReturn(1L);
        long actual = studentService.create(studentRequestDto);
        assertEquals(1L, actual);
    }

    @Test
    void findAllTest() {
        when(studentDao.findAll()).thenReturn(students);
        when(mapper.toListDto(students)).thenReturn(studentResponseDtos);
        List<StudentResponseDto> actual = studentService.findAll();
        assertEquals(studentResponseDtos, actual);
    }

    @Test
    void deleteByIdTest() {
        when(studentDao.findById(1L)).thenReturn(Optional.ofNullable(student));
        when(studentDao.deleteById(1L)).thenReturn(true);
        boolean actual = studentService.deleteById(1L);
        assertTrue(actual);
    }

    @Test
    void deleteByIdThrowEntityNotFoundException() {
        assertThrows(EntityNotFoundException.class, () -> studentService.deleteById(100L));
    }
}