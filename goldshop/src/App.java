package src;

import test.TestQuanLyGiaoDich;
import test.TestQuanLyKhachHang;
import test.TestQuanLySanPham;

public class App {
    public static void main(String[] args) {
        System.out.println("\n=== TEST GIAO DỊCH ===");
        TestQuanLyGiaoDich.testHienThiGiaoDichTheoNgay();

        System.out.println("\n=== TEST KHÁCH HÀNG ===");
        TestQuanLyKhachHang.testHienThiKhachHangVip();

        System.out.println("\n=== TEST SẢN PHẨM ===");
        TestQuanLySanPham.testTimKiemSanPhamTheoTen();
    }
}
