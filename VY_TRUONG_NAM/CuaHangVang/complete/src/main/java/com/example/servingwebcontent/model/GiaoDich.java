package com.example.servingwebcontent.model;

public class GiaoDich {
    private KhachHang khachHang;
    private SanPham sanPham;
    private int soLuong;

    public GiaoDich() {}

    public GiaoDich(KhachHang khachHang, SanPham sanPham, int soLuong) {
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return soLuong * sanPham.getDonGia();
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }
}
