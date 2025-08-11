package com.example.servingwebcontent;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.QuanLyGiaoDich;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuanlyGiaoDich {

    private QuanLyGiaoDich quanLyGiaoDich;
    private KhachHang khachHang;
    private SanPham sanPham;

    @BeforeEach
    public void setUp() {
        quanLyGiaoDich = new QuanLyGiaoDich();
        khachHang = new KhachHang("K001", "Nguyen Van A", 30, "0123456789", "a@gmail.com");
        sanPham = new SanPham("SP001", "Laptop Dell", 15000000, 10);

        GiaoDich giaoDich = new GiaoDich(khachHang, sanPham, 2);
        quanLyGiaoDich.themGiaoDich(giaoDich);
    }

    @Test
    public void testThemGiaoDich() {
        try {
            GiaoDich giaoDich = new GiaoDich(khachHang, sanPham, 3);
            quanLyGiaoDich.themGiaoDich(giaoDich);

            assertNotNull(quanLyGiaoDich.getGiaoDichByKhachHang(khachHang));
            assertEquals(3, quanLyGiaoDich.getGiaoDichByKhachHang(khachHang).size());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi thêm giao dịch: " + e.getMessage());
        }
    }

    @Test
    public void testTinhTongTienGiaoDich() {
        try {
            double tongTien = quanLyGiaoDich.tinhTongTien();
            assertEquals(15000000 * 10 * 2, tongTien); // Sản phẩm * Số lượng giao dịch
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi tính tổng tiền giao dịch: " + e.getMessage());
        }
    }

    @Test
    public void testXoaGiaoDich() {
        try {
            GiaoDich giaoDich = new GiaoDich(khachHang, sanPham, 3);
            quanLyGiaoDich.themGiaoDich(giaoDich);

            quanLyGiaoDich.xoaGiaoDich(giaoDich);
            assertEquals(1, quanLyGiaoDich.getGiaoDichByKhachHang(khachHang).size());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi xóa giao dịch: " + e.getMessage());
        }
    }

    @Test
    public void testSuaGiaoDich() {
        try {
            GiaoDich giaoDichUpdated = new GiaoDich(khachHang, sanPham, 4);
            quanLyGiaoDich.suaGiaoDich(giaoDichUpdated);

            assertEquals(4, quanLyGiaoDich.getGiaoDichByKhachHang(khachHang).get(0).getSoLuong());
        } catch (Exception e) {
            fail("Có lỗi xảy ra khi sửa giao dịch: " + e.getMessage());
        }
    }
}
