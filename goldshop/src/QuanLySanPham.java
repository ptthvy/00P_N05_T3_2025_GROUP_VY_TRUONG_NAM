import java.util.ArrayList;

public class QuanLySanPham {
    private ArrayList<SanPham> danhSachSP = new ArrayList<>();

    public void themSanPham(SanPham sp) {
        danhSachSP.add(sp);
    }

    public void hienThiTatCa() {
        for (SanPham sp : danhSachSP) {
            sp.hienThi();
        }
    }

    public void timKiemSanPham(String tuKhoa) {
        System.out.println("=== Kết quả tìm kiếm với từ khóa '" + tuKhoa + "' ===");
        boolean timThay = false;
        for (SanPham sp : danhSachSP) {
            if (sp.getMaSP().equalsIgnoreCase(tuKhoa) ||
                sp.getTenSP().toLowerCase().contains(tuKhoa.toLowerCase())) {
                sp.hienThi();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm nào phù hợp.");
        }
    }
}
