import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLyGiaoDich {
    private ArrayList<GiaoDich> danhSachGD = new ArrayList<>();

    public void themGiaoDich(GiaoDich gd) {
        danhSachGD.add(gd);
    }

    public void hienThiGiaoDichTheoNgay(LocalDate ngay) {
        System.out.println("Giao dịch ngày " + ngay + ":");
        for (GiaoDich gd : danhSachGD) {
            if (gd.getNgayGiaoDich().equals(ngay)) {
                gd.hienThiThongTin();
            }
        }
    }
}
