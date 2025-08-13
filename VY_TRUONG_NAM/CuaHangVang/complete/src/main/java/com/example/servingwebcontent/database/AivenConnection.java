package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Kết nối MySQL Aiven qua JDBC. Mật khẩu lấy từ biến môi trường DB_PASSWORD. */
public class AivenConnection {
    private static final String URL =
        "jdbc:mysql://mysql-1a30ba13-goldshop.g.aivencloud.com:10202/defaultdb?sslMode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        if (PASSWORD == null || PASSWORD.isEmpty()) {
            throw new SQLException("Missing DB_PASSWORD environment variable.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

