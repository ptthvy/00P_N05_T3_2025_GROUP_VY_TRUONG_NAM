package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.*;

/** DAO: Lịch sử đơn hàng (tổng hợp) */
public class HistoryAiven {

    /** 20 hóa đơn gần nhất trên toàn hệ thống */
    public static List<Map<String, Object>> recentOrders(int limit) throws SQLException {
        if (limit <= 0) limit = 20;
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT hd.id, hd.ngay, hd.tong_tien, kh.id AS kh_id, kh.ten AS kh_ten " +
                     "FROM hoa_don hd JOIN khach_hang kh ON kh.id = hd.khach_hang_id " +
                     "ORDER BY hd.ngay DESC, hd.id DESC LIMIT ?")) {
            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) {
                return DbUtils.toList(rs);
            }
        }
    }

    /** Tất cả hóa đơn của 1 khách hàng */
    public static List<Map<String, Object>> ordersByCustomer(int customerId) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT hd.id, hd.ngay, hd.tong_tien, kh.id AS kh_id, kh.ten AS kh_ten " +
                     "FROM hoa_don hd JOIN khach_hang kh ON kh.id = hd.khach_hang_id " +
                     "WHERE kh.id=? ORDER BY hd.ngay DESC, hd.id DESC")) {
            ps.setInt(1, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                return DbUtils.toList(rs);
            }
        }
    }

    /** Chi tiết của một hóa đơn */
    public static List<Map<String, Object>> detailsByInvoice(int hoaDonId) throws SQLException {
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT ct.hoa_don_id, sp.ten AS sp_ten, ct.so_luong, ct.don_gia, " +
                     "(ct.so_luong * ct.don_gia) AS thanh_tien " +
                     "FROM chi_tiet_hoa_don ct JOIN san_pham sp ON sp.id = ct.san_pham_id " +
                     "WHERE ct.hoa_don_id=? ORDER BY ct.id")) {
            ps.setInt(1, hoaDonId);
            try (ResultSet rs = ps.executeQuery()) {
                return DbUtils.toList(rs);
            }
        }
    }
}
