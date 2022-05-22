package com.doczilla.studenttask.service.impl;

import com.doczilla.studenttask.dao.dao.StudentDao;
import com.doczilla.studenttask.dao.entity.Student;
import com.doczilla.studenttask.service.StudentService;
import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;
import com.doczilla.studenttask.service.exception.EntityNotFoundException;
import com.doczilla.studenttask.service.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.doczilla.studenttask.service.exception.ExceptionMessageValue.ENTITY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
    private final Mapper mapper;

    @Override
    public boolean create(StudentRequestDto student) {
        Student newStudent = mapper.toEntity(student);
        return studentDao.create(newStudent);
    }

    @Override
    public List<StudentResponseDto> findAll() {
        List<Student> students = studentDao.findAll();
        return mapper.toListDto(students);
    }

    @Override
    public boolean deleteById(long id) {
        studentDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND, id));
        return studentDao.deleteById(id);
    }
}
