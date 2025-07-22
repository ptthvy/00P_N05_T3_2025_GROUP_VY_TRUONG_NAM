import java.util.Scanner;

public class SanPham {
    private String maSP;
    private String tenSP;
    private double gia;

    public SanPham() {}

    public SanPham(String maSP, String tenSP, double gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
    }

    public void nhapTuBanPhim(Scanner sc) {
        System.out.print("Nhập mã sản phẩm: ");
        maSP = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        tenSP = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        gia = Double.parseDouble(sc.nextLine());
    }

    public void hienThi() {
        System.out.println("Mã: " + maSP + " | Tên: " + tenSP + " | Giá: " + gia + " VND");
    }
    public String getMaSP() { return maSP; }
    public String getTenSP() { return tenSP; }
    public double getGia() { return gia; }
}
