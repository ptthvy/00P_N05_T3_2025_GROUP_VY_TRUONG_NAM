import java.util.Scanner;

public class TestQuanLySanPham {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySanPham qlsp = new QuanLySanPham();
        qlsp.themSanPham(new SanPham("SP01", "Nhẫn Vàng", 5000000));
        qlsp.themSanPham(new SanPham("SP02", "Vang 999", 3500000));
        qlsp.themSanPham(new SanPham("SP03", "Vang 666", 7000000));

        System.out.println("\n=== Danh sách sản phẩm hiện có ===");
        qlsp.hienThiTatCa();
        System.out.print("\nBạn có muốn thêm sản phẩm mới không? (y/n): ");
        String chon = sc.nextLine();
        if (chon.equalsIgnoreCase("y")) {
            System.out.print("Nhập số lượng sản phẩm: ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println("--- Nhập sản phẩm thứ " + (i + 1));
                SanPham sp = new SanPham();
                sp.nhapTuBanPhim(sc);
                qlsp.themSanPham(sp);
            }

            System.out.println("\n=== Danh sách sản phẩm sau khi thêm ===");
            qlsp.hienThiTatCa();
        }

        // Tìm kiếm sản phẩm theo mã hoặc tên
        System.out.print("\nNhập từ khóa để tìm kiếm sản phẩm: ");
        String tuKhoa = sc.nextLine();
        qlsp.timKiemSanPham(tuKhoa);

        sc.close();
    }
}
