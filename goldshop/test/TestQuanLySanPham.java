import org.junit.jupiter.api.Test;

import java.util.List;

public class QuanLySanPhamTest {

    public void testTimKiemSanPhamTheoTen() {
        QuanLySanPham qlsp = new QuanLySanPham();

        qlsp.themSanPham(new SanPham("SP01", "Chuột Logitech", 500_000));
        qlsp.themSanPham(new SanPham("SP02", "Bàn phím Cơ", 1_200_000));
        qlsp.themSanPham(new SanPham("SP03", "Chuột Gaming", 700_000));

        List<SanPham> ketQua = qlsp.timKiemSanPhamTheoTen("chuột");

        for (SanPham sp : ketQua) {
            sp.hienThiThongTin();  
        }
    }
}
