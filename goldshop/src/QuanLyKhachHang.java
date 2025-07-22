import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> danhSachKH = new ArrayList<>();

    public void themKhachHang(KhachHang kh) {
        danhSachKH.add(kh);
    }

    public void nhapDanhSachTuBanPhim(Scanner sc) {
        System.out.print("Nhập số lượng khách hàng: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n-- Nhập khách hàng thứ " + (i + 1));
            KhachHang kh = new KhachHang();
            kh.nhapTuBanPhim(sc);
            themKhachHang(kh);
        }
    }

    public void hienThiTatCa() {
        System.out.println("--- Danh sách khách hàng ---");
        for (KhachHang kh : danhSachKH) {
            kh.hienThi();
        }
    }

    public void hienThiKhachHangVip() {
        System.out.println("--- Danh sách khách hàng VIP ---");
        for (KhachHang kh : danhSachKH) {
            if (kiemTraKhachHangVip(kh)) {
                kh.hienThi();
            }
        }
    }

    public boolean kiemTraKhachHangVip(KhachHang kh) {
        return kh.getSoDienThoai().endsWith("8888") || kh.getSoDienThoai().endsWith("9999");
    }
}
