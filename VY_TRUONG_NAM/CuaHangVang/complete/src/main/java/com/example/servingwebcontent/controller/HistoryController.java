package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.HistoryAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goldshop/history")
public class HistoryController {

    @GetMapping
    public String history(@RequestParam(value="customerId", required=false) Integer customerId, Model model) throws SQLException {
        // Lấy danh sách hóa đơn
        List<Map<String,Object>> orders = (customerId == null)
                ? HistoryAiven.recentOrders(20)
                : HistoryAiven.ordersByCustomer(customerId);

        // Lấy chi tiết cho từng hóa đơn
        Map<Integer, List<Map<String,Object>>> details = new HashMap<>();
        for (Map<String,Object> od : orders) {
            int oid = ((Number)od.get("id")).intValue();
            details.put(oid, HistoryAiven.detailsByInvoice(oid));
        }

        model.addAttribute("orders", orders);
        model.addAttribute("details", details);
        model.addAttribute("customerId", customerId);
        return "goldshop/history";
    }
}

