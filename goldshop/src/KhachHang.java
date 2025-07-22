import java.util.Scanner;

public class KhachHang {
    private String maKH;
    private String hoTen;
    private String soDienThoai;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTen, String soDienThoai) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public void nhapTuBanPhim(Scanner sc) {
        System.out.print("Nhập mã khách hàng: ");
        maKH = sc.nextLine();

        System.out.print("Nhập họ tên khách hàng: ");
        hoTen = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        soDienThoai = sc.nextLine();
    }

    public void hienThi() {
        System.out.println("Mã: " + maKH + " | Tên: " + hoTen + " | SĐT: " + soDienThoai);
    }

    public String getMaKH() {
        return maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
}
