public class GiaoDich {
    private String id;
    private String khachHangId;
    private String sanPhamId;

    public GiaoDich(String id, String khachHangId, String sanPhamId) {
        this.id = id;
        this.khachHangId = khachHangId;
        this.sanPhamId = sanPhamId;
    }
    public String getId() { return id; }
    public String getKhachHangId() { return khachHangId; }
    public String getSanPhamId() { return sanPhamId; }

    public void setKhachHangId(String khachHangId) { this.khachHangId = khachHangId; }
    public void setSanPhamId(String sanPhamId) { this.sanPhamId = sanPhamId; }
}
