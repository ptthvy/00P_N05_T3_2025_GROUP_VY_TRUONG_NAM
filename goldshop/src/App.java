import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KhachHangManager khManager = new KhachHangManager();
        SanPhamManager spManager = new SanPhamManager();
        GiaoDichManager gdManager = new GiaoDichManager();

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ CỬA HÀNG VÀNG =====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Thêm sản phẩm");
            System.out.println("6. Hiển thị danh sách sản phẩm");
            System.out.println("7. Sửa sản phẩm");
            System.out.println("8. Xóa sản phẩm");
            System.out.println("9. Thêm giao dịch");
            System.out.println("10. Hiển thị danh sách giao dịch");
            System.out.println("11. Sửa giao dịch");
            System.out.println("12. Xóa giao dịch");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int chon = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (chon) {
                case 1:
                    System.out.print("Nhập ID khách hàng: ");
                    String idKH = sc.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String tenKH = sc.nextLine();
                    khManager.themKhachHang(new KhachHang(idKH, tenKH));
                    break;
                case 2:
                    khManager.hienThiKhachHang();
                    break;
                case 3:
                    System.out.print("Nhập ID khách hàng cần sửa: ");
                    String idSuaKH = sc.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String tenMoiKH = sc.nextLine();
                    khManager.suaKhachHang(idSuaKH, tenMoiKH);
                    break;
                case 4:
                    System.out.print("Nhập ID khách hàng cần xóa: ");
                    String idXoaKH = sc.nextLine();
                    khManager.xoaKhachHang(idXoaKH);
                    break;
                case 5:
                    System.out.print("Nhập ID sản phẩm: ");
                    String idSP = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String tenSP = sc.nextLine();
                    spManager.themSanPham(new SanPham(idSP, tenSP));
                    break;
                case 6:
                    spManager.hienThiSanPham();
                    break;
                case 7:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    String idSuaSP = sc.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String tenMoiSP = sc.nextLine();
                    spManager.suaSanPham(idSuaSP, tenMoiSP);
                    break;
                case 8:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String idXoaSP = sc.nextLine();
                    spManager.xoaSanPham(idXoaSP);
                    break;
                case 9:
                    System.out.print("Nhập ID giao dịch: ");
                    String idGD = sc.nextLine();
                    System.out.print("Nhập ID khách hàng: ");
                    String khachGD = sc.nextLine();
                    System.out.print("Nhập ID sản phẩm: ");
                    String sanPhamGD = sc.nextLine();
                    gdManager.themGiaoDich(new GiaoDich(idGD, khachGD, sanPhamGD));
                    break;
                case 10:
                    gdManager.hienThiGiaoDich();
                    break;
                case 11:
                    System.out.print("Nhập ID giao dịch cần sửa: ");
                    String idSuaGD = sc.nextLine();
                    System.out.print("Nhập ID khách hàng mới: ");
                    String khMoi = sc.nextLine();
                    System.out.print("Nhập ID sản phẩm mới: ");
                    String spMoi = sc.nextLine();
                    gdManager.suaGiaoDich(idSuaGD, khMoi, spMoi);
                    break;
                case 12:
                    System.out.print("Nhập ID giao dịch cần xóa: ");
                    String idXoaGD = sc.nextLine();
                    gdManager.xoaGiaoDich(idXoaGD);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
