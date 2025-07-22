public class KhachHang {
    private String maKH;
    private String hoTen;
    private String soDienThoai;

    public KhachHang(String maKH, String hoTen, String soDienThoai) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
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
