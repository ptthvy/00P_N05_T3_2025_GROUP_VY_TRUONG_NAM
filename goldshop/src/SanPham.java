public class SanPham {
    private String id;
    private String ten;

    public SanPham(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public String getId() { return id; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
}
