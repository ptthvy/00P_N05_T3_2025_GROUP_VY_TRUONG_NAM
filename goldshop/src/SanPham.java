public class SanPham {
    private String maSP;
    private String tenSanPham;
    private double gia;

    public SanPham(String maSP, String tenSanPham, double gia) {
        this.maSP = maSP;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public void hienThiThongTin() {
        System.out.println("Mã: " + maSP + " | Tên: " + tenSanPham + " | Giá: " + gia);
    }
}
