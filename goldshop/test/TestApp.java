import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("=== CHẠY DỮ LIỆU ===");

        KhachHangManager khManager = new KhachHangManager();
        SanPhamManager spManager = new SanPhamManager();
        GiaoDichManager gdManager = new GiaoDichManager();

        // Thêm dữ liệu mẫu
        khManager.themKhachHang(new KhachHang("KH01", "Lan"));
        spManager.themSanPham(new SanPham("SP01", "Vàng 9999"));
        gdManager.themGiaoDich(new GiaoDich("GD01", "KH01", "SP01"));

        System.out.println(">>> Dữ liệu mẫu đã tạo. Bắt đầu menu:");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ CỬA HÀNG VÀNG =====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Thêm sản phẩm");
            System.out.println("6. Hiển thị sản phẩm");
            System.out.println("7. Sửa sản phẩm");
            System.out.println("8. Xóa sản phẩm");
            System.out.println("9. Thêm giao dịch");
            System.out.println("10. Hiển thị giao dịch");
            System.out.println("11. Sửa giao dịch");
            System.out.println("12. Xóa giao dịch");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("ID KH: ");
                    String idKH = sc.nextLine();
                    System.out.print("Tên KH: ");
                    String tenKH = sc.nextLine();
                    khManager.themKhachHang(new KhachHang(idKH, tenKH));
                    break;
                case 2:
                    khManager.hienThiKhachHang();
                    break;
                case 3:
                    System.out.print("ID KH cần sửa: ");
                    String suaKH = sc.nextLine();
                    System.out.print("Tên mới: ");
                    String tenMoiKH = sc.nextLine();
                    khManager.suaKhachHang(suaKH, tenMoiKH);
                    break;
                case 4:
                    System.out.print("ID KH cần xóa: ");
                    String xoaKH = sc.nextLine();
                    khManager.xoaKhachHang(xoaKH);
                    break;
                case 5:
                    System.out.print("ID SP: ");
                    String idSP = sc.nextLine();
                    System.out.print("Tên SP: ");
                    String tenSP = sc.nextLine();
                    spManager.themSanPham(new SanPham(idSP, tenSP));
                    break;
                case 6:
                    spManager.hienThiSanPham();
                    break;
                case 7:
                    System.out.print("ID SP cần sửa: ");
                    String suaSP = sc.nextLine();
                    System.out.print("Tên mới: ");
                    String tenMoiSP = sc.nextLine();
                    spManager.suaSanPham(suaSP, tenMoiSP);
                    break;
                case 8:
                    System.out.print("ID SP cần xóa: ");
                    String xoaSP = sc.nextLine();
                    spManager.xoaSanPham(xoaSP);
                    break;
                case 9:
                    System.out.print("ID GD: ");
                    String idGD = sc.nextLine();
                    System.out.print("ID KH: ");
                    String idKHGd = sc.nextLine();
                    System.out.print("ID SP: ");
                    String idSPGd = sc.nextLine();
                    gdManager.themGiaoDich(new GiaoDich(idGD, idKHGd, idSPGd));
                    break;
                case 10:
                    gdManager.hienThiGiaoDich();
                    break;
                case 11:
                    System.out.print("ID GD cần sửa: ");
                    String suaGD = sc.nextLine();
                    System.out.print("ID KH mới: ");
                    String khMoi = sc.nextLine();
                    System.out.print("ID SP mới: ");
                    String spMoi = sc.nextLine();
                    gdManager.suaGiaoDich(suaGD, khMoi, spMoi);
                    break;
                case 12:
                    System.out.print("ID GD cần xóa: ");
                    String xoaGD = sc.nextLine();
                    gdManager.xoaGiaoDich(xoaGD);
                    break;
                case 0:
                    System.out.println("Thoát.");
                    sc.close();
                    return;
                default:
                    System.out.println("Chọn sai, thử lại.");
            }
        }
    }
}

