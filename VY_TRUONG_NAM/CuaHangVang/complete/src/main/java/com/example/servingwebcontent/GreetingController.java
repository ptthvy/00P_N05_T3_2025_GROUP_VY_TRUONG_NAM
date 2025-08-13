package com.example.servingwebcontent;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.controller.QuanLyKhachHang;
import com.example.servingwebcontent.controller.QuanLySanPham;
import com.example.servingwebcontent.controller.QuanLyGiaoDich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    private static final QuanLySanPham quanLySanPham = new QuanLySanPham();
    private static final QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static final QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();

    static {
        quanLySanPham.them(new SanPham("Nhẫn vàng 24K", 80000000, null));
        quanLySanPham.them(new SanPham("Dây chuyền vàng Ý", 950000000, null));
        quanLySanPham.them(new SanPham("Vòng Kiềng", 400000000, null));

        quanLyKhachHang.them(new KhachHang("Nguyễn Văn A", "0909123456"));
        quanLyKhachHang.them(new KhachHang("Trần Thị B", "0912345678"));

        quanLyGiaoDich.them(new GiaoDich(
            quanLyKhachHang.getDanhSach().get(0),
            quanLySanPham.getDanhSach().get(0),
            2
        ));
    }

    // ---------------------- SAN PHAM ----------------------
    @GetMapping("/product")
    public String product(
            @RequestParam(name = "name", defaultValue = "Nhẫn vàng") String name,
            @RequestParam(name = "price", defaultValue = "999.0") double price) {

        SanPham sp = new SanPham(name, price, name);
        quanLySanPham.them(sp);
        return "redirect:/goldshop";
    }

    @GetMapping("/product/edit")
    public String editProduct(
            @RequestParam(name = "index") int index,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "price") double price) {

        SanPham sp = quanLySanPham.getDanhSach().get(index);
        sp.setTen(name);
        sp.setGia(price);
        return "redirect:/goldshop";
    }

    @GetMapping("/product/delete")
    public String deleteProduct(@RequestParam(name = "index") int index) {
        quanLySanPham.xoa(index);
        return "redirect:/goldshop";
    }

    // ---------------------- KHACH HANG ----------------------
    @GetMapping("/customer")
    public String customer(
            @RequestParam(name = "name", defaultValue = "Khách lạ") String name,
            @RequestParam(name = "phone", defaultValue = "Không rõ") String phone) {

        KhachHang kh = new KhachHang(name, phone);
        quanLyKhachHang.them(kh);
        return "redirect:/goldshop";
    }

    @GetMapping("/customer/edit")
    public String editCustomer(
            @RequestParam(name = "index") int index,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "phone") String phone) {

        KhachHang kh = quanLyKhachHang.getDanhSach().get(index);
        kh.setTen(name);
        kh.setSoDienThoai(phone);
        return "redirect:/goldshop";
    }

    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam(name = "index") int index) {
        quanLyKhachHang.xoa(index);
        return "redirect:/goldshop";
    }

    // ---------------------- GIAO DICH ----------------------
    @GetMapping("/transaction")
    public String transaction(
            @RequestParam(name = "customer") String customerName,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "product") String productName,
            @RequestParam(name = "price") double price,
            @RequestParam(name = "quantity") int quantity) {

        KhachHang kh = new KhachHang(customerName, phone);
        SanPham sp = new SanPham(productName, price, productName);
        GiaoDich gd = new GiaoDich(kh, sp, quantity);
        quanLyGiaoDich.them(gd);
        return "redirect:/goldshop";
    }

    @GetMapping("/transactions")
    public String readTransactions(Model model) {
        model.addAttribute("transactions", quanLyGiaoDich.getDanhSach());
        return "transactions";
    }

    // ---------------------- HIEN THI TAT CA ----------------------
    @GetMapping("/goldshop")
    public String goldshop(Model model) {
        model.addAttribute("products", quanLySanPham.getDanhSach());
        model.addAttribute("customers", quanLyKhachHang.getDanhSach());
        model.addAttribute("transactions", quanLyGiaoDich.getDanhSach());
        return "goldshop";
    }
}
