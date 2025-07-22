import org.junit.jupiter.api.Test;

public class QuanLyKhachHangTest {

    public void testHienThiKhachHangVip() {
        QuanLyKhachHang qlkh = new QuanLyKhachHang();

        KhachHang kh1 = new KhachHang("KH01", "Nguyễn Văn A", "0912348888");
        KhachHang kh2 = new KhachHang("KH02", "Trần Thị B", "0905123456");
        KhachHang kh3 = new KhachHang("KH03", "Lê Văn C", "0933399999");

        qlkh.themKhachHang(kh1);
        qlkh.themKhachHang(kh2);
        qlkh.themKhachHang(kh3);

        qlkh.hienThiKhachHangVip();  // In ra KH01 và KH03
    }
}
