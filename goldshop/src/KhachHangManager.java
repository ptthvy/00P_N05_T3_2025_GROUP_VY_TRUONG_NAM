import java.util.ArrayList;
import java.util.List;

public class KhachHangManager {
    private List<KhachHang> danhSach = new ArrayList<>();

    public void themKhachHang(KhachHang kh) {
        danhSach.add(kh);
    }

    public void suaKhachHang(String id, String tenMoi) {
        for (KhachHang kh : danhSach) {
            if (kh.getId().equals(id)) {
                kh.setTen(tenMoi);
                return;
            }
        }
    }

    public void xoaKhachHang(String id) {
        danhSach.removeIf(kh -> kh.getId().equals(id));
    }

    public void hienThiKhachHang() {
        for (KhachHang kh : danhSach) {
            System.out.println("KhachHang ID: " + kh.getId() + ", Ten: " + kh.getTen());
        }
    }

    public KhachHang timTheoId(String id) {
        for (KhachHang kh : danhSach) {
            if (kh.getId().equals(id)) return kh;
        }
        return null;
    }
}
