package com.doczilla.studenttask.dao.connection;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import static com.doczilla.studenttask.dao.connection.PoolConnectionData.APPLICATION_PROPERTIES;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.DRIVER_CLASS_NAME;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.MAX_CONNECTIONS;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.MIN_CONNECTIONS;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.PASSWORD;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.TIMEOUT;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.URL;
import static com.doczilla.studenttask.dao.connection.PoolConnectionData.USER;

@Component
public class HikariCPDataSource {

    private static Properties properties = new Properties();
    private static HikariDataSource dataSource;

    public HikariCPDataSource() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES);
            properties.load(inputStream);
            dataSource = new HikariDataSource();
            dataSource.setDriverClassName(properties.getProperty(DRIVER_CLASS_NAME));
            dataSource.setJdbcUrl(properties.getProperty(URL));
            dataSource.setUsername(properties.getProperty(USER));
            dataSource.setPassword(properties.getProperty(PASSWORD));

            dataSource.setMinimumIdle(MIN_CONNECTIONS);
            dataSource.setMaximumPoolSize(MAX_CONNECTIONS);
            dataSource.setLoginTimeout(TIMEOUT);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource() {
        return dataSource;
    }
}