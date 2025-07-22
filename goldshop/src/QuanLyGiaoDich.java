import java.util.ArrayList;

public class QuanLyGiaoDich {
    private ArrayList<GiaoDich> danhSachGD = new ArrayList<>();

    public void themGiaoDich(GiaoDich gd) {
        danhSachGD.add(gd);
    }

    public void hienThiTatCa() {
        for (GiaoDich gd : danhSachGD) {
            gd.hienThi();
        }
    }

    public void tinhVaHienThiTongTien() {
        double tong = 0;
        for (GiaoDich gd : danhSachGD) {
            double tien = gd.tinhThanhTien();
            System.out.println("Giao dịch " + gd.getMaGD() + ": " + tien + " VND");
            tong += tien;
        }
        System.out.println(">>> Tổng tiền tất cả giao dịch: " + tong + " VND");
    }
}
