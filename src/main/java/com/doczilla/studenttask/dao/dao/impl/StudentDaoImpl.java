package com.doczilla.studenttask.dao.dao.impl;

import com.doczilla.studenttask.dao.connection.HikariCPDataSource;
import com.doczilla.studenttask.dao.dao.StudentDao;
import com.doczilla.studenttask.dao.dao.column.ColumnName;
import com.doczilla.studenttask.dao.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.doczilla.studenttask.dao.dao.column.ColumnName.BIRTHDAY;
import static com.doczilla.studenttask.dao.dao.column.ColumnName.FIRST_NAME;
import static com.doczilla.studenttask.dao.dao.column.ColumnName.GROUP;
import static com.doczilla.studenttask.dao.dao.column.ColumnName.ID;
import static com.doczilla.studenttask.dao.dao.column.ColumnName.LAST_NAME;
import static com.doczilla.studenttask.dao.dao.column.ColumnName.SURNAME;

@Repository
public class StudentDaoImpl implements StudentDao {

    private static final String CREATE_STUDENT = "INSERT INTO students" +
            " (first_name, last_name, surname, birthday, student_group)" +
            " VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT * FROM students";

    public boolean create(Student student)  {
        boolean result = false;
        try (Connection connection = HikariCPDataSource.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setDate(4, student.getBirthday());
            preparedStatement.setString(5, student.getGroup());
            result = preparedStatement.execute();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(ID);
                String firstName = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                String surname = resultSet.getString(SURNAME);
                Date birthday = resultSet.getDate(BIRTHDAY);
                String group = resultSet.getString(GROUP);
                students.add(new Student(id, firstName, lastName, surname,birthday, group));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

}
