package com.example.servingwebcontent.model;

import java.sql.Date;
import java.time.LocalDateTime;

<<<<<<< HEAD
=======
@SuppressWarnings("unused")
>>>>>>> dfa3c77 (vy commit)
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

<<<<<<< HEAD
    public GiaoDich(int int1, int int2, int int3, int int4, Date date) {
        //TODO Auto-generated constructor stub
=======
    public GiaoDich(int int1, int int2, int int3, int int4, java.util.Date ngay) {
       
>>>>>>> dfa3c77 (vy commit)
    }

    public KhachHang getKhachHang() { return khachHang; }
    public SanPham getSanPham() { return sanPham; }
    public int getSoLuong() { return soLuong; }
    public LocalDateTime getThoiGianGiaoDich() { return thoiGianGiaoDich; }

    public double tinhTongTien() {
        return sanPham.getPrice() * soLuong;
    }

    public void setTenGiaoDich(String tenGD) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTenGiaoDich'");
    }

    public void setSoTien(double soTien) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoTien'");
    }

<<<<<<< HEAD
    public void setNgayGiaoDich(String ngayGD) {
=======
    public void setNgayGiaoDich(java.util.Date ngayGD) {
>>>>>>> dfa3c77 (vy commit)
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNgayGiaoDich'");
    }

    public int getIdSanPham() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdSanPham'");
    }

    public int getIdKhachHang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdKhachHang'");
    }

    public java.util.Date getNgayGiaoDich() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNgayGiaoDich'");
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
<<<<<<< HEAD
=======

    public void setSoLuong(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoLuong'");
    }

    public void setNgayGiaoDich(String ngayGD) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNgayGiaoDich'");
    }
>>>>>>> dfa3c77 (vy commit)
}