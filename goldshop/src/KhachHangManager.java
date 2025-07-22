import java.util.ArrayList;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> danhSachKH = new ArrayList<>();

    public void themKhachHang(KhachHang kh) {
        danhSachKH.add(kh);
    }

    public void hienThiTatCa() {
        for (KhachHang kh : danhSachKH) {
            System.out.println("Mã: " + kh.getMaKH() + " | Tên: " + kh.getHoTen() + " | SĐT: " + kh.getSoDienThoai());
        }
    }

    public void hienThiKhachHangVip() {
        System.out.println("--- Danh sách khách hàng VIP ---");
        for (KhachHang kh : danhSachKH) {
            if (kiemTraKhachHangVip(kh)) {
                System.out.println("Mã: " + kh.getMaKH() + " | Tên: " + kh.getHoTen() + " | SĐT: " + kh.getSoDienThoai());
            }
        }
    }

    public boolean kiemTraKhachHangVip(KhachHang kh) {
        return kh.getSoDienThoai().endsWith("8888") || kh.getSoDienThoai().endsWith("9999");
    }
}
