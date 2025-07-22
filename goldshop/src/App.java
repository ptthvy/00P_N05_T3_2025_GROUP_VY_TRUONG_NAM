public class App {
    public static void main(String[] args) {
        System.out.println("=== CHẠY KIỂM THỬ ===");

        System.out.println("\n--- Kiểm thử Khách Hàng VIP ---");
        QuanLyKhachHangTest.testHienThiKhachHangVip();

        System.out.println("\n--- Kiểm thử Tìm kiếm Sản phẩm ---");
        QuanLySanPhamTest.testTimKiemSanPhamTheoTen();

        System.out.println("\n--- Kiểm thử Giao Dịch Theo Ngày ---");
        QuanLyGiaoDichTest.testHienThiGiaoDichTheoNgay();

        System.out.println("\n=== KẾT THÚC ===");
    }
}
