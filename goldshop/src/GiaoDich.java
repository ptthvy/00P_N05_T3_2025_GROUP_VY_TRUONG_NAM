import java.util.Scanner;

public class GiaoDich {
    private String maGD;
    private String maKH;
    private String maSP;
    private int soLuong;
    private double donGia;

    public GiaoDich() {}

    public GiaoDich(String maGD, String maKH, String maSP, int soLuong, double donGia) {
        this.maGD = maGD;
        this.maKH = maKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public void nhapTuBanPhim(Scanner sc) {
        System.out.print("Nhập mã giao dịch: ");
        maGD = sc.nextLine();

        System.out.print("Nhập mã khách hàng: ");
        maKH = sc.nextLine();

        System.out.print("Nhập mã sản phẩm: ");
        maSP = sc.nextLine();

        System.out.print("Nhập số lượng: ");
        soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập đơn giá: ");
        donGia = Double.parseDouble(sc.nextLine());
    }

    public void hienThi() {
        System.out.println("Mã GD: " + maGD + " | KH: " + maKH + " | SP: " + maSP +
                           " | SL: " + soLuong + " | Đơn giá: " + donGia + " | Thành tiền: " + tinhThanhTien());
    }

    public double tinhThanhTien() {
        return soLuong * donGia;
    }

    public String getMaGD() { return maGD; }
    public String getMaKH() { return maKH; }
    public String getMaSP() { return maSP; }
}
