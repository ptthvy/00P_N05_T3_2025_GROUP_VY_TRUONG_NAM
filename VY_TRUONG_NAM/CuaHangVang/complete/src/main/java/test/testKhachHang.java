package com.example.servingwebcontent;

import com.example.servingwebcontent.model.KhachHang;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestKhachHang {

    @Test
    public void testTenKh() {
        System.out.println("=== TEST Tên Khách Hàng ===");

        try {
            // Khởi tạo khách hàng với tên hợp lệ
            KhachHang kh1 = new KhachHang("K001", "Nguyen Van A", 25, "0123456789", "a@gmail.com");
            assertEquals("Nguyen Van A", kh1.getTen(), "Tên khách hàng không đúng");

            // Khởi tạo khách hàng với tên rỗng
            KhachHang kh2 = new KhachHang("K002", "", 30, "0987654321", "b@gmail.com");
            fail("Tên khách hàng không thể rỗng"); // Nếu tên rỗng, thì bài kiểm tra phải thất bại

        } catch (Exception e) {
            System.out.println("Lỗi khi tạo khách hàng: " + e.getMessage());
            fail("Lỗi khi kiểm tra tên khách hàng");
        }

        System.out.println("✓ Tên Khách Hàng OK");
    }

    @Test
    public void testSdt() {
        System.out.println("=== TEST Số Điện Thoại ===");

        try {
            // Khởi tạo khách hàng với số điện thoại hợp lệ
            KhachHang kh1 = new KhachHang("K003", "Nguyen Thi C", 35, "0333456789", "c@a.com");
            assertEquals("0333456789", kh1.getSdt(), "Số điện thoại không đúng");

            // Khởi tạo khách hàng với số điện thoại không hợp lệ (ví dụ: thiếu số)
            KhachHang kh2 = new KhachHang("K004", "Nguyen Thi D", 40, "12345", "d@a.com");
            fail("Số điện thoại không hợp lệ");

        } catch (Exception e) {
            System.out.println("Lỗi khi tạo khách hàng: " + e.getMessage());
            fail("Lỗi khi kiểm tra số điện thoại");
        }

        System.out.println("✓ Số Điện Thoại OK");
    }
}
