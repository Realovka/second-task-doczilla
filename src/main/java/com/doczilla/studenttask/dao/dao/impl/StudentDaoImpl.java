package com.doczilla.studenttask.dao.dao.impl;

import com.doczilla.studenttask.dao.connection.HikariCPDataSource;
import com.doczilla.studenttask.dao.dao.StudentDao;
import com.doczilla.studenttask.dao.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class StudentDaoImpl implements StudentDao {

    private static final String CREATE_STUDENT = "INSERT INTO students" +
            " (first_name, last_name, surname, birthday, student_group)" +
            " VALUES(?, ?, ?, ?, ?)";

    public boolean create(Student student)  {
        boolean result = false;
        try (Connection connection = HikariCPDataSource.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setDate(4, Date.valueOf(student.getBirthday()));
            preparedStatement.setString(5, student.getGroup());
            result = preparedStatement.execute();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return result;
    }

}
