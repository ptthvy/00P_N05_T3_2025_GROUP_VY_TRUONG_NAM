package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.GiaoDichAiven;
import com.example.servingwebcontent.model.GiaoDich;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestQuanlyGiaoDich {

    private static GiaoDichAiven dao = new GiaoDichAiven();
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ GIAO DỊCH =====");
            System.out.println("1. Thêm giao dịch");
            System.out.println("2. Xem danh sách giao dịch");
            System.out.println("3. Cập nhật giao dịch");
            System.out.println("4. Xóa giao dịch");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themGiaoDich();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    capNhatGiaoDich();
                    break;
                case 4:
                    xoaGiaoDich();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void themGiaoDich() {
        try {
            System.out.print("Nhập ID khách hàng: ");
            int idKhachHang = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập ID sản phẩm: ");
            int idSanPham = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập số lượng: ");
            int soLuong = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập ngày giao dịch (yyyy-MM-dd): ");
            Date ngayGD = sdf.parse(sc.nextLine());

            GiaoDich gd = new GiaoDich(0, idKhachHang, idSanPham, soLuong, ngayGD);
            dao.addGiaoDich(gd);
            System.out.println("Thêm giao dịch thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm giao dịch: " + e.getMessage());
        }
    }

    private static void hienThiDanhSach() {
        List<GiaoDich> list = dao.getAllGiaoDich();
        if (list.isEmpty()) {
            System.out.println("Chưa có giao dịch nào.");
        } else {
            System.out.println("Danh sách giao dịch:");
            for (GiaoDich gd : list) {
                System.out.printf("ID: %d | Khách hàng ID: %d | Sản phẩm ID: %d | Số lượng: %d | Ngày: %s%n",
                        gd.getId(), gd.getIdKhachHang(), gd.getIdSanPham(), gd.getSoLuong(), sdf.format(gd.getNgayGiaoDich()));
            }
        }
    }

    private static void capNhatGiaoDich() {
        try {
            System.out.print("Nhập ID giao dịch cần cập nhật: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập ID khách hàng mới: ");
            int idKhachHang = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập ID sản phẩm mới: ");
            int idSanPham = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập số lượng mới: ");
            int soLuong = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập ngày giao dịch mới (yyyy-MM-dd): ");
            Date ngayGD = sdf.parse(sc.nextLine());

            GiaoDich gd = new GiaoDich(id, idKhachHang, idSanPham, soLuong, ngayGD);
            dao.updateGiaoDich(gd);
            System.out.println("Cập nhật giao dịch thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật giao dịch: " + e.getMessage());
        }
    }

    private static void xoaGiaoDich() {
        try {
            System.out.print("Nhập ID giao dịch cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            dao.deleteGiaoDich(id);
            System.out.println("Xóa giao dịch thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa giao dịch: " + e.getMessage());
        }
    }
}
