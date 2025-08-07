package com.example.servingwebcontent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;

import java.util.List;

@Controller
public class ShopGoldTestController {

    @Autowired
    private myDBConnection dbConnection;

    @Autowired
    private khachHangDB khachHangDB;

    @Autowired
    private sanPhamDB sanPhamDB;

    @Autowired
    private giaoDichDB giaoDichDB;

    @GetMapping("/test-shopgold")
    public String testDatabase(Model model) {
        try {
            
            boolean isConnected = dbConnection.testConnection();
            model.addAttribute("connectionStatus", isConnected ? "Thành công" : "Thất bại");
            model.addAttribute("connectionInfo", dbConnection.getConnectionInfo());

            if (isConnected) {
              
                List<KhachHang> dsKH = khachHangDB.getAllKhachHang();
                model.addAttribute("khachHangCount", dsKH.size());
                model.addAttribute("dsKhachHang", dsKH);

                List<SanPham> dsSP = sanPhamDB.getAllSanPham();
                model.addAttribute("sanPhamCount", dsSP.size());
                model.addAttribute("dsSanPham", dsSP);

                List<GiaoDich> dsGD = giaoDichDB.getAllGiaoDich();
                model.addAttribute("giaoDichCount", dsGD.size());
                model.addAttribute("dsGiaoDich", dsGD);

                System.out.println("Số khách hàng: " + dsKH.size());
                System.out.println("Số sản phẩm: " + dsSP.size());
                System.out.println("Số giao dịch: " + dsGD.size());
            }

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi: " + e.getMessage());
            e.printStackTrace();
        }

        return "test-shopgold";
    }
}
