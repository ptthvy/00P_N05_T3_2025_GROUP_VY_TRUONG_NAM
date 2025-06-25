package src;
public class SanPham {
    int MaSp;
    String TenSp;
    int GiaSp;
    public SanPham(int MaSp,String TenSp,int GiaSp){
        this.MaSp = maSp;
        this.TenSp = tenSp;
        this.GiaSp = giaSp;
    }
    public void In(){
        System.out.println(" In San Pham " );
        System.out.println("Ma San Pham:"+ MaSp+"Ten San Pham"+ TenSp+"Gia San Pham"+GiaSp);
    }
}
