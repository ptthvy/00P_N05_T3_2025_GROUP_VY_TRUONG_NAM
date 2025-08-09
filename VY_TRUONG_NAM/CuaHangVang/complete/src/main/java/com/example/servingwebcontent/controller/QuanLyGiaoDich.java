package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.GiaoDich;
import java.util.ArrayList;

public class QuanLyGiaoDich {
    private ArrayList<GiaoDich> danhSach = new ArrayList<>();

    public void them(GiaoDich gd) {
        danhSach.add(gd);
    }

    public void sua(int index, GiaoDich gd) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, gd);
        }
    }

    public void capNhat(int index, String tenGD, double soTien, String ngayGD) {
        if (index >= 0 && index < danhSach.size()) {
            GiaoDich gd = danhSach.get(index);
            if (tenGD != null) gd.setTenGiaoDich(tenGD);
            if (soTien >= 0) gd.setSoTien(soTien);
            if (ngayGD != null) gd.setNgayGiaoDich(ngayGD);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public ArrayList<GiaoDich> getDanhSach() {
        return danhSach;
    }
}
