package com.example.servingwebcontent;

import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.QuanLySanPham;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuanlySanPham {

    private QuanLySanPham quanLySanPham;

    @BeforeEach
    public void setUp() {
        quanLySanPham = new QuanLySanPham();
        // Thêm sản phẩm giả định
        quanLySanPham.themSanPham(new SanPham("SP001", "Laptop Dell", 15000000, 10));
    }

    @Test
    public void testThemSanPham() {
        try {
            SanPham sp = new SanPham("SP002", "Smartphone Samsung", 8000000, 20);
            quanLySanPham.themSanPham(sp);

            assertNotNull(quanLySanPham.getSanPhamById("SP002"));
            assertEquals("Smartphone Samsung", quanLySanPham.getSanPhamById("SP002").getTen());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi thêm sản phẩm: " + e.getMessage());
        }
    }

    @Test
    public void testSuaSanPham() {
        try {
            SanPham spUpdated = new SanPham("SP001", "Laptop HP", 14000000, 15);
            quanLySanPham.suaSanPham("SP001", spUpdated);

            assertEquals("Laptop HP", quanLySanPham.getSanPhamById("SP001").getTen());
            assertEquals(14000000, quanLySanPham.getSanPhamById("SP001").getGia());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi sửa sản phẩm: " + e.getMessage());
        }
    }

    @Test
    public void testXoaSanPham() {
        try {
            quanLySanPham.xoaSanPham("SP001");
            assertNull(quanLySanPham.getSanPhamById("SP001"));
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi xóa sản phẩm: " + e.getMessage());
        }
    }

    @Test
    public void testTinhTongTien() {
        try {
            SanPham sp1 = new SanPham("SP003", "Tablet Samsung", 5000000, 5);
            quanLySanPham.themSanPham(sp1);

            double tongTien = quanLySanPham.tinhTongTien();
            assertEquals(15000000 * 10 + 5000000 * 5, tongTien);
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi tính tổng tiền: " + e.getMessage());
        }
    }
}
