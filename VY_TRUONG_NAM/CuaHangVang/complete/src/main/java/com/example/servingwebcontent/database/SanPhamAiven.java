package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class SanPhamAiven {

    @Autowired
    private myDBConnection mydb;

    // Tạo bảng nếu chưa tồn tại
    private void createTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS sanpham (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "ten VARCHAR(100) NOT NULL," +
                "gia DOUBLE," +
                "soluong INT)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả sản phẩm
    public List<SanPham> getAllSanPham() {
        List<SanPham> list = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM sanpham ORDER BY id DESC";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    SanPham sp = new SanPham(
                            rs.getInt("id"),
                            rs.getString("ten"),
                            rs.getDouble("gia"),
                            rs.getInt("soluong")
                    );
                    list.add(sp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm sản phẩm mới
    public void addSanPham(SanPham sp) {
        String sql = "INSERT INTO sanpham (ten, gia, soluong) VALUES (?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getGia());
            pstmt.setInt(3, sp.getSoLuong());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật sản phẩm
    public void updateSanPham(SanPham sp) {
        String sql = "UPDATE sanpham SET ten=?, gia=?, soluong=? WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getGia());
            pstmt.setInt(3, sp.getSoLuong());
            pstmt.setInt(4, (int) sp.getGia()); // Sử dụng ID từ đối tượng SanPham

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm
    public void deleteSanPham(double lastId) {
        String sql = "DELETE FROM sanpham WHERE id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, (int) lastId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Menu chính và các thao tác CRUD
    private static Scanner sc = new Scanner(System.in);
    private static SanPhamAiven dao = new SanPhamAiven();

    private static void hienThiMenu() {
        System.out.println("Chọn một trong các thao tác sau:");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Thoát");
    }

    // Thêm sản phẩm
    private static void themSanPham() {
        System.out.print("Nhập tên sản phẩm: ");
        String ten = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng sản phẩm: ");
        int soluong = Integer.parseInt(sc.nextLine());

        SanPham sp = new SanPham(ten, gia, soluong);
        dao.addSanPham(sp);
        System.out.println("Thêm sản phẩm thành công.");
    }

    // Hiển thị danh sách sản phẩm
    private static void hienThiDanhSach() {
        List<SanPham> danhSach = dao.getAllSanPham();
        System.out.println("Danh sách sản phẩm:");
        for (SanPham sp : danhSach) {
            System.out.println(sp);
        }
    }

    // Cập nhật sản phẩm
    private static void capNhatSanPham() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());

        // Kiểm tra nếu sản phẩm tồn tại
        if (dao.getAllSanPham().stream().noneMatch(sp -> sp.getGia() == id)) {
            System.out.println("Sản phẩm không tồn tại.");
            return;
        }

        System.out.print("Nhập tên sản phẩm mới: ");
        String ten = sc.nextLine();
        System.out.print("Nhập giá mới: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng mới: ");
        int soluong = Integer.parseInt(sc.nextLine());

        SanPham sp = new SanPham(id, ten, gia, soluong);
        dao.updateSanPham(sp);
        System.out.println("Cập nhật sản phẩm thành công.");
    }

    // Xóa sản phẩm
    private static void xoaSanPham() {
        try {
            System.out.print("Nhập ID sản phẩm cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            dao.deleteSanPham(id);
            System.out.println("Xóa sản phẩm thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
        }
    }

    // Chương trình chính
    public static void main(String[] args) {
        do {
            hienThiMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    themSanPham();
                    break;
                case 2:                 
                    hienThiDanhSach();
                    break;
                case 3:
                    capNhatSanPham();
                    break;
                case 4:
                    xoaSanPham();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:            
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (true);
    }
}
