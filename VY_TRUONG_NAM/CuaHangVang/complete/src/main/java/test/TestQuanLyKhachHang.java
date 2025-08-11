package com.example.servingwebcontent;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.QuanLyKhachHang;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuanlyKhachHang {

    private QuanLyKhachHang quanLyKhachHang;

    @BeforeEach
    public void setUp() {
        quanLyKhachHang = new QuanLyKhachHang();
        // Thêm một khách hàng giả định
        quanLyKhachHang.themKhachHang(new KhachHang("K001", "Nguyen Van A", 30, "0123456789", "a@gmail.com"));
    }

    @Test
    public void testThemKhachHang() {
        try {
            KhachHang kh = new KhachHang("K002", "Tran Thi B", 25, "0987654321", "b@gmail.com");
            quanLyKhachHang.themKhachHang(kh);
            assertNotNull(quanLyKhachHang.getKhachHangByCCCD("K002"));
            assertEquals("Tran Thi B", quanLyKhachHang.getKhachHangByCCCD("K002").getTen());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi thêm khách hàng: " + e.getMessage());
        }
    }

    @Test
    public void testSuaKhachHang() {
        try {
            KhachHang khUpdated = new KhachHang("K001", "Nguyen Van C", 35, "0123456789", "c@gmail.com");
            quanLyKhachHang.suaKhachHang("K001", khUpdated);
            assertEquals("Nguyen Van C", quanLyKhachHang.getKhachHangByCCCD("K001").getTen());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi sửa thông tin khách hàng: " + e.getMessage());
        }
    }

    @Test
    public void testXoaKhachHang() {
        try {
            quanLyKhachHang.xoaKhachHang("K001");
            assertNull(quanLyKhachHang.getKhachHangByCCCD("K001"));
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi xóa khách hàng: " + e.getMessage());
        }
    }

    @Test
    public void testTimKiemTheoTen() {
        try {
            KhachHang kh = new KhachHang("K003", "Nguyen Thi D", 28, "0333456789", "d@gmail.com");
            quanLyKhachHang.themKhachHang(kh);

            assertTrue(quanLyKhachHang.timKiemTheoTen("Nguyen").size() > 0);
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi tìm kiếm khách hàng: " + e.getMessage());
        }
    }
}
