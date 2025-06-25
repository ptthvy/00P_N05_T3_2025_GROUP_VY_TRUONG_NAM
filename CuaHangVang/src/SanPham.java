
public class SanPham {
    int MaSp;
    String TenSp;
    int GiaSp;
    public SanPham(int maSp,String tenSp,int giaSp){
        this.MaSp = maSp;
        this.TenSp = tenSp;
        this.GiaSp = giaSp;
    }
    public void In(){
        System.out.println(" In San Pham " );
        System.out.println("Ma San Pham:"+ MaSp+"Ten San Pham"+ TenSp+"Gia San Pham"+GiaSp);
    }
}
