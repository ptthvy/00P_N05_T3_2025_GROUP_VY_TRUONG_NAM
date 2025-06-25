public class GiaoDich {
    String ngayGiaoDich;
    String thoigian;
    String tongtien;
    public GiaoDich(String ngd,String th, String tt){
        this.ngayGiaoDich = ngd;
        this.thoigian = th;
        this.tongtien = tt;
    }
    public void In(){
        System.out.println("Ngay Giao Dich:"+ ngayGiaoDich);
    }
}
