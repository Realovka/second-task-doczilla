package com.doczilla.studenttask.service.impl;

import com.doczilla.studenttask.dao.dao.StudentDao;
import com.doczilla.studenttask.dao.entity.Student;
import com.doczilla.studenttask.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Override
    public boolean create(Student student) {
       return studentDao.create(student);
    }
}
