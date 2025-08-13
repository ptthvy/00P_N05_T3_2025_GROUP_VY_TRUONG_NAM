package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.database.DbUtils;
import com.database.MyDBConnection;

import java.sql.*;
import java.util.*;

@Controller
@RequestMapping("/goldshop/history")
public class HistoryController {

    @GetMapping
    public String history(@RequestParam(value="customerId", required=false) Integer customerId, Model model) throws Exception {
        List<Map<String,Object>> orders = new ArrayList<>();

        if (customerId == null) {
            try (Connection c = MyDBConnection.open();
                 PreparedStatement ps = c.prepareStatement(
                         "SELECT hd.id, hd.ngay, hd.tong_tien, kh.ten AS kh_ten, kh.id AS kh_id " +
                         "FROM hoa_don hd JOIN khach_hang kh ON kh.id = hd.khach_hang_id " +
                         "ORDER BY hd.ngay DESC, hd.id DESC LIMIT 20")) {
                try (ResultSet rs = ps.executeQuery()) {
                    orders = DbUtils.toList(rs);
                }
            }
            // chi tiết cho từng hóa đơn
            Map<Integer, List<Map<String,Object>>> details = new HashMap<>();
            try (Connection c = MyDBConnection.open();
                 PreparedStatement ps = c.prepareStatement(
                         "SELECT ct.hoa_don_id, sp.ten AS sp_ten, ct.so_luong, ct.don_gia, (ct.so_luong*ct.don_gia) AS thanh_tien " +
                         "FROM chi_tiet_hoa_don ct JOIN san_pham sp ON sp.id = ct.san_pham_id " +
                         "WHERE ct.hoa_don_id = ? ORDER BY ct.id")) {
                for (Map<String,Object> od : orders) {
                    int oid = ((Number)od.get("id")).intValue();
                    ps.setInt(1, oid);
                    try (ResultSet rs = ps.executeQuery()) {
                        details.put(oid, DbUtils.toList(rs));
                    }
                }
            }
            model.addAttribute("orders", orders);
            model.addAttribute("details", details);
            model.addAttribute("customerId", null);
            return "goldshop/history";
        }

        // Nếu có customerId: lọc theo khách hàng
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT hd.id, hd.ngay, hd.tong_tien, kh.ten AS kh_ten, kh.id AS kh_id " +
                     "FROM hoa_don hd JOIN khach_hang kh ON kh.id = hd.khach_hang_id " +
                     "WHERE kh.id = ? ORDER BY hd.ngay DESC, hd.id DESC")) {
            ps.setInt(1, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                orders = DbUtils.toList(rs);
            }
        }
        Map<Integer, List<Map<String,Object>>> details = new HashMap<>();
        try (Connection c = MyDBConnection.open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT ct.hoa_don_id, sp.ten AS sp_ten, ct.so_luong, ct.don_gia, (ct.so_luong*ct.don_gia) AS thanh_tien " +
                     "FROM chi_tiet_hoa_don ct JOIN san_pham sp ON sp.id = ct.san_pham_id " +
                     "WHERE ct.hoa_don_id = ? ORDER BY ct.id")) {
            for (Map<String,Object> od : orders) {
                int oid = ((Number)od.get("id")).intValue();
                ps.setInt(1, oid);
                try (ResultSet rs = ps.executeQuery()) {
                    details.put(oid, DbUtils.toList(rs));
                }
            }
        }
        model.addAttribute("orders", orders);
        model.addAttribute("details", details);
        model.addAttribute("customerId", customerId);
        return "goldshop/history";
    }
}
