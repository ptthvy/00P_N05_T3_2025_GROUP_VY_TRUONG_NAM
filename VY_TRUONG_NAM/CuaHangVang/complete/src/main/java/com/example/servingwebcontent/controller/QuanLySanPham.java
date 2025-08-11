package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.SanPham;
import java.util.ArrayList;

public class QuanLySanPham {
    private ArrayList<SanPham> danhSach = new ArrayList<>();

    public void them(SanPham sp) {
        danhSach.add(sp);
    }

    public void sua(int index, SanPham sp) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, sp);
        }
    }

    // Cập nhật một số thông tin của sản phẩm theo index
    public void capNhat(int index, String ten, double gia, int soLuong) {
        if (index >= 0 && index < danhSach.size()) {
            SanPham sp = danhSach.get(index);
            if (ten != null && !ten.isEmpty()) sp.setTen(ten);
            if (gia >= 0) sp.setGia(gia);
            if (soLuong >= 0) sp.setSoLuong(soLuong);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public ArrayList<SanPham> getDanhSach() {
        return danhSach;
    }

    public void capNhatSanPham(String string, SanPham spCapNhat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'capNhatSanPham'");
    }

    public SanPham timSanPham(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timSanPham'");
    }

    public void xoaSanPham(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xoaSanPham'");
    }

    public void themSanPham(SanPham sp2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'themSanPham'");
    }
}
