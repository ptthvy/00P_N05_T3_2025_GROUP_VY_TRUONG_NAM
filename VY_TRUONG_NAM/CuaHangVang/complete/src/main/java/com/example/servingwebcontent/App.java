package com.example.servingwebcontent;

import test.TestGoldShopPNJ;  // Đảm bảo rằng TestGoldShopPNJ đã được viết đúng
import test.TestQuanLyGiaoDich;
import test.TestQuanLyKhachHang;
import test.TestQuanLySanPham;

public class App {
    public static void main(String[] args) {
        // Gọi các bài kiểm thử
        System.out.println("Bắt đầu kiểm thử GoldShop PNJ...");
        TestGoldShopPNJ.testGoldShopPNJ();  // Gọi phương thức testGoldShopPNJ từ TestGoldShopPNJ
        
        System.out.println("Bắt đầu kiểm thử Quản lý Giao Dịch...");
        TestQuanLyGiaoDich.testQuanLyGiaoDich();  // Gọi phương thức testQuanLyGiaoDich từ TestQuanLyGiaoDich
        
        System.out.println("Bắt đầu kiểm thử Quản lý Khách Hàng...");
        TestQuanLyKhachHang.testQuanLyKhachHang();  // Gọi phương thức testQuanLyKhachHang từ TestQuanLyKhachHang
        
        System.out.println("Bắt đầu kiểm thử Quản lý Sản Phẩm...");
        TestQuanLySanPham.testQuanLySanPham();  // Gọi phương thức testQuanLySanPham từ TestQuanLySanPham
    }
}
