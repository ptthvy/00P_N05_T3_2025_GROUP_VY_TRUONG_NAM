package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class aivenConnection {

    public void aivenConn() {
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            myDBConnection mydb = new myDBConnection();
            conn = mydb.getOnlyConn();

            sta = conn.createStatement();
            rs = sta.executeQuery("SELECT * FROM sanpham");

            System.out.println("Hiển thị dữ liệu sản phẩm từ database:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                double gia = rs.getDouble("gia");
                int soluong = rs.getInt("soluong");
                System.out.printf("ID: %d | Tên SP: %s | Giá: %.2f | Số lượng: %d%n", id, ten, gia, soluong);
            }
        } catch (Exception e) {
            System.out.println("Lỗi kết nối database: " + e);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (sta != null) sta.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
