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

    public SanPham(int i, String name, double price, int j) {
        this(name, price, null);
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void setTen(String ten) {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        
>>>>>>> dfa3c77 (vy commit)
        throw new UnsupportedOperationException("Unimplemented method 'setTen'");
    }

    public void setGia(double gia) {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
       
>>>>>>> dfa3c77 (vy commit)
        throw new UnsupportedOperationException("Unimplemented method 'setGia'");
    }

    public void setSoLuong(int soLuong) {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        
>>>>>>> dfa3c77 (vy commit)
        throw new UnsupportedOperationException("Unimplemented method 'setSoLuong'");
    }

    public String getTen() {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        
>>>>>>> dfa3c77 (vy commit)
        throw new UnsupportedOperationException("Unimplemented method 'getTen'");
    }

    public int getSoLuong() {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        
>>>>>>> dfa3c77 (vy commit)
        throw new UnsupportedOperationException("Unimplemented method 'getSoLuong'");
    }

    public double getGia() {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        
>>>>>>> dfa3c77 (vy commit)
        throw new UnsupportedOperationException("Unimplemented method 'getGia'");
    }
}