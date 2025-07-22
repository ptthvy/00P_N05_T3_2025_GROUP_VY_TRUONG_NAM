import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class QuanLyGiaoDichTest {

    public void testHienThiGiaoDichTheoNgay() {
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();

        qlgd.themGiaoDich(new GiaoDich("GD01", LocalDate.now(), 2_000_000));
        qlgd.themGiaoDich(new GiaoDich("GD02", LocalDate.now().minusDays(1), 1_000_000));
        qlgd.themGiaoDich(new GiaoDich("GD03", LocalDate.now(), 5_000_000));

        qlgd.hienThiGiaoDichTheoNgay(LocalDate.now());  // In ra GD01 và GD03
    }
}
