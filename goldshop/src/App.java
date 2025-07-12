public class App {
    public static void main(String[] args) {
      KhachHang.them(new KhachHang("KH01", "Nguyen A", "0123456789"));
        KhachHang.sua("KH01", "Nguyen Van A", "0999999999");
        KhachHang.xoa("KH02"); // không tồn tại
        System.out.println("=== DANH SÁCH KHÁCH HÀNG ===");
        KhachHang.hienThiTatCa();

        SanPham.them(new SanPham("SP01", "Vàng 9999", 5000000));
        SanPham.sua("SP01", "Vàng SJC", 5200000);
        SanPham.xoa("SP02"); // không tồn tại
        System.out.println("\n=== DANH SÁCH SẢN PHẨM ===");
        SanPham.hienThiTatCa();

        GiaoDich.them(new GiaoDich("GD01", "Nguyen Van A", "SP01", 10400000));
        GiaoDich.sua("GD01", "Nguyen Van A", "SP01", 10500000);
        GiaoDich.xoa("GD02"); 
        System.out.println("\n=== DANH SÁCH GIAO DỊCH ===");
        GiaoDich.hienThiTatCa();
    }
}


