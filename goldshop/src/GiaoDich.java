import java.time.LocalDate;

public class GiaoDich {
    private String maGD;
    private LocalDate ngayGiaoDich;
    private double tongTien;

    public GiaoDich(String maGD, LocalDate ngayGiaoDich, double tongTien) {
        this.maGD = maGD;
        this.ngayGiaoDich = ngayGiaoDich;
        this.tongTien = tongTien;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void hienThiThongTin() {
        System.out.println("Mã GD: " + maGD + " | Ngày: " + ngayGiaoDich + " | Tổng tiền: " + tongTien);
    }
}
