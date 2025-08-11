package test;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.controller.QuanLyKhachHang;

public class TestQuanLyKhachHang {

    public static void main(String[] args) {
        testQuanLyKhachHang();
    }

    public static void testQuanLyKhachHang() {
        // Khởi tạo đối tượng quản lý
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        
        // Tạo các khách hàng mẫu
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A");
        KhachHang kh2 = new KhachHang("KH002", "Trần Thị B");
        KhachHang kh3 = new KhachHang("KH003", "Lê Văn C");
        
        System.out.println("Bắt đầu kiểm thử QuanLyKhachHang...");
        
        // Test thêm khách hàng
        System.out.println("\n1. Test thêm khách hàng:");
        try {
            qlkh.themKhachHang(kh1);
            qlkh.themKhachHang(kh2);
            qlkh.themKhachHang(kh3);
            System.out.println("- Thêm KH001: Thành công");
            System.out.println("- Thêm KH002: Thành công");
            System.out.println("- Thêm KH003: Thành công");
        } catch (Exception e) {
            System.out.println("- Lỗi khi thêm khách hàng: " + e.getMessage());
        }

        // Test xóa khách hàng
        System.out.println("\n2. Test xóa khách hàng:");
        try {
            qlkh.themKhachHang("KH002");
            qlkh.themKhachHang("KH999"); // Không tồn tại
            System.out.println("- Xóa KH002: Thành công");
            System.out.println("- Xóa KH999 (không tồn tại): Thất bại");
        } catch (Exception e) {
            System.out.println("- Lỗi khi xóa khách hàng: " + e.getMessage());
        }
        
        System.out.println("\nKết thúc kiểm thử QuanLyKhachHang!");
    }
}
