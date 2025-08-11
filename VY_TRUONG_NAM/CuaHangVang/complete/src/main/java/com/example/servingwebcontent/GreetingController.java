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

    // Thêm khách hàng
    @GetMapping("/customer")
    public String customer(
            @RequestParam(name = "name", required = false, defaultValue = "Khách lạ") String name,
            @RequestParam(name = "phone", required = false, defaultValue = "Không rõ") String phone,
            Model model) {

        KhachHang kh = new KhachHang(name, phone);
        quanLyKhachHang.them(kh); // Thêm vào danh sách quản lý
        return "redirect:/goldshop"; // Chuyển về trang danh sách để hiển thị cập nhật
    }

    // Xóa khách hàng
    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam(name = "index") int index) {
        quanLyKhachHang.xoa(index);
        return "redirect:/goldshop";
    }
    // Thêm sản phẩm
    @GetMapping("/product")
    public String product(
            @RequestParam(name = "name", required = false, defaultValue = "Nhẫn vàng") String name,
            @RequestParam(name = "price", required = false, defaultValue = "999.0") double price,
            Model model) {

        SanPham sp = new SanPham(name, price, name);
        quanLySanPham.them(sp); // Thêm vào danh sách quản lý
        return "redirect:/goldshop";
    }

    // Thêm giao dịch
    @GetMapping("/transaction")
    public String transaction(
            @RequestParam(name = "customer", required = false, defaultValue = "Khách A") String customerName,
            @RequestParam(name = "phone", required = false, defaultValue = "Không rõ") String phone,
            @RequestParam(name = "product", required = false, defaultValue = "Nhẫn vàng") String productName,
            @RequestParam(name = "price", required = false, defaultValue = "999.0") double price,
            @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity,
            Model model) {

        KhachHang kh = new KhachHang(customerName, phone);
        SanPham sp = new SanPham(productName, price, productName);
        GiaoDich gd = new GiaoDich(kh, sp, quantity);
        quanLyGiaoDich.them(gd); // Thêm vào danh sách quản lý
        return "redirect:/goldshop";
    }
    @GetMapping("/goldshop")
    public String goldshop(Model model) {
        model.addAttribute("products", quanLySanPham.getDanhSach());
        model.addAttribute("customers", quanLyKhachHang.getDanhSach());
        model.addAttribute("transactions", quanLyGiaoDich.getDanhSach());
        return "goldshop";
    }
}
