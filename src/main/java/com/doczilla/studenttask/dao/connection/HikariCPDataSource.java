package com.doczilla.studenttask.dao.connection;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class HikariCPDataSource {

    private static Properties properties = new Properties();
    private static HikariDataSource dataSource;


    public HikariCPDataSource() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            dataSource = new HikariDataSource();
            dataSource.setDriverClassName(properties.getProperty("driver.class.name"));
            dataSource.setJdbcUrl(properties.getProperty("db.url"));
            dataSource.setUsername(properties.getProperty("db.user"));
            dataSource.setPassword(properties.getProperty("db.password"));

            dataSource.setMinimumIdle(4);
            dataSource.setMaximumPoolSize(2000);
            dataSource.setLoginTimeout(3);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource() {
        return dataSource;
    }
}