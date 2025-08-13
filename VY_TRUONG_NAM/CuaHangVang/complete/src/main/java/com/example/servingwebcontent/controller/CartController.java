package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.model.GioHang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/goldshop/cart")
@SessionAttributes("gioHang")
public class CartController {

    @ModelAttribute("gioHang")
    public GioHang gioHang() {
        return new GioHang();
    }

    @GetMapping
    public String viewCart(@ModelAttribute("gioHang") GioHang gio, Model model) {
        model.addAttribute("items", gio.getItems());
        model.addAttribute("total", gio.getTotalAmount());
        return "goldshop/cart";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable int productId,
                            @RequestParam(defaultValue = "1") int qty,
                            @ModelAttribute("gioHang") GioHang gio) throws SQLException {
        // Đọc sản phẩm từ DB để lấy tên + giá hiện tại (không tin client)
        var opt = SanPhamAiven.findById(productId);
        if (opt.isPresent()) {
            Map<String,Object> p = opt.get();
            String name = String.valueOf(p.get("ten"));
            double price = ((Number)p.get("gia")).doubleValue();
            gio.add(productId, name, price, qty);
        }
        return "redirect:/goldshop/cart";
    }

    @PostMapping("/update/{productId}")
    public String updateQty(@PathVariable int productId,
                            @RequestParam int qty,
                            @ModelAttribute("gioHang") GioHang gio) {
        gio.updateQuantity(productId, qty);
        return "redirect:/goldshop/cart";
    }

    @PostMapping("/remove/{productId}")
    public String remove(@PathVariable int productId,
                         @ModelAttribute("gioHang") GioHang gio) {
        gio.remove(productId);
        return "redirect:/goldshop/cart";
    }

    @PostMapping("/clear")
    public String clear(@ModelAttribute("gioHang") GioHang gio, SessionStatus status) {
        gio.clear();
        status.setComplete();
        return "redirect:/goldshop/cart";
    }
}

