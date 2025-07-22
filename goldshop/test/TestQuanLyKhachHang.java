public class TestQuanLyKhachHang {
    public static void testHienThiKhachHangVip() {
        QuanLyKhachHang qlkh = new QuanLyKhachHang();

        KhachHang kh1 = new KhachHang("KH01", "Nguyễn Văn A", "0912345678"); // VIP
        KhachHang kh2 = new KhachHang("KH02", "Trần Thị B", "0905123456");   // VIP
        KhachHang kh3 = new KhachHang("KH03", "Lê Văn C", "0333999999");     // Không VIP

        qlkh.themKhachHang(kh1);
        qlkh.themKhachHang(kh2);
        qlkh.themKhachHang(kh3);

        System.out.println("Danh sách khách hàng VIP:");
        qlkh.hienThiKhachHangVip();
    }
}
