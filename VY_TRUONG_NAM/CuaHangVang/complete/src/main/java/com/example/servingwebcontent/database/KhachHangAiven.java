package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.KhachHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KhachHangAiven {

    @Autowired
    private myDBConnection mydb;

    private void createTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS khachhang (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "ten VARCHAR(100) NOT NULL," +
                "sdt VARCHAR(20))";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> list = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM khachhang ORDER BY id DESC";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    KhachHang kh = new KhachHang(
                            rs.getString("ten"),
                            null
                    );
                    list.add(kh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addKhachHang(KhachHang kh) {
        String sql = "INSERT INTO khachhang (ten, sdt) VALUES (?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kh.getTen());
            pstmt.setString(2, kh.getSdt());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateKhachHang(KhachHang kh) {
        String sql = "UPDATE khachhang SET ten=?, sdt=? WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kh.getTen());
            pstmt.setString(2, kh.getSdt());
            pstmt.setInt(3, kh.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteKhachHang(int id) {
        String sql = "DELETE FROM khachhang WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
