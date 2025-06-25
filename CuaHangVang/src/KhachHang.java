public class KhachHang {
int MaKh;
String TenKh;
String sdt;
public KhachHang(int maKh,String tenKh,String sdt){
this.MaKh = maKh;
this.TenKh = tenKh;
this.sdt = sdt;
}
    public void In(){
        System.out.println("Ma Khach Hang:" + MaKh +"Ten Khach Hang:" + TenKh + "So Dien Thoai" + sdt);
    }
}