package com.example.servingwebcontent; 

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/customer")
    public String customer(
        @RequestParam(name = "name", required = false, defaultValue = "Khách lạ") String name,
        @RequestParam(name = "phone", required = false, defaultValue = "Không rõ") String phone,
        Model model) {

        KhachHang kh = new KhachHang(name, phone);
        model.addAttribute("customer", kh);
        return "greetingtruongnamvy";
    }

    @GetMapping("/product")
    public String product(
        @RequestParam(name = "name", required = false, defaultValue = "Nhẫn vàng") String name,
        @RequestParam(name = "price", required = false, defaultValue = "999.0") double price,
        Model model) {

        SanPham sp = new SanPham(name, price);
        model.addAttribute("product", sp);
        return "greetingtruongnamvy";
    }

    @GetMapping("/greetingtruongnamvy")
    public String transaction(
        @RequestParam(name = "customer", required = false, defaultValue = "Khách A") String customerName,
        @RequestParam(name = "phone", required = false, defaultValue = "Không rõ") String phone,
        @RequestParam(name = "product", required = false, defaultValue = "Nhẫn vàng") String productName,
        @RequestParam(name = "price", required = false, defaultValue = "999.0") double price,
        @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity,
        Model model) {

        KhachHang kh = new KhachHang(customerName, phone);
        SanPham sp = new SanPham(productName, price);
        GiaoDich gd = new GiaoDich(kh, sp, quantity);
        model.addAttribute("transaction", gd);
        return "greetingtruongnamvy";
    }
}
