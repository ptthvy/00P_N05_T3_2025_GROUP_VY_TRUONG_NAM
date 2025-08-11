package com.example.servingwebcontent.model;

public class KhachHang {
    private String name;
    private String phone;
    private String diaChi; // Đã thêm trường địa chỉ
    private int id; // Thêm ID cho khách hàng

    public KhachHang(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters và Setters
    public String getName() { 
        return name; 
    }

    public String getPhone() { 
        return phone; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setPhone(String phone) { 
        this.phone = phone; 
    }

    // Phương thức setter và getter cho địa chỉ
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Phương thức setter và getter cho ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Các phương thức không cần thiết hoặc chưa triển khai
    public void setTen(String id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setTen'");
    }

    public String getTen() {
        throw new UnsupportedOperationException("Unimplemented method 'getTen'");
    }

    public void setSdt(String sdt) {
        throw new UnsupportedOperationException("Unimplemented method 'setSdt'");
    }

    public String getSdt() {
        throw new UnsupportedOperationException("Unimplemented method 'getSdt'");
    }

    public void setSoDienThoai(String soDienThoai) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoDienThoai'");
    }

    public void setTen(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTen'");
    }
}
