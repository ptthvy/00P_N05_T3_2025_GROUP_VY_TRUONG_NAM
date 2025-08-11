package com.example.servingwebcontent.model;

import java.time.LocalDateTime;
import java.util.Date;

@SuppressWarnings("unused")
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

    // Constructor với tham số kiểu int và java.util.Date
    public GiaoDich(int int1, int int2, int int3, int int4, java.util.Date ngay) {
        // TODO: Implement constructor logic
    }

    // Getters
    public KhachHang getKhachHang() { 
        return khachHang; 
    }

    public SanPham getSanPham() { 
        return sanPham; 
    }

    public int getSoLuong() { 
        return soLuong; 
    }

    public LocalDateTime getThoiGianGiaoDich() { 
        return thoiGianGiaoDich; 
    }

    // Tính tổng tiền của giao dịch
    public double tinhTongTien() {
        return sanPham.getPrice() * soLuong;
    }

    // Placeholder methods that throw UnsupportedOperationException
    public void setTenGiaoDich(String tenGD) {
        throw new UnsupportedOperationException("Unimplemented method 'setTenGiaoDich'");
    }

    public void setSoTien(double soTien) {
        throw new UnsupportedOperationException("Unimplemented method 'setSoTien'");
    }

    public void setNgayGiaoDich(Date ngayGD) {
        throw new UnsupportedOperationException("Unimplemented method 'setNgayGiaoDich'");
    }

    public int getIdSanPham() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdSanPham'");
    }

    public int getIdKhachHang() {
        throw new UnsupportedOperationException("Unimplemented method 'getIdKhachHang'");
    }

    public java.util.Date getNgayGiaoDich() {
        throw new UnsupportedOperationException("Unimplemented method 'getNgayGiaoDich'");
    }

    public int getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    // Setters
    public void setSoLuong(int soLuong) {
        throw new UnsupportedOperationException("Unimplemented method 'setSoLuong'");
    }

    public void setNgayGiaoDich(String ngayGD) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNgayGiaoDich'");
    }
}
