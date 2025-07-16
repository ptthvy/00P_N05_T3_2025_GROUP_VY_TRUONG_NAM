public class TestApp {
    public static void main(String[] args) {
        System.out.println("===== TEST KHACH HANG =====");
        KhachHangManager kh = new KhachHangManager();
        kh.themKhachHang(new KhachHang("KH01", "Lan"));
        kh.themKhachHang(new KhachHang("KH02", "Minh"));
        kh.hienThiKhachHang();
        kh.suaKhachHang("KH01", "Lan Updated");
        kh.xoaKhachHang("KH02");
        kh.hienThiKhachHang();

        System.out.println("\n===== TEST SAN PHAM =====");
        SanPhamManager sp = new SanPhamManager();
        sp.themSanPham(new SanPham("SP01", "Vang 9999"));
        sp.themSanPham(new SanPham("SP02", "Vang Tay"));
        sp.hienThiSanPham();
        sp.suaSanPham("SP02", "Vang Tay Loai 1");
        sp.xoaSanPham("SP01");
        sp.hienThiSanPham();

        System.out.println("\n===== TEST GIAO DICH =====");
        GiaoDichManager gd = new GiaoDichManager();
        gd.themGiaoDich(new GiaoDich("GD01", "KH01", "SP02"));
        gd.hienThiGiaoDich();
        gd.suaGiaoDich("GD01", "KH01", "SP02");
        gd.xoaGiaoDich("GD01");
        gd.hienThiGiaoDich();
    }
}
