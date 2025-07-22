import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySanPham {
    private ArrayList<SanPham> danhSachSP = new ArrayList<>();

    public void themSanPham(SanPham sp) {
        danhSachSP.add(sp);
    }

    public List<SanPham> timKiemSanPhamTheoTen(String keyword) {
        return danhSachSP.stream()
                .filter(sp -> sp.getTenSanPham().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
