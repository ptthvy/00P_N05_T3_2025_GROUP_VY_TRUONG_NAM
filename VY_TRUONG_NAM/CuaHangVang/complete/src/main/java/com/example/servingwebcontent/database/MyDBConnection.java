package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDBConnection {
    public static Connection open() throws SQLException {
        return AivenConnection.getConnection(); // dùng cấu hình AivenConnection
    }
}
