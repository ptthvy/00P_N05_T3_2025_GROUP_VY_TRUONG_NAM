package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamAiven {

    @Autowired
    private myDBConnection mydb;

    private void createTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS sanpham (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "ten VARCHAR(100) NOT NULL," +
                "gia DOUBLE," +
                "soluong INT)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> list = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM sanpham ORDER BY id DESC";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SanPham sp = new SanPham(
                            rs.getInt("id"),
                            rs.getString("ten"),
                            rs.getDouble("gia"),
                            rs.getInt("soluong")
                    );
                    list.add(sp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addSanPham(SanPham sp) {
        String sql = "INSERT INTO sanpham (ten, gia, soluong) VALUES (?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getGia());
            pstmt.setInt(3, sp.getSoLuong());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSanPham(SanPham sp) {
        String sql = "UPDATE sanpham SET ten=?, gia=?, soluong=? WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getGia());
            pstmt.setInt(3, sp.getSoLuong());
            pstmt.setInt(4, (int) sp.getGia());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSanPham(int id) {
        String sql = "DELETE FROM sanpham WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
