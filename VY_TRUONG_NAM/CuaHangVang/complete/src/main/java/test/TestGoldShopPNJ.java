package test;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.controller.QuanLyKhachHang;
import com.example.servingwebcontent.controller.QuanLySanPham;
import com.example.servingwebcontent.controller.QuanLyGiaoDich;

public class TestGoldShopPNJ {

    public static void main(String[] args) {
        testGoldShopPNJ();
    }

    public static void testGoldShopPNJ() {
        // Khởi tạo đối tượng quản lý khách hàng, sản phẩm và giao dịch
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        QuanLySanPham qlsp = new QuanLySanPham();
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        
        // Tạo các khách hàng mẫu
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A");
        KhachHang kh2 = new KhachHang("KH002", "Trần Thị B");
        
        // Tạo các sản phẩm mẫu
        SanPham sp1 = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, "https://example.com/nv24k.jpg");
        SanPham sp2 = new SanPham("SP002", "Nhẫn Vàng 18K", 4000000, "https://example.com/nv18k.jpg");
        
        // Tạo các giao dịch mẫu
        GiaoDich gd1 = new GiaoDich(kh1, sp1, 2);  // 2 sản phẩm Nhẫn Vàng 24K
        GiaoDich gd2 = new GiaoDich(kh2, sp2, 1);  // 1 sản phẩm Nhẫn Vàng 18K
        
        System.out.println("Bắt đầu kiểm thử GoldShop PNJ...");

        // Test thêm khách hàng
        System.out.println("\n1. Test thêm khách hàng:");
        try {
            qlkh.themKhachHang(kh1);
            qlkh.themKhachHang(kh2);
            System.out.println("- Thêm KH001: Thành công");
            System.out.println("- Thêm KH002: Thành công");
        } catch (Exception e) {
            System.out.println("- Lỗi khi thêm khách hàng: " + e.getMessage());
        }

        // Test thêm sản phẩm
        System.out.println("\n2. Test thêm sản phẩm:");
        try {
            qlsp.themSanPham(sp1);
            qlsp.themSanPham(sp2);
            System.out.println("- Thêm SP001: Thành công");
            System.out.println("- Thêm SP002: Thành công");
        } catch (Exception e) {
            System.out.println("- Lỗi khi thêm sản phẩm: " + e.getMessage());
        }

        // Test thêm giao dịch
        System.out.println("\n3. Test thêm giao dịch:");
        try {
            qlgd.themGiaoDich(gd1);
            qlgd.themGiaoDich(gd2);
            System.out.println("- Thêm GiaoDich1: Thành công");
            System.out.println("- Thêm GiaoDich2: Thành công");
        } catch (Exception e) {
            System.out.println("- Lỗi khi thêm giao dịch: " + e.getMessage());
        }

        // Test xóa giao dịch
        System.out.println("\n4. Test xóa giao dịch:");
        try {
            qlgd.xoaGiaoDich(gd1.getId()); // Giả sử ID của giao dịch là gd1.getId()
            System.out.println("- Xóa GiaoDich1: Thành công");
            qlgd.xoaGiaoDich("GD999"); // Không tồn tại
            System.out.println("- Xóa GD999 (không tồn tại): Thất bại");
        } catch (Exception e) {
            System.out.println("- Lỗi khi xóa giao dịch: " + e.getMessage());
        }

        // Test xóa sản phẩm
        System.out.println("\n5. Test xóa sản phẩm:");
        try {
            qlsp.xoaSanPham("SP002");
            qlsp.xoaSanPham("SP999"); // Không tồn tại
            System.out.println("- Xóa SP002: Thành công");
            System.out.println("- Xóa SP999 (không tồn tại): Thất bại");
        } catch (Exception e) {
            System.out.println("- Lỗi khi xóa sản phẩm: " + e.getMessage());
        }

        // Test xóa khách hàng
        System.out.println("\n6. Test xóa khách hàng:");
        try {
            qlkh.xoaKhachHang("KH001");
            qlkh.xoaKhachHang("KH999"); // Không tồn tại
            System.out.println("- Xóa KH001: Thành công");
            System.out.println("- Xóa KH999 (không tồn tại): Thất bại");
        } catch (Exception e) {
            System.out.println("- Lỗi khi xóa khách hàng: " + e.getMessage());
        }

        System.out.println("\nKết thúc kiểm thử GoldShop PNJ!");
    }
}
