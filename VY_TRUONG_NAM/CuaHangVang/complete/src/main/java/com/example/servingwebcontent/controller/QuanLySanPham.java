package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.SanPham;
import java.util.ArrayList;

public class QuanLySanPham {
    private ArrayList<SanPham> danhSach = new ArrayList<>();

    public void them(SanPham sp) {
        danhSach.add(sp);
    }

    public ArrayList<SanPham> getDanhSach() {
        return danhSach;
    }
}
