import java.util.Scanner;

public class TestQuanLyGiaoDich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        System.out.print("Nhập số lượng giao dịch: ");
        int soGD = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < soGD; i++) {
            System.out.println("--- Nhập giao dịch thứ " + (i + 1));
            GiaoDich gd = new GiaoDich();
            gd.nhapTuBanPhim(sc);
            qlgd.themGiaoDich(gd);
        }

        System.out.println("\n=== Danh sách giao dịch ===");
        qlgd.hienThiTatCa();

        System.out.println("\n=== Tính tổng tiền cho từng giao dịch ===");
        qlgd.tinhVaHienThiTongTien();

        sc.close();
    }
}
