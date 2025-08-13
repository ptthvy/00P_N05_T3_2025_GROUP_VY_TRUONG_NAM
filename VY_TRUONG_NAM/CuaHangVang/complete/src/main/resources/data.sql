-- Seed data matching GreetingController
SET NAMES utf8mb4;

-- Clean existing
SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE chi_tiet_hoa_don;
TRUNCATE TABLE giao_dich;
TRUNCATE TABLE hoa_don;
TRUNCATE TABLE san_pham;
TRUNCATE TABLE khach_hang;
SET FOREIGN_KEY_CHECKS=1;

-- Customers (KhachHang)
INSERT INTO khach_hang (ten, sdt, email, dia_chi) VALUES
('Nguyễn Văn A', '0909123456', NULL, NULL),
('Trần Thị B',   '0912345678', NULL, NULL);

-- Products (SanPham)
INSERT INTO san_pham (ten, loai, gia, ton_kho) VALUES
('Nhẫn vàng 24K',     'VANG', 80000000.00, 100),
('Dây chuyền vàng Ý', 'VANG', 950000000.00, 50),
('Vòng Kiềng',        'VANG', 400000000.00, 30),
('Lắc tay vàng',      'VANG', 120000000.00, 40);

-- One invoice for customer A: 2 x 'Nhẫn vàng 24K'
INSERT INTO hoa_don (khach_hang_id, ngay, tong_tien) VALUES
(1, CURDATE(), 2 * 80000000.00);

-- Invoice details
INSERT INTO chi_tiet_hoa_don (hoa_don_id, san_pham_id, so_luong, don_gia) VALUES
(1, 1, 2, 80000000.00);

-- Payment for the invoice
INSERT INTO giao_dich (hoa_don_id, so_tien, phuong_thuc, trang_thai) VALUES
(1, 160000000.00, 'CASH', 'PAID');
