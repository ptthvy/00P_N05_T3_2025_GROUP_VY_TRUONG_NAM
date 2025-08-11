package com.example.servingwebcontent.model;

public class KhachHang {
    private String name;
    private String phone;

    public KhachHang(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }

    public void setDiaChi(String diaChi) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDiaChi'");
    }

    public void setSoDienThoai(String soDienThoai) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoDienThoai'");
    }

    public void setTen(String ten) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTen'");
    }

    public String getTen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTen'");
    }

    public String getSdt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSdt'");
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}