package com.example.servingwebcontent.model;

public class KhachHang {
    private String ten;
    private String sdt;

    public KhachHang() {}

    public KhachHang(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }
}
