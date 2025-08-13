package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.*;

/* giao_dich (thanh toán) */
public class GiaoDichAiven {

    public static List<Map<String, Object>> findByHoaDon(int hoaDonId) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, hoa_don_id, so_tien, phuong_thuc, trang_thai, thoi_gian "
                   + "FROM giao_dich WHERE hoa_don_id=? ORDER BY thoi_gian DESC, id DESC")) {
            ps.setInt(1, hoaDonId);
            try (ResultSet rs = ps.executeQuery()) {
                return DbUtils.toList(rs);
            }
        }
    }

    public static Optional<Map<String, Object>> findById(int id) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, hoa_don_id, so_tien, phuong_thuc, trang_thai, thoi_gian "
                   + "FROM giao_dich WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                var list = DbUtils.toList(rs);
                return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
            }
        }
    }

    public static int insert(int hoaDonId, double soTien, String phuongThuc, String trangThai) throws SQLException {
        if (phuongThuc == null || phuongThuc.isBlank()) phuongThuc = "CASH";
        if (trangThai == null || trangThai.isBlank()) trangThai = "PENDING";
        String sql = "INSERT INTO giao_dich(hoa_don_id, so_tien, phuong_thuc, trang_thai) VALUES (?,?,?,?)";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, hoaDonId);
            ps.setDouble(2, soTien);
            ps.setString(3, phuongThuc);
            ps.setString(4, trangThai);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
            return 0;
        }
    }

    public static int updateTrangThai(int id, String trangThai) throws SQLException {
        String sql = "UPDATE giao_dich SET trang_thai=? WHERE id=?";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }
    }

    public static int delete(int id) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement("DELETE FROM giao_dich WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}

