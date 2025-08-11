package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.KhachHang;

import java.util.List;

public class TestKhachHang {

    public static void main(String[] args) {
        KhachHangAiven dao = new KhachHangAiven();

        try {
            // Thêm khách hàng mới
            KhachHang khNew = new KhachHang("Nguyễn Văn A", "0123456789");
            dao.addKhachHang(khNew);
            System.out.println("Thêm khách hàng thành công.");

            // Lấy danh sách khách hàng
            List<KhachHang> list = dao.getAllKhachHang();
            System.out.println("Danh sách khách hàng:");
            for (KhachHang kh : list) {
                System.out.printf("ID: %d | Tên: %s | SĐT: %s%n",
                        kh.getId(), kh.getTen(), kh.getSdt());
            }

            // Cập nhật khách hàng đầu tiên (nếu có)
            if (!list.isEmpty()) {
                KhachHang khUpdate = list.get(0);
                khUpdate.setTen("Trần Văn B");
                khUpdate.setSdt("0987654321");
                dao.updateKhachHang(khUpdate);
                System.out.println("Cập nhật khách hàng thành công.");
            }

            // Xóa khách hàng cuối cùng (nếu có)
            if (!list.isEmpty()) {
                int lastId = list.get(list.size() - 1).getId();
                dao.deleteKhachHang(lastId);
                System.out.println("Xóa khách hàng thành công.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình test CRUD:");
            e.printStackTrace();
        }
    }
}
