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

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public ArrayList<KhachHang> getDanhSach() {
        return danhSach;
    }

    public KhachHang timTheoTen(String ten) {
        for (KhachHang kh : danhSach) {
            if (kh.getName().equalsIgnoreCase(ten)) {
                return kh;
            }
        }
        return null;
    }
}