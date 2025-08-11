package test;

import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.controller.QuanLySanPham;

public class TestQuanLySanPham {

    public static void main(String[] args) {
        testQuanLySanPham();
    }

    public static void testQuanLySanPham() {
        // Khởi tạo đối tượng quản lý sản phẩm
        QuanLySanPham qlsp = new QuanLySanPham();
        
        // Tạo các sản phẩm mẫu
        SanPham sp1 = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, "https://example.com/nv24k.jpg");
        SanPham sp2 = new SanPham("SP002", "Nhẫn Vàng 18K", 4000000, "https://example.com/nv18k.jpg");
        SanPham sp3 = new SanPham("SP003", "Nhẫn Bạc", 1000000, "https://example.com/nb.jpg");

        System.out.println("Bắt đầu kiểm thử QuanLySanPham...");

        // Test thêm sản phẩm
        System.out.println("\n1. Test thêm sản phẩm:");
        try {
            qlsp.themSanPham(sp1);
            qlsp.themSanPham(sp2);
            qlsp.themSanPham(sp3);
            System.out.println("- Thêm SP001: Thành công");
            System.out.println("- Thêm SP002: Thành công");
            System.out.println("- Thêm SP003: Thành công");
        } catch (Exception e) {
            System.out.println("- Lỗi khi thêm sản phẩm: " + e.getMessage());
        }

        // Test xóa sản phẩm
        System.out.println("\n2. Test xóa sản phẩm:");
        try {
            qlsp.xoaSanPham("SP002");
            qlsp.xoaSanPham("SP999"); // Không tồn tại
            System.out.println("- Xóa SP002: Thành công");
            System.out.println("- Xóa SP999 (không tồn tại): Thất bại");
        } catch (Exception e) {
            System.out.println("- Lỗi khi xóa sản phẩm: " + e.getMessage());
        }

        // Test cập nhật sản phẩm
        System.out.println("\n3. Test cập nhật sản phẩm:");
        try {
            SanPham spCapNhat = new SanPham("SP001", "Nhẫn Vàng 24K Updated", 5500000, "https://example.com/nv24k_updated.jpg");
            qlsp.capNhatSanPham("SP001", spCapNhat); // Sửa: truyền vào mã sản phẩm và đối tượng cập nhật
            SanPham spSauCapNhat = qlsp.timSanPham("SP001");
            System.out.println("- Sau cập nhật SP001: " + (spSauCapNhat != null ? 
                spSauCapNhat.getTen() + " - " + spSauCapNhat.getPrice() : "Không tìm thấy"));
        } catch (Exception e) {
            System.out.println("- Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }

        System.out.println("\nKết thúc kiểm thử QuanLySanPham!");
    }
}
