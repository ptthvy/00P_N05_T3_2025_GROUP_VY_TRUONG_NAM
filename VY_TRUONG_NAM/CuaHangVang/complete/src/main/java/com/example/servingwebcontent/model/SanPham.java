package com.example.servingwebcontent.model;

public class SanPham {
    private String name;
    private double price;
    private String imageUrl;

    public SanPham(String name, double price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public SanPham(String i, String name, double price, String j) {
        this(name, price, null);
    }

    public SanPham(int int1, String string, double double1, int int2) {
        //TODO Auto-generated constructor stub
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void setTen(String ten) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTen'");
    }

    public void setGia(double gia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGia'");
    }

    public void setSoLuong(int soLuong) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoLuong'");
    }

    public String getTen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTen'");
    }

    public int getSoLuong() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSoLuong'");
    }

    public double getGia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGia'");
    }
}