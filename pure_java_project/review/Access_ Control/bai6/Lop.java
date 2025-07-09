public class Lop {
    protected String tenLop = "12A1";
    protected int siSo = 40;

    protected void HienThiThongTin() {
        System.out.println("Tên lớp: " + tenLop);
        System.out.println("Sĩ số: " + siSo);
    }
}
class TestLop {
    public static void main(String[] args) {
        Lop lop = new Lop();

        // Truy cập biến //
        System.out.println("Tên lớp: " + lop.tenLop);
        System.out.println("Sĩ số: " + lop.siSo);

        // Gọi phương thức//
        lop.HienThiThongTin();
    }
}
