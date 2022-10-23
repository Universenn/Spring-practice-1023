package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class LocalConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        String host = "DB_HOST";
        String name = "DB_NAME";
        String password = "DB_PASSWORD";

        Connection c = DriverManager.getConnection(
                env.get(host),
                env.get(name),
                env.get(password));
        return c;
    }
}
