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

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public ArrayList<SanPham> getDanhSach() {
        return danhSach;
    }

    public SanPham timTheoTen(String ten) {
        for (SanPham sp : danhSach) {
            if (sp.getName().equalsIgnoreCase(ten)) {
                return sp;
            }
        }
        return null;
    }
}