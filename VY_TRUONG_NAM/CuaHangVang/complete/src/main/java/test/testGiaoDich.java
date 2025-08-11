package com.example.servingwebcontent;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestGiaoDich {

    private GiaoDich giaoDich1;
    private GiaoDich giaoDich2;
    private KhachHang khachHang1;
    private SanPham sanPham1;

    @BeforeEach
    public void setUp() {
        // Khởi tạo dữ liệu trước mỗi bài kiểm tra
        khachHang1 = new KhachHang("K001", "Nguyen Thi A", 25, "0123456789", "a@gmail.com");
        sanPham1 = new SanPham("SP001", "Laptop Dell", 15000000, 10);
        
        giaoDich1 = new GiaoDich(khachHang1, sanPham1, 2);  // 2 sản phẩm
        giaoDich2 = new GiaoDich(khachHang1, sanPham1, 3);  // 3 sản phẩm
    }

    @Test
    public void testConstructor() {
        System.out.println("=== TEST CONSTRUCTOR ===");

        assertNotNull(giaoDich1.getThoiGianGiaoDich(), "Thời gian giao dịch không được null");
        assertEquals(khachHang1, giaoDich1.getKhachHang(), "Khách hàng không đúng");
        assertEquals(sanPham1, giaoDich1.getSanPham(), "Sản phẩm không đúng");
        assertEquals(2, giaoDich1.getSoLuong(), "Số lượng không đúng");

        System.out.println("✓ Constructor OK");
    }

    @Test
    public void testTinhTongTien() {
        System.out.println("=== TEST Tính Tổng Tiền ===");

        double tongTien1 = giaoDich1.tinhTongTien();
        double tongTien2 = giaoDich2.tinhTongTien();

        assertEquals(30000000, tongTien1, "Tổng tiền giao dịch 1 không chính xác");
        assertEquals(45000000, tongTien2, "Tổng tiền giao dịch 2 không chính xác");

        System.out.println("✓ Tính Tổng Tiền OK");
    }

    @Test
    public void testSetAndGet() {
        System.out.println("=== TEST SETTERS/GETTERS ===");

        giaoDich1.setSoLuong(4);
        assertEquals(4, giaoDich1.getSoLuong(), "Số lượng giao dịch không được cập nhật");

        // Kiểm tra các getter
        assertEquals(khachHang1, giaoDich1.getKhachHang(), "Khách hàng không đúng");
        assertEquals(sanPham1, giaoDich1.getSanPham(), "Sản phẩm không đúng");

        System.out.println("✓ Setters/Getter OK");
    }

    @Test
    public void testGetThoiGianGiaoDich() {
        System.out.println("=== TEST Get Thời Gian Giao Dịch ===");

        LocalDateTime thoiGianGiaoDich = giaoDich1.getThoiGianGiaoDich();
        assertNotNull(thoiGianGiaoDich, "Thời gian giao dịch không được null");

        System.out.println("✓ Get Thời Gian Giao Dịch OK");
    }

    @Test
    public void testGetKhachHang() {
        System.out.println("=== TEST Get Khách Hàng ===");

        assertEquals(khachHang1, giaoDich1.getKhachHang(), "Khách hàng không đúng");

        System.out.println("✓ Get Khách Hàng OK");
    }

    @Test
    public void testGetSanPham() {
        System.out.println("=== TEST Get Sản Phẩm ===");

        assertEquals(sanPham1, giaoDich1.getSanPham(), "Sản phẩm không đúng");

        System.out.println("✓ Get Sản Phẩm OK");
    }

    @Test
    public void testGetSoLuong() {
        System.out.println("=== TEST Get Số Lượng ===");

        assertEquals(2, giaoDich1.getSoLuong(), "Số lượng giao dịch không đúng");

        System.out.println("✓ Get Số Lượng OK");
    }

    @Test
    public void testThoiGianGiaoDich() {
        System.out.println("=== TEST Thời Gian Giao Dịch ===");

        assertNotNull(giaoDich1.getThoiGianGiaoDich(), "Thời gian giao dịch không được null");
        
        System.out.println("✓ Thời Gian Giao Dịch OK");
    }
}
