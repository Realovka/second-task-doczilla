package com.doczilla.studenttask.dao.dao;

import com.doczilla.studenttask.dao.entity.Student;

import java.util.List;

public interface StudentDao {

    boolean create(Student student);

    List<Student> findAll();
}
