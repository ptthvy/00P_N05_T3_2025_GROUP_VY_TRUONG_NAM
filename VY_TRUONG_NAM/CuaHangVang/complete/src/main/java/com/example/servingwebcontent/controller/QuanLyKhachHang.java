package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.KhachHang;
import java.util.ArrayList;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> danhSach = new ArrayList<>();

    public void them(KhachHang kh) {
        danhSach.add(kh);
    }

    public ArrayList<KhachHang> getDanhSach() {
        return danhSach;
    }
}
