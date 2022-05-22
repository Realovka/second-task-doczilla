package com.doczilla.studenttask.dao.connection;

public final class PoolConnectionData {

    public static final String APPLICATION_PROPERTIES = "application.properties";
    public static final String DRIVER_CLASS_NAME = "driver.class.name";
    public static final String URL = "db.url";
    public static final String USER = "db.user";
    public static final String PASSWORD = "db.password";
    public static final int MIN_CONNECTIONS = 4;
    public static final int MAX_CONNECTIONS = 2000;
    public static final int TIMEOUT = 3;
}
