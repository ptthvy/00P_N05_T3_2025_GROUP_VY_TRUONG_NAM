
public class TestAccess {
    public static void main(String[] args) {
        Access obj = new Access();
        System.out.println("Công khai: " + obj.congKhai);
        obj.hamCongKhai();
        System.out.println("Bảo vệ: " + obj.baoVe);
        obj.hamBaoVe();
        System.out.println("Mặc định: " + obj.macDinh);
        obj.hamMacDinh();
    }
}

