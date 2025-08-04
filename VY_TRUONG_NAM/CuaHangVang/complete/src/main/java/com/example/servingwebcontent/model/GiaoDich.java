package com.example.servingwebcontent.model;

import java.time.LocalDateTime;

public class GiaoDich {
    private KhachHang khachHang;
    private SanPham sanPham;
    private int soLuong;
    private LocalDateTime thoiGianGiaoDich;

    public GiaoDich(KhachHang khachHang, SanPham sanPham, int soLuong) {
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.thoiGianGiaoDich = LocalDateTime.now();
    }

    public KhachHang getKhachHang() { return khachHang; }
    public SanPham getSanPham() { return sanPham; }
    public int getSoLuong() { return soLuong; }
    public LocalDateTime getThoiGianGiaoDich() { return thoiGianGiaoDich; }

    public double tinhTongTien() {
        return sanPham.getPrice() * soLuong;
    }
}