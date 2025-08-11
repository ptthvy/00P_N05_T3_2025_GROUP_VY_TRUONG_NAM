package com.example.servingwebcontent;

import com.example.servingwebcontent.model.GoldShopPNJ;
import com.example.servingwebcontent.model.SanPham;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGoldshopPNJ {

    private GoldShopPNJ goldShopPNJ;

    @BeforeEach
    public void setUp() {
        // Khởi tạo GoldShopPNJ trước mỗi bài kiểm tra
        goldShopPNJ = new GoldShopPNJ();
    }

    @Test
    public void testThemSanPham() {
        System.out.println("=== TEST THÊM SẢN PHẨM ===");

        SanPham sp = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, 5, "Vàng 24K", 10.5);
        goldShopPNJ.themSanPham(sp);

        assertNotNull(goldShopPNJ.getSanPhamList());
        assertEquals(1, goldShopPNJ.getSanPhamList().size(), "Số lượng sản phẩm không đúng sau khi thêm");
        assertEquals("Nhẫn Vàng 24K", goldShopPNJ.getSanPhamList().get(0).getTen(), "Tên sản phẩm không đúng");

        System.out.println("✓ Thêm Sản Phẩm OK");
    }

    @Test
    public void testCapNhatSanPham() {
        System.out.println("=== TEST CẬP NHẬT SẢN PHẨM ===");

        // Thêm sản phẩm ban đầu
        SanPham sp = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, 5, "Vàng 24K", 10.5);
        goldShopPNJ.themSanPham(sp);

        // Cập nhật sản phẩm
        SanPham spUpdate = new SanPham("SP001", "Nhẫn Vàng 18K", 4500000, 10, "Vàng 18K", 9.0);
        goldShopPNJ.capNhatSanPham("SP001", spUpdate);

        assertEquals("Nhẫn Vàng 18K", goldShopPNJ.getSanPhamList().get(0).getTen(), "Tên sản phẩm sau khi cập nhật không đúng");
        assertEquals(4500000, goldShopPNJ.getSanPhamList().get(0).getGia(), "Giá sản phẩm sau khi cập nhật không đúng");
        assertEquals(10, goldShopPNJ.getSanPhamList().get(0).getSoLuong(), "Số lượng sản phẩm sau khi cập nhật không đúng");

        System.out.println("✓ Cập Nhật Sản Phẩm OK");
    }

    @Test
    public void testXoaSanPham() {
        System.out.println("=== TEST XÓA SẢN PHẨM ===");

        // Thêm sản phẩm ban đầu
        SanPham sp = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, 5, "Vàng 24K", 10.5);
        goldShopPNJ.themSanPham(sp);

        // Xóa sản phẩm
        goldShopPNJ.xoaSanPham("SP001");

        assertEquals(0, goldShopPNJ.getSanPhamList().size(), "Sản phẩm không được xóa đúng cách");

        System.out.println("✓ Xóa Sản Phẩm OK");
    }

    @Test
    public void testTinhTongTien() {
        System.out.println("=== TEST TÍNH TỔNG TIỀN ===");

        SanPham sp1 = new SanPham("SP001", "Nhẫn Vàng 24K", 5000000, 5, "Vàng 24K", 10.5);
        SanPham sp2 = new SanPham("SP002", "Dây Chuyền Vàng 18K", 4000000, 10, "Vàng 18K", 15.0);
        goldShopPNJ.themSanPham(sp1);
        goldShopPNJ.themSanPham(sp2);

        double tongTien = goldShopPNJ.tinhTongTien();
        assertEquals(5000000 * 5 + 4000000 * 10, tongTien, "Tổng tiền không chính xác");

        System.out.println("✓ Tính Tổng Tiền OK");
    }
}
