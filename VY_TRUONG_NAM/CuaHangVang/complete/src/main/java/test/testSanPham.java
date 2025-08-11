package com.example.servingwebcontent;

import com.example.servingwebcontent.model.SanPham;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSanPham {

    private SanPham nhanVang24K;
    private SanPham nhanVang18K;

    @BeforeEach
    public void setUp() {
        // Khởi tạo các sản phẩm nhẫn vàng trước mỗi bài kiểm tra
        nhanVang24K = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, 5, "Vàng 24K", 10.5);
        nhanVang18K = new SanPham("SP002", "Nhẫn Vàng 18K", 4500000, 3, "Vàng 18K", 8.0);
    }

    @Test
    public void testConstructor() {
        System.out.println("=== TEST CONSTRUCTOR ===");

        // Kiểm tra các giá trị khởi tạo
        assertEquals("SP001", nhanVang24K.getId(), "ID sản phẩm không đúng");
        assertEquals("Nhẫn Vàng 24K", nhanVang24K.getTen(), "Tên sản phẩm không đúng");
        assertEquals(5000000, nhanVang24K.getGia(), "Giá sản phẩm không đúng");
        assertEquals(5, nhanVang24K.getSoLuong(), "Số lượng sản phẩm không đúng");
        assertEquals("Vàng 24K", nhanVang24K.getChatLieuVang(), "Chất liệu vàng không đúng");
        assertEquals(10.5, nhanVang24K.getTrongLuong(), "Trọng lượng sản phẩm không đúng");

        System.out.println("✓ Constructor OK");
    }

    @Test
    public void testTinhTongTien() {
        System.out.println("=== TEST TÍNH TỔNG TIỀN ===");

        double tongTien24K = nhanVang24K.tinhTongTien();
        double tongTien18K = nhanVang18K.tinhTongTien();

        assertEquals(5000000 * 5, tongTien24K, "Tổng tiền nhẫn vàng 24K không chính xác");
        assertEquals(4500000 * 3, tongTien18K, "Tổng tiền nhẫn vàng 18K không chính xác");

        System.out.println("✓ Tính Tổng Tiền OK");
    }

    @Test
    public void testGettersAndSetters() {
        System.out.println("=== TEST GETTERS/SETTERS ===");

        // Kiểm tra setter và getter
        nhanVang24K.setGia(5200000);
        nhanVang24K.setSoLuong(6);
        nhanVang24K.setChatLieuVang("Vàng 22K");
        nhanVang24K.setTrongLuong(11.0);

        assertEquals(5200000, nhanVang24K.getGia(), "Giá không được cập nhật");
        assertEquals(6, nhanVang24K.getSoLuong(), "Số lượng không được cập nhật");
        assertEquals("Vàng 22K", nhanVang24K.getChatLieuVang(), "Chất liệu vàng không được cập nhật");
        assertEquals(11.0, nhanVang24K.getTrongLuong(), "Trọng lượng không được cập nhật");

        System.out.println(" Getters/Setters OK");
    }

    @Test
    public void testToString() {
        System.out.println("=== TEST TO STRING ===");

        String expectedString = "SanPham{id='SP001', ten='Nhẫn Vàng 24K', gia=5000000.0, soLuong=5, chatLieuVang='Vàng 24K', trongLuong=10.5}";
        assertEquals(expectedString, nhanVang24K.toString(), "Phương thức toString không đúng");

        System.out.println("ToString OK");
    }
}
