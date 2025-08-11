package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.GiaoDich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GiaoDichAiven {

    @Autowired
    private myDBConnection mydb;

    private void createTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS giaodich (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "id_khachhang INT," +
                "id_sanpham INT," +
                "soluong INT," +
                "ngaygiaodich DATE," +
                "FOREIGN KEY (id_khachhang) REFERENCES khachhang(id)," +
                "FOREIGN KEY (id_sanpham) REFERENCES sanpham(id))";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GiaoDich> getAllGiaoDich() {
        List<GiaoDich> list = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM giaodich ORDER BY id DESC";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    GiaoDich gd = new GiaoDich(
                            rs.getInt("id"),
                            rs.getInt("id_khachhang"),
                            rs.getInt("id_sanpham"),
                            rs.getInt("soluong"),
                            rs.getDate("ngaygiaodich")
                    );
                    list.add(gd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addGiaoDich(GiaoDich gd) {
        String sql = "INSERT INTO giaodich (id_khachhang, id_sanpham, soluong, ngaygiaodich) VALUES (?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gd.getIdKhachHang());
            pstmt.setInt(2, gd.getIdSanPham());
            pstmt.setInt(3, gd.getSoLuong());
            pstmt.setDate(4, new java.sql.Date(gd.getNgayGiaoDich().getTime()));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGiaoDich(GiaoDich gd) {
        String sql = "UPDATE giaodich SET id_khachhang=?, id_sanpham=?, soluong=?, ngaygiaodich=? WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gd.getIdKhachHang());
            pstmt.setInt(2, gd.getIdSanPham());
            pstmt.setInt(3, gd.getSoLuong());
            pstmt.setDate(4, new java.sql.Date(gd.getNgayGiaoDich().getTime()));
            pstmt.setInt(5, gd.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGiaoDich(int id) {
        String sql = "DELETE FROM giaodich WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
