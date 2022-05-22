package com.doczilla.studenttask.dao.dao;

import com.doczilla.studenttask.dao.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    long create(Student student);

    List<Student> findAll();

    Optional<Student> findById(long id);

    boolean deleteById(long id);
}
