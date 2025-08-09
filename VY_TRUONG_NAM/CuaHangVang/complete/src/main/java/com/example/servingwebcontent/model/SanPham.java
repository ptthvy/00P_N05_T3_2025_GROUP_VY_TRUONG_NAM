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

    public SanPham(String name, double price) {
        this(name, price, null);
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
}