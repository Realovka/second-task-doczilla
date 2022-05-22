package com.doczilla.studenttask.dao.dao.impl;

import com.doczilla.studenttask.dao.connection.HikariCPDataSource;
import com.doczilla.studenttask.dao.dao.StudentDao;
import com.doczilla.studenttask.dao.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.doczilla.studenttask.dao.dao.util.ColumnName.BIRTHDAY;
import static com.doczilla.studenttask.dao.dao.util.ColumnName.FIRST_NAME;
import static com.doczilla.studenttask.dao.dao.util.ColumnName.GROUP;
import static com.doczilla.studenttask.dao.dao.util.ColumnName.ID;
import static com.doczilla.studenttask.dao.dao.util.ColumnName.LAST_NAME;
import static com.doczilla.studenttask.dao.dao.util.ColumnName.SURNAME;

@Repository
@Slf4j
public class StudentDaoImpl implements StudentDao {

    private static final String CREATE_STUDENT = "INSERT INTO students" +
            " (first_name, last_name, surname, birthday, student_group)" +
            " VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT * FROM students";
    private static final String FIND_BY_ID = "SELECT id FROM students WHERE id =?";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id =?";

    @Override
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
            log.error("SQLException when create student", e);
        }
        return result;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
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
            log.error("SQLException when find all students", e);
        }
        return students;
    }

    @Override
    public Optional<Student> findById(long id) {
        try (Connection connection = HikariCPDataSource.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.ofNullable(Student.builder()
                                .id(resultSet.getLong(ID))
                        .build());
            }
        } catch (SQLException e) {
            log.error("SQLException when find student by id", e);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(long id) {
        boolean result = false;
        try (Connection connection = HikariCPDataSource.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            log.error("SQLException when delete by id", e);
        }
        return result;
    }
}
