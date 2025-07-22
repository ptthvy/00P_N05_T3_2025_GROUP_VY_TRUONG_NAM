import java.util.List;

public class TestQuanLySanPham {
    public static void testTimKiemSanPhamTheoTen() {
        QuanLySanPham qlsp = new QuanLySanPham();

        qlsp.themSanPham(new SanPham("SP01", "  Vang 9999", 500_000));
        qlsp.themSanPham(new SanPham("SP02", "vang 666", 1_200_000));
        qlsp.themSanPham(new SanPham("SP03", "Vang tây", 700_000));

        List<SanPham> ketQua = qlsp.timKiemSanPhamTheoTen("vang");
        System.out.println("Kết quả tìm kiếm sản phẩm theo tên 'vang':");
        for (SanPham sp : ketQua) {
            sp.hienThi();
        }
    }
}
