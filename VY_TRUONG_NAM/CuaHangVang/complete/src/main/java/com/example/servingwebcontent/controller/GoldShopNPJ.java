package com.example.servingwebcontent.controller;

import java.util.*;
import java.text.NumberFormat;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;

public class GoldShopNPJ {
    private static QuanLySanPham quanLySanPham = new QuanLySanPham();
    private static QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();
    private static Scanner scanner = new Scanner(System.in);
    private static NumberFormat nf = NumberFormat.getNumberInstance(new Locale("vi", "VN"));

    public static void main(String[] args) {
        khoiTaoDuLieuMau();

        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      HỆ THỐNG TIỆM VÀNG PNJ    ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Quản lý sản phẩm            ║");
            System.out.println("║ 2. Quản lý khách hàng          ║");
            System.out.println("║ 3. Quản lý giao dịch           ║");
            System.out.println("║ 4. Thống kê doanh thu          ║");
            System.out.println("║ 5. Thoát chương trình          ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-5): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: quanLySanPhamMenu(); break;
                    case 2: quanLyKhachHangMenu(); break;
                    case 3: quanLyGiaoDichMenu(); break;
                    case 4: thongKeDoanhThu(); break;
                    case 5: 
                        System.out.println("Cảm ơn đã sử dụng chương trình!");
                        return;
                    default: 
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }

    // Khởi tạo dữ liệu mẫu ban đầu
    private static void khoiTaoDuLieuMau() {
        quanLySanPham.them(new SanPham("Nhẫn vàng 24K", 5000.0, null));
        quanLySanPham.them(new SanPham("Dây chuyền vàng 18K", 7000.0, null));
        quanLySanPham.them(new SanPham("Nhẫn vàng 24K", 5000.0, null));
        quanLySanPham.them(new SanPham("Dây chuyền vàng 18K", 7000.0, null));
        quanLyKhachHang.them(new KhachHang("Nguyễn Văn A", "0909123456"));
        quanLyKhachHang.them(new KhachHang("Trần Thị B", "0912345678"));
    }

    // Menu quản lý sản phẩm
    private static void quanLySanPhamMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ SẢN PHẨM ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) break;
            switch (choice) {
                case 1: themSanPham(); break;
                case 2: hienThiSanPham(); break;
                case 3: suaSanPham(); break;
                case 4: xoaSanPham(); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void themSanPham() {
        System.out.print("Tên sản phẩm: ");
        String ten = scanner.nextLine();
        System.out.print("Giá: ");
    
        double gia = 0;
        quanLySanPham.them(new SanPham(ten, gia, ten));

        System.out.println("Đã thêm sản phẩm!");
        hienThiSanPham();
    }

    private static void hienThiSanPham() {
        System.out.println("--- Danh sách sản phẩm ---");
        List<SanPham> ds = quanLySanPham.getDanhSach();
        if (ds.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào.");
            return;
        }
        System.out.printf("%-3s %-25s %-15s%n", "STT", "Tên sản phẩm", "Giá (VNĐ)");
        int i = 1;
        for (SanPham sp : ds) {
            System.out.printf("%-3d %-25s %-15s%n", i++, sp.getName(), nf.format(sp.getPrice()));
        }
    }
    private static void suaSanPham() {
        hienThiSanPham();
        System.out.print("Nhập số thứ tự sản phẩm muốn sửa: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= quanLySanPham.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        System.out.print("Tên mới: ");
        String ten = scanner.nextLine();
        System.out.print("Giá mới: ");
        double gia = Double.parseDouble(scanner.nextLine());

        quanLySanPham.sua(idx, new SanPham(ten, gia, ten));
        quanLySanPham.sua(idx, new SanPham(ten, gia, ten));
        System.out.println("Đã sửa sản phẩm!");
        hienThiSanPham();
    }

    private static void xoaSanPham() {
        hienThiSanPham();
        System.out.print("Nhập số thứ tự sản phẩm muốn xóa: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= quanLySanPham.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        quanLySanPham.xoa(idx);
        System.out.println("Đã xóa sản phẩm!");
        hienThiSanPham();
    }

    private static void quanLyKhachHangMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) break;
            switch (choice) {
                case 1: themKhachHang(); break;
                case 2: hienThiKhachHang(); break;
                case 3: suaKhachHang(); break;
                case 4: xoaKhachHang(); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

   
    private static void themKhachHang() {
        System.out.print("Tên khách hàng: ");
        String ten = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String sdt = scanner.nextLine();
        quanLyKhachHang.them(new KhachHang(ten, sdt));
        System.out.println("Đã thêm khách hàng!");
        hienThiKhachHang();
    }

   
    private static void hienThiKhachHang() {
        System.out.println("--- Danh sách khách hàng ---");
        List<KhachHang> ds = quanLyKhachHang.getDanhSach();
        if (ds.isEmpty()) {
            System.out.println("Chưa có khách hàng nào.");
            return;
        }
        System.out.printf("%-3s %-25s %-15s%n", "STT", "Tên khách hàng", "SĐT");
        int i = 1;
        for (KhachHang kh : ds) {
            System.out.printf("%-3d %-25s %-15s%n", i++, kh.getName(), kh.getPhone());
        }
    }

    
    private static void suaKhachHang() {
        hienThiKhachHang();
        System.out.print("Nhập số thứ tự khách hàng muốn sửa: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= quanLyKhachHang.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        System.out.print("Tên mới: ");
        String ten = scanner.nextLine();
        System.out.print("SĐT mới: ");
        String sdt = scanner.nextLine();
        quanLyKhachHang.sua(idx, new KhachHang(ten, sdt));
        System.out.println("Đã sửa khách hàng!");
        hienThiKhachHang();
    }

    private static void xoaKhachHang() {
        hienThiKhachHang();
        System.out.print("Nhập số thứ tự khách hàng muốn xóa: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= quanLyKhachHang.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        quanLyKhachHang.xoa(idx);
        System.out.println("Đã xóa khách hàng!");
        hienThiKhachHang();
    }

    
    private static void quanLyGiaoDichMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ GIAO DỊCH ---");
            System.out.println("1. Thêm giao dịch mới");
            System.out.println("2. Hiển thị danh sách giao dịch");
            System.out.println("3. Xóa giao dịch");
            System.out.println("4. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 4) break;
            switch (choice) {
                case 1: themGiaoDich(); break;
                case 2: hienThiGiaoDich(); break;
                case 3: xoaGiaoDich(); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }


    private static void themGiaoDich() {
        System.out.println("--- Thêm giao dịch mới ---");
        hienThiKhachHang();
        System.out.print("Chọn số thứ tự khách hàng: ");
        int idxKH = Integer.parseInt(scanner.nextLine()) - 1;
        if (idxKH < 0 || idxKH >= quanLyKhachHang.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        hienThiSanPham();
        System.out.print("Chọn số thứ tự sản phẩm: ");
        int idxSP = Integer.parseInt(scanner.nextLine()) - 1;
        if (idxSP < 0 || idxSP >= quanLySanPham.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        System.out.print("Nhập số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        GiaoDich gd = new GiaoDich(
            quanLyKhachHang.getDanhSach().get(idxKH),
            quanLySanPham.getDanhSach().get(idxSP),
            soLuong
        );
        quanLyGiaoDich.them(gd);
        System.out.println("Đã thêm giao dịch!");
        hienThiGiaoDich();
    }
    private static void hienThiGiaoDich() {
        System.out.println("--- Danh sách giao dịch ---");
        List<GiaoDich> ds = quanLyGiaoDich.getDanhSach();
        if (ds.isEmpty()) {
            System.out.println("Chưa có giao dịch nào.");
            return;
        }
        System.out.printf("%-3s %-20s %-20s %-10s %-15s%n", "STT", "Khách hàng", "Sản phẩm", "SL", "Tổng tiền");
        int i = 1;
        for (GiaoDich gd : ds) {
            System.out.printf("%-3d %-20s %-20s %-10d %-15s%n",
                i++, gd.getKhachHang().getName(), gd.getSanPham().getName(),
                gd.getSoLuong(), nf.format(gd.tinhTongTien()));
        }
    }

    private static void xoaGiaoDich() {
        hienThiGiaoDich();
        System.out.print("Nhập số thứ tự giao dịch muốn xóa: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= quanLyGiaoDich.getDanhSach().size()) {
            System.out.println("Không hợp lệ!");
            return;
        }
        quanLyGiaoDich.xoa(idx);
        System.out.println("Đã xóa giao dịch!");
        hienThiGiaoDich();
    }

    private static void thongKeDoanhThu() {
        System.out.println("--- Thống kê doanh thu ---");
        double tong = quanLyGiaoDich.getDanhSach().stream()
            .mapToDouble(GiaoDich::tinhTongTien).sum();
        System.out.println("Tổng doanh thu: " + nf.format(tong) + " VNĐ");
    }
}