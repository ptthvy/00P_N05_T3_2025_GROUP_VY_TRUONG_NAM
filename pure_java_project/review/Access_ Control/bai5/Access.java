
public class Access {
    public int congKhai = 1;               // public
    private int riengTu = 2;               // private
    protected int baoVe = 3;               // protected
    int macDinh = 4;                       // mặc định (default)

    public void hamCongKhai() {
        System.out.println("Hàm công khai");
    }

    private void hamRiengTu() {
        System.out.println("Hàm riêng tư");
    }

    protected void hamBaoVe() {
        System.out.println("Hàm bảo vệ");
    }

    void hamMacDinh() {
        System.out.println("Hàm mặc định");
    }
}
