package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.model.SanPham;

import java.util.List;
import java.util.Scanner;

public class TestQuanlySanPham {

    private static SanPhamAiven dao = new SanPhamAiven();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themSanPham();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    capNhatSanPham();
                    break;
                case 4:
                    xoaSanPham();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void themSanPham() {
        try {
            System.out.print("Nhập tên sản phẩm: ");
            String ten = sc.nextLine();
            System.out.print("Nhập giá: ");
            double gia = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập số lượng: ");
            int soluong = Integer.parseInt(sc.nextLine());

            SanPham sp = new SanPham(0, ten, gia, soluong);
            dao.addSanPham(sp);
            System.out.println("Thêm sản phẩm thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
    }

    private static void hienThiDanhSach() {
        List<SanPham> list = dao.getAllSanPham();
        if (list.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (SanPham sp : list) {
                System.out.printf("ID: %d | Tên: %s | Giá: %.2f | Số lượng: %d%n", sp.getGia(), sp.getTen(), sp.getGia(), sp.getSoLuong());
            }
        }
    }

    private static void capNhatSanPham() {
        try {
            System.out.print("Nhập ID sản phẩm cần cập nhật: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên mới: ");
            String ten = sc.nextLine();
            System.out.print("Nhập giá mới: ");
            double gia = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập số lượng mới: ");
            int soluong = Integer.parseInt(sc.nextLine());

            SanPham sp = new SanPham(id, ten, gia, soluong);
            dao.updateSanPham(sp);
            System.out.println("Cập nhật sản phẩm thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }
    }

    private static void xoaSanPham() {
        try {
            System.out.print("Nhập ID sản phẩm cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            dao.deleteSanPham(id);
            System.out.println("Xóa sản phẩm thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
        }
    }
}
