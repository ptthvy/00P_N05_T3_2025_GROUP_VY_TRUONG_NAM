package com.example.servingwebcontent;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.controller.QuanLyKhachHang;
import com.example.servingwebcontent.controller.QuanLySanPham;
import com.example.servingwebcontent.controller.QuanLyGiaoDich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

  
    private static final QuanLySanPham quanLySanPham = new QuanLySanPham();
    private static final QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static final QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();

    static {
    
        quanLySanPham.them(new SanPham("Nhẫn vàng 24K", 5000.0));
        quanLySanPham.them(new SanPham("Dây chuyền vàng 18K", 7000.0));
        quanLyKhachHang.them(new KhachHang("Nguyễn Văn A", "0909123456"));
        quanLyKhachHang.them(new KhachHang("Trần Thị B", "0912345678"));
        quanLyGiaoDich.them(new GiaoDich(
            quanLyKhachHang.getDanhSach().get(0),
            quanLySanPham.getDanhSach().get(0),
            2
        ));
    }

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

    @GetMapping("/transaction")
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

    @GetMapping("/goldshop")
    public String goldshop(Model model) {
        model.addAttribute("products", quanLySanPham.getDanhSach());
        model.addAttribute("customers", quanLyKhachHang.getDanhSach());
        model.addAttribute("transactions", quanLyGiaoDich.getDanhSach());
        return "goldshopnpj";
    }
}