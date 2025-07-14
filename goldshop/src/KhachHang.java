import java.util.ArrayList;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String soDienThoai;

    public KhachHang(String maKH, String tenKH, String soDienThoai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
    }

    public String toString() {
        return "MaKH: " + maKH + ", Ten: " + tenKH + ", SDT: " + soDienThoai;
    }

    private static ArrayList<KhachHang> danhSach = new ArrayList<>();

    public static void them(KhachHang kh) {
        danhSach.add(kh);
    }

    public static boolean sua(String maKH, String tenMoi, String sdtMoi) {
        for (KhachHang kh : danhSach) {
            if (kh.maKH.equalsIgnoreCase(maKH)) {
                kh.tenKH = tenMoi;
                kh.soDienThoai = sdtMoi;
                return true;
            }
        }
        return false;
    }

    public static boolean xoa(String maKH) {
        return danhSach.removeIf(kh -> kh.maKH.equalsIgnoreCase(maKH));
    }

    public static void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
        } else {
            for (KhachHang kh : danhSach) {
                System.out.println(kh);
            }
        }
    }
}
