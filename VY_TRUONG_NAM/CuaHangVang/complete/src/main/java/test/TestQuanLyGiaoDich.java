package test;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.controller.QuanLyGiaoDich;

public class TestQuanLyGiaoDich {

    public static void main(String[] args) {
        testQuanLyGiaoDich();
    }

    public static void testQuanLyGiaoDich() {
        // Khởi tạo đối tượng quản lý giao dịch
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        
        // Tạo các khách hàng và sản phẩm mẫu
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A");
        SanPham sp1 = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, "https://example.com/nv24k.jpg");
        SanPham sp2 = new SanPham("SP002", "Nhẫn Vàng 18K", 4000000, "https://example.com/nv18k.jpg");
        
        // Tạo giao dịch mẫu
        GiaoDich gd1 = new GiaoDich(kh1, sp1, 2);  // 2 sản phẩm Nhẫn Vàng 24K
        GiaoDich gd2 = new GiaoDich(kh1, sp2, 3);  // 3 sản phẩm Nhẫn Vàng 18K
        
        System.out.println("Bắt đầu kiểm thử QuanLyGiaoDich...");

        // Test thêm giao dịch
        System.out.println("\n1. Test thêm giao dịch:");
        try {
            qlgd.themGiaoDich(gd1);
            qlgd.themGiaoDich(gd2);
            System.out.println("- Thêm GiaoDich1: Thành công");
            System.out.println("- Thêm GiaoDich2: Thành công");
        } catch (Exception e) {
            System.out.println("- Lỗi khi thêm giao dịch: " + e.getMessage());
        }

        // Test xóa giao dịch
        System.out.println("\n2. Test xóa giao dịch:");
        try {
            qlgd.xoaGiaoDich(gd1.getId());  // Giả sử ID của giao dịch là `gd1.getId()`
            System.out.println("- Xóa GiaoDich1: Thành công");
            qlgd.xoaGiaoDich("GD999"); // Không tồn tại
            System.out.println("- Xóa GD999 (không tồn tại): Thất bại");
        } catch (Exception e) {
            System.out.println("- Lỗi khi xóa giao dịch: " + e.getMessage());
        }

        // Test cập nhật giao dịch
        System.out.println("\n3. Test cập nhật giao dịch:");
        try {
            GiaoDich gdCapNhat = new GiaoDich(kh1, sp2, 4); // Cập nhật số lượng giao dịch
            qlgd.capNhatGiaoDich(gd2.getId(), gdCapNhat); // Sửa: truyền vào ID và đối tượng cập nhật
            GiaoDich gdSauCapNhat = qlgd.timGiaoDich(gd2.getId());
            System.out.println("- Sau cập nhật GiaoDich2: " + (gdSauCapNhat != null ? 
                gdSauCapNhat.getSoLuong() + " sản phẩm" : "Không tìm thấy"));
        } catch (Exception e) {
            System.out.println("- Lỗi khi cập nhật giao dịch: " + e.getMessage());
        }

        System.out.println("\nKết thúc kiểm thử QuanLyGiaoDich!");
    }
}

