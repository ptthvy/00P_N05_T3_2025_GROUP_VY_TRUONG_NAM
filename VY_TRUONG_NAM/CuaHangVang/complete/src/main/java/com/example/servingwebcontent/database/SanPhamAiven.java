package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.*;

/* san_pham */
public class SanPhamAiven {

    public static List<Map<String, Object>> findAll() throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, ten, loai, gia, ton_kho FROM san_pham ORDER BY id DESC");
             ResultSet rs = ps.executeQuery()) {
            return DbUtils.toList(rs);
        }
    }

    public static Optional<Map<String, Object>> findById(int id) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, ten, loai, gia, ton_kho FROM san_pham WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                var list = DbUtils.toList(rs);
                return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
            }
        }
    }

    public static int insert(String ten, String loai, double gia, int tonKho) throws SQLException {
        String sql = "INSERT INTO san_pham(ten, loai, gia, ton_kho) VALUES (?,?,?,?)";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ten);
            ps.setString(2, loai);
            ps.setDouble(3, gia);
            ps.setInt(4, tonKho);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
            return 0;
        }
    }

    public static int update(int id, String ten, String loai, double gia, int tonKho) throws SQLException {
        String sql = "UPDATE san_pham SET ten=?, loai=?, gia=?, ton_kho=? WHERE id=?";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, ten);
            ps.setString(2, loai);
            ps.setDouble(3, gia);
            ps.setInt(4, tonKho);
            ps.setInt(5, id);
            return ps.executeUpdate();
        }
    }

    public static int adjustStock(int id, int delta) throws SQLException {
        String sql = "UPDATE san_pham SET ton_kho = ton_kho + ? WHERE id=?";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, delta);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }
    }

    public static int delete(int id) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement("DELETE FROM san_pham WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}

