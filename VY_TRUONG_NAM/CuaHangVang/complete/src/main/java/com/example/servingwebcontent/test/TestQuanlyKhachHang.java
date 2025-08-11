package com.example.servingwebcontent.test;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.KhachHang;

import java.util.List;
import java.util.Scanner;

public class TestQuanlyKhachHang {

    private static KhachHangAiven dao = new KhachHangAiven();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ KHÁCH HÀNG =====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Xem danh sách khách hàng");
            System.out.println("3. Cập nhật khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themKhachHang();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    capNhatKhachHang();
                    break;
                case 4:
                    xoaKhachHang();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void themKhachHang() {
        try {
            System.out.print("Nhập tên khách hàng: ");
            String ten = sc.nextLine();
            System.out.print("Nhập số điện thoại: ");
            String sdt = sc.nextLine();

            KhachHang kh = new KhachHang(ten, sdt);
            dao.addKhachHang(kh);
            System.out.println("Thêm khách hàng thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm khách hàng: " + e.getMessage());
        }
    }

    private static void hienThiDanhSach() {
        List<KhachHang> list = dao.getAllKhachHang();
        if (list.isEmpty()) {
            System.out.println("Chưa có khách hàng nào.");
        } else {
            System.out.println("Danh sách khách hàng:");
            for (KhachHang kh : list) {
                System.out.printf("ID: %d | Tên: %s | SĐT: %s%n", kh.getId(), kh.getTen(), kh.getSdt());
            }
        }
    }

    private static void capNhatKhachHang() {
        try {
            System.out.print("Nhập ID khách hàng cần cập nhật: ");
            int id = Integer.parseInt(sc.nextLine());
            KhachHang kh = new KhachHang(null, null);
            kh.setTen(id);

            System.out.print("Nhập tên mới: ");
            kh.setTen(sc.nextLine());
            System.out.print("Nhập số điện thoại mới: ");
            kh.setSdt(sc.nextLine());

            dao.updateKhachHang(kh);
            System.out.println("Cập nhật khách hàng thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật khách hàng: " + e.getMessage());
        }
    }

    private static void xoaKhachHang() {
        try {
            System.out.print("Nhập ID khách hàng cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            dao.deleteKhachHang(id);
            System.out.println("Xóa khách hàng thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa khách hàng: " + e.getMessage());
        }
    }
}
