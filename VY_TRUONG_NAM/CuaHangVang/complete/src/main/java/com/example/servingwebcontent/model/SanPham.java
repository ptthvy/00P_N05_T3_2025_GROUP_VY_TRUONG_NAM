package com.example.servingwebcontent.model;

public class SanPham {
    private String name;
    private double price;
    private String imageUrl;

    public SanPham(String name, double price, String ten) {
        this.name = name;
        this.price = price;
        this.imageUrl = ten;
    }

    public SanPham(int i, String name, double price, int j) {
        this(name, price, null);
    }

    public SanPham(String ten, double gia, int soluong) {
        //TODO Auto-generated constructor stub
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void setTen(String ten) {
        throw new UnsupportedOperationException("Unimplemented method 'setTen'");
    }

    public void setGia(double gia) {
        throw new UnsupportedOperationException("Unimplemented method 'setGia'");
    }

    public void setSoLuong(int soLuong) {
        throw new UnsupportedOperationException("Unimplemented method 'setSoLuong'");
    }

    public String getTen() {
        throw new UnsupportedOperationException("Unimplemented method 'getTen'");
    }

    public int getSoLuong() {
        throw new UnsupportedOperationException("Unimplemented method 'getSoLuong'");
    }

    public double getGia() {
        throw new UnsupportedOperationException("Unimplemented method 'getGia'");
    }
}