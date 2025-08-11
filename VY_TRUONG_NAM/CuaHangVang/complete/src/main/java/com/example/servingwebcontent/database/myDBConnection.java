package com.example.servingwebcontent.database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class myDBConnection {

    private static final String URL = "jdbc:mysql://mysql-1a30ba13-goldshop.g.aivencloud.com:10202/defaultdb";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "YOUR_PASSWORD_HERE"; // Thay mật khẩu thật vào đây

    public Connection getOnlyConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("sslMode", "REQUIRED");

            conn = DriverManager.getConnection(URL, props);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return conn;
    }
}
