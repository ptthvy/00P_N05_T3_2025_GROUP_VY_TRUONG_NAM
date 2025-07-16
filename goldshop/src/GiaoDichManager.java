import java.util.*;

public class GiaoDichManager {
    private List<GiaoDich> danhSach = new ArrayList<>();

    public void themGiaoDich(GiaoDich gd) {
        danhSach.add(gd);
    }

    public void hienThiGiaoDich() {
        for (GiaoDich gd : danhSach) {
            System.out.println("ID: " + gd.getId() +
                ", Khách hàng: " + gd.getKhachHangId() +
                ", Sản phẩm: " + gd.getSanPhamId());
        }
    }

    public void suaGiaoDich(String id, String khachHangIdMoi, String sanPhamIdMoi) {
        for (GiaoDich gd : danhSach) {
            if (gd.getId().equals(id)) {
                gd.setKhachHangId(khachHangIdMoi);
                gd.setSanPhamId(sanPhamIdMoi);
                return;
            }
        }
    }

    public void xoaGiaoDich(String id) {
        danhSach.removeIf(gd -> gd.getId().equals(id));
    }

    public List<GiaoDich> getDanhSach() {
        return danhSach;
    }
}
