import java.util.Scanner;

public class TestQuanLyKhachHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyKhachHang qlkh = new QuanLyKhachHang();

        // Thêm khách hàng mẫu
        qlkh.themKhachHang(new KhachHang("KH01", "Nguyễn Văn A", "0912348888"));
        qlkh.themKhachHang(new KhachHang("KH02", "Trần Thị B", "0935679999"));
        qlkh.themKhachHang(new KhachHang("KH03", "Lê Văn C", "0901234567"));

        System.out.println("\n=== Danh sách khách hàng ===");
        qlkh.hienThiTatCa();

        System.out.println("\n=== Danh sách khách hàng VIP ===");
        qlkh.hienThiKhachHangVip();

        // Thử nhập từ bàn phím
        System.out.print("\nBạn có muốn thêm khách hàng mới? (y/n): ");
        String chon = sc.nextLine();

        if (chon.equalsIgnoreCase("y")) {
            System.out.print("Nhập số lượng khách: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("--- Nhập khách hàng thứ " + (i + 1));
                KhachHang kh = new KhachHang();
                kh.nhapTuBanPhim(sc);
                qlkh.themKhachHang(kh);
            }

            System.out.println("\n=== Cập nhật danh sách khách hàng ===");
            qlkh.hienThiTatCa();

            System.out.println("\n=== Cập nhật danh sách VIP ===");
            qlkh.hienThiKhachHangVip();
        }

        sc.close();
    }
}
