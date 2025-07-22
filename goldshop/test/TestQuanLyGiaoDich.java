

public class TestQuanLyGiaoDich {
    public static void testHienThiGiaoDichTheoNgay() {
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();

        qlgd.themGiaoDich(new GiaoDich("GD01", LocalDate.now(), 2_000_000));
        qlgd.themGiaoDich(new GiaoDich("GD02", LocalDate.now().minusDays(1), 1_500_000));
        qlgd.themGiaoDich(new GiaoDich("GD03", LocalDate.now(), 5_000_000));

        System.out.println("Danh sách giao dịch trong ngày hôm nay:");
        qlgd.hienThiGiaoDichTheoNgay(LocalDate.now());
    }
}
