package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.GiaoDichAiven;
import com.example.servingwebcontent.model.GiaoDich;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestGiaoDich {

    public static void main(String[] args) {
        GiaoDichAiven dao = new GiaoDichAiven();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Thêm giao dịch mới
            Date ngay = sdf.parse("2025-08-11");
            GiaoDich gdNew = new GiaoDich(0, 1, 1, 3, ngay);
            dao.addGiaoDich(gdNew);
            System.out.println("Thêm giao dịch thành công.");

            // Lấy danh sách giao dịch
            List<GiaoDich> list = dao.getAllGiaoDich();
            System.out.println("Danh sách giao dịch:");
            for (GiaoDich gd : list) {
                System.out.printf("ID: %d | Khách hàng ID: %d | Sản phẩm ID: %d | Số lượng: %d | Ngày: %s%n",
                        gd.getId(), gd.getIdKhachHang(), gd.getIdSanPham(), gd.getSoLuong(), sdf.format(gd.getNgayGiaoDich()));
            }

            // Cập nhật giao dịch đầu tiên (nếu có)
            if (!list.isEmpty()) {
                GiaoDich gdUpdate = list.get(0);
                gdUpdate.setSoLuong(5);
                gdUpdate.setNgayGiaoDich(sdf.parse("2025-08-12"));
                dao.updateGiaoDich(gdUpdate);
                System.out.println("Cập nhật giao dịch thành công.");
            }

            // Xóa giao dịch cuối cùng (nếu có)
            if (!list.isEmpty()) {
                int lastId = list.get(list.size() - 1).getId();
                dao.deleteGiaoDich(lastId);
                System.out.println("Xóa giao dịch thành công.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình test CRUD:");
            e.printStackTrace();
        }
    }
}
