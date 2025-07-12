
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SanPham implements Serializable {
    private String maSP;
    private String loaiSP;
    private double giaSP;

    public static List<SanPham> danhSach = new ArrayList<>();

    public SanPham(String maSP, String loaiSP, double giaSP) {
        this.maSP = maSP;
        this.loaiSP = loaiSP;
        this.giaSP = giaSP;
    }

    public String getMaSP() { return maSP; }
    public String getLoaiSP() { return loaiSP; }
    public double getGiaSP() { return giaSP; }

    public void setLoaiSP(String loaiSP) { this.loaiSP = loaiSP; }
    public void setGiaSP(double giaSP) { this.giaSP = giaSP; }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", loaiSP='" + loaiSP + '\'' +
                ", giaSP=" + giaSP +
                '}';
    }

    public static void them(SanPham sp) {
        danhSach.add(sp);
    }

    public static boolean sua(String maSP, String loaiMoi, double giaMoi) {
        for (SanPham sp : danhSach) {
            if (sp.getMaSP().equalsIgnoreCase(maSP)) {
                sp.setLoaiSP(loaiMoi);
                sp.setGiaSP(giaMoi);
                return true;
            }
        }
        return false;
    }

    public static boolean xoa(String maSP) {
        return danhSach.removeIf(sp -> sp.getMaSP().equalsIgnoreCase(maSP));
    }

    public static void hienThiTatCa() {
        if (danhSach.isEmpty()) System.out.println("Danh sách SP trống.");
        for (SanPham sp : danhSach) System.out.println(sp);
    }
}