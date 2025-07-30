package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.GiaoDich;
import java.util.ArrayList;

public class QuanLyGiaoDich {
    private ArrayList<GiaoDich> danhSach = new ArrayList<>();

    public void them(GiaoDich gd) {
        danhSach.add(gd);
    }

    public ArrayList<GiaoDich> getDanhSach() {
        return danhSach;
    }
}
