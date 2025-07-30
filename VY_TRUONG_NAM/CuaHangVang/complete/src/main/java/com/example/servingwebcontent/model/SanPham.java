package com.example.servingwebcontent.model;

public class SanPham {
    private String ten;
    private double donGia;

    public SanPham() {}

    public SanPham(String ten, double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    public String getTen() {
        return ten;
    }

    public double getDonGia() {
        return donGia;
    }
}
