import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GiaoDich implements Serializable {
    private String maGD;
    private String tenKH;
    private String maSP;
    private double tongTien;

    public static List<GiaoDich> danhSach = new ArrayList<>();

    public GiaoDich(String maGD, String tenKH, String maSP, double tongTien) {
        this.maGD = maGD;
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "GiaoDich{" +
                "maGD='" + maGD + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", maSP='" + maSP + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }

    public static void them(GiaoDich gd) {
        danhSach.add(gd);
    }

    public static boolean sua(String maGD, String tenMoi, String maSPMoi, double tongMoi) {
        for (GiaoDich gd : danhSach) {
            if (gd.maGD.equalsIgnoreCase(maGD)) {
                gd.tenKH = tenMoi;
                gd.maSP = maSPMoi;
                gd.tongTien = tongMoi;
                return true;
            }
        }
        return false;
    }

    public static boolean xoa(String maGD) {
        return danhSach.removeIf(gd -> gd.maGD.equalsIgnoreCase(maGD));
    }

    public static void hienThiTatCa() {
        if (danhSach.isEmpty()) System.out.println("Danh sách GD trống.");
        for (GiaoDich gd : danhSach) System.out.println(gd);
    }
}
