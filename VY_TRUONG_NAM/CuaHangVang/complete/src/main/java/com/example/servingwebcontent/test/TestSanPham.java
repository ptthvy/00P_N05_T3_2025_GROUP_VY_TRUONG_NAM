package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.model.SanPham;

import java.util.List;

public class TestSanPham {

    public static void main(String[] args) {
        SanPhamAiven dao = new SanPhamAiven();

        try {
            // Thêm sản phẩm mới
            SanPham spNew = new SanPham(0, "Vòng vàng 24K", 15000000, 5);
            dao.addSanPham(spNew);
            System.out.println("Thêm sản phẩm thành công.");

            // Lấy danh sách sản phẩm
            List<SanPham> list = dao.getAllSanPham();
            System.out.println("Danh sách sản phẩm:");
            for (SanPham sp : list) {
                System.out.printf("ID: %d | Tên: %s | Giá: %.2f | Số lượng: %d%n",
                        sp.getGia(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            }

            // Cập nhật sản phẩm đầu tiên (nếu có)
            if (!list.isEmpty()) {
                SanPham spUpdate = list.get(0);
                spUpdate.setGia(16000000);
                spUpdate.setSoLuong(10);
                dao.updateSanPham(spUpdate);
                System.out.println("Cập nhật sản phẩm thành công.");
            }

            // Xóa sản phẩm cuối cùng (nếu có)
            if (!list.isEmpty()) {
                double lastId = list.get(list.size() - 1).getGia();
                dao.deleteSanPham(lastId);
                System.out.println("Xóa sản phẩm thành công.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình test CRUD:");
            e.printStackTrace();
        }
    }
}
