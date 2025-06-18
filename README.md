# 00P_N05_T3_2025_GROUP_VY_TRUONG_NAM
ứng dụng quản lí cửa hàng 
đối tượng:
+ sản phẩm
+ khách hàng
+ hóa đơn mua bán
+ Mỗi đối tượng sẽ có kiểu là Class tương ứng
+ class SanPham
- MaSP: mã sản phẩm (duy nhất)
- TenSP: tên sản phẩm
- SoLuong: số lượng còn trong kho
- NhaSX: nhà sản xuất
- GiaTien: đơn giá sản phẩm
  + Phương thức:
- ThongKeSoLuong(): trả về số lượng còn
- HienThi(): in thông tin sản phẩm
- CapNhatSoLuong(moi): cập nhật số lượng sau khi bán
+ class KhachHang
- MaKH: mã khách hàng
- TenKH: tên khách hàng
- DiaChi: địa chỉ
- SoDienThoai: số điện thoại
 + Phương thức:
- HienThi(): hiển thị thông tin khách hàng
+ class HoaDon
- MaHD: mã hóa đơn
- KhachHang: đối tượng khách hàng
- DanhSachSanPham: danh sách sản phẩm được mua (kèm số lượng)
- TongTien: tổng tiền phải trả
+ Phương thức:
- TinhTongTien(): tính tổng giá trị hóa đơn
- HienThiHoaDon(): in chi tiết hóa đơn
+ class CuaHang
- DanhSachSanPham: danh sách sản phẩm đang bán
- DanhSachKhachHang: danh sách khách hàng
- DanhSachHoaDon: danh sách hóa đơn
- ThemSanPham(),
- TimSanPham()
- ThemKhachHang(),
- TimKhachHang()
- TaoHoaDon()
- ThongKeTatCaSanPham()
- HienThiTatCaHoaDon()
