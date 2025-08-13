package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.GioHang;
import com.example.servingwebcontent.service.CoreFlowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping({"/goldshop/transactions", "/goldshop/giao-dich"})
@SessionAttributes("gioHang")
public class GiaoDichController {

    @ModelAttribute("gioHang")
    public GioHang gioHang() { return new GioHang(); }

    @GetMapping
    public String page(@ModelAttribute("gioHang") GioHang gio, Model model) throws SQLException {
        model.addAttribute("customers", KhachHangAiven.findAll());
        model.addAttribute("total", gio.getTotalAmount());
        return "goldshop/transactions"; // templates/goldshop/transactions.html
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("customerId") int customerId,
                           @RequestParam(value="method", defaultValue="CASH") String method,
                           @ModelAttribute("gioHang") GioHang gio,
                           SessionStatus status) throws SQLException {
        int invoiceId = new CoreFlowService().checkout(customerId, gio, method);
        status.setComplete(); // clear giỏ sau khi thanh toán
        return "redirect:/goldshop/history?customerId=" + customerId;
    }
}
