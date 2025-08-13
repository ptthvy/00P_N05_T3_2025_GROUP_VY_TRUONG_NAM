package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.*;

/* khach_hang */
public class KhachHangAiven {

    public static List<Map<String, Object>> findAll() throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, ten, sdt, email, dia_chi FROM khach_hang ORDER BY id DESC");
             ResultSet rs = ps.executeQuery()) {
            return DbUtils.toList(rs);
        }
    }

    public static Optional<Map<String, Object>> findById(int id) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, ten, sdt, email, dia_chi FROM khach_hang WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                var list = DbUtils.toList(rs);
                return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
            }
        }
    }

    public static int insert(String ten, String sdt, String email, String diaChi) throws SQLException {
        String sql = "INSERT INTO khach_hang(ten, sdt, email, dia_chi) VALUES (?,?,?,?)";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ten);
            ps.setString(2, sdt);
            ps.setString(3, email);
            ps.setString(4, diaChi);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
            return 0;
        }
    }

    public static int update(int id, String ten, String sdt, String email, String diaChi) throws SQLException {
        String sql = "UPDATE khach_hang SET ten=?, sdt=?, email=?, dia_chi=? WHERE id=?";
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, ten);
            ps.setString(2, sdt);
            ps.setString(3, email);
            ps.setString(4, diaChi);
            ps.setInt(5, id);
            return ps.executeUpdate();
        }
    }

    public static int delete(int id) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement("DELETE FROM khach_hang WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    public static List<Map<String, Object>> searchByName(String q) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT id, ten, sdt, email, dia_chi FROM khach_hang WHERE ten LIKE ? ORDER BY ten")) {
            ps.setString(1, "%" + q + "%");
            try (ResultSet rs = ps.executeQuery()) {
                return DbUtils.toList(rs);
            }
        }
    }
}

