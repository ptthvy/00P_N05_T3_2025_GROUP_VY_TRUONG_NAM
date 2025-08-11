package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.KhachHang;
import java.util.ArrayList;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> danhSach = new ArrayList<>();

    public void them(KhachHang kh) {
        danhSach.add(kh);
    }

    public void sua(int index, KhachHang kh) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, kh);
        }
    }

   
    public void capNhat(int index, String ten, String diaChi, String soDienThoai) {
        if (index >= 0 && index < danhSach.size()) {
            KhachHang kh = danhSach.get(index);
            if (ten != null && !ten.isEmpty()) kh.setTen(ten);
            if (diaChi != null && !diaChi.isEmpty()) kh.setDiaChi(diaChi);
            if (soDienThoai != null && !soDienThoai.isEmpty()) kh.setSoDienThoai(soDienThoai);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public ArrayList<KhachHang> getDanhSach() {
        return danhSach;
    }

    public Object getDanhSachKhachHang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDanhSachKhachHang'");
    }

    public void themKhachHang(String kh1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'themKhachHang'");
    }

    public void themKhachHang(KhachHang kh1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'themKhachHang'");
    }

    public void xoaKhachHang(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xoaKhachHang'");
    }
}
