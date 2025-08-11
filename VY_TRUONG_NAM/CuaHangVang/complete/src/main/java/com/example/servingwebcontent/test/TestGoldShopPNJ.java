package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.database.GiaoDichAiven;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestGoldShopPNJ {

    public static void main(String[] args) {
        KhachHangAiven khDao = new KhachHangAiven();
        SanPhamAiven spDao = new SanPhamAiven();
        GiaoDichAiven gdDao = new GiaoDichAiven();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.println("=== Thêm Khách hàng ===");
            KhachHang kh = new KhachHang("Nguyễn Văn A", "0123456789");
            khDao.addKhachHang(kh);

            System.out.println("=== Thêm Sản phẩm ===");
            SanPham sp = new SanPham(0, "Nhẫn vàng 24K", 12000000, 10);
            spDao.addSanPham(sp);

            System.out.println("=== Thêm Giao dịch ===");
            Date ngayGD = sdf.parse("2025-08-11");
            GiaoDich gd = new GiaoDich(0, 1, 1, 2, ngayGD);
            gdDao.addGiaoDich(gd);

            System.out.println("=== Danh sách Khách hàng ===");
            List<KhachHang> khList = khDao.getAllKhachHang();
            for (KhachHang k : khList) {
                System.out.printf("ID: %d | Tên: %s | SĐT: %s%n", k.getId(), k.getTen(), k.getSdt());
            }

            System.out.println("=== Danh sách Sản phẩm ===");
            List<SanPham> spList = spDao.getAllSanPham();
            for (SanPham s : spList) {
                System.out.printf("ID: %d | Tên: %s | Giá: %.2f | SL: %d%n", s.getGia(), s.getTen(), s.getGia(), s.getSoLuong());
            }

            System.out.println("=== Danh sách Giao dịch ===");
            List<GiaoDich> gdList = gdDao.getAllGiaoDich();
            for (GiaoDich g : gdList) {
                System.out.printf("ID: %d | KH ID: %d | SP ID: %d | SL: %d | Ngày: %s%n",
                        g.getId(), g.getIdKhachHang(), g.getIdSanPham(), g.getSoLuong(), sdf.format(g.getNgayGiaoDich()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
