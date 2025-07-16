import java.util.*;

public class SanPhamManager {
    private List<SanPham> danhSach = new ArrayList<>();

    public void themSanPham(SanPham sp) {
        danhSach.add(sp);
    }

    public void hienThiSanPham() {
        for (SanPham sp : danhSach) {
            System.out.println("ID: " + sp.getId() + ", Tên: " + sp.getTen());
        }
    }

    public void suaSanPham(String id, String tenMoi) {
        for (SanPham sp : danhSach) {
            if (sp.getId().equals(id)) {
                sp.setTen(tenMoi);
                return;
            }
        }
    }

    public void xoaSanPham(String id) {
        danhSach.removeIf(sp -> sp.getId().equals(id));
    }

    public List<SanPham> getDanhSach() {
        return danhSach;
    }
}
