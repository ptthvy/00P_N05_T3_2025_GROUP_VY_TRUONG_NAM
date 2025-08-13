-- GoldShop seed data (demo)
SET NAMES utf8mb4;

-- DỌN BẢNG (chỉ dùng khi demo)
SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE chi_tiet_hoa_don;
TRUNCATE TABLE giao_dich;
TRUNCATE TABLE hoa_don;
TRUNCATE TABLE san_pham;
TRUNCATE TABLE khach_hang;
TRUNCATE TABLE app_health;
SET FOREIGN_KEY_CHECKS=1;

-- Kiểm tra app
INSERT INTO app_health(note) VALUES ('ok from Spring Boot via Aiven');

-- KHÁCH HÀNG
INSERT INTO khach_hang (id, ten, sdt, email, dia_chi) VALUES
(1, 'Nguyễn Văn A', '0901234567', 'a@example.com', 'Hà Nội'),
(2, 'Trần Thị B',   '0912345678', 'b@example.com', 'Đà Nẵng'),
(3, 'Lê Văn C',     '0923456789', 'c@example.com', 'TP.HCM');

-- SẢN PHẨM
INSERT INTO san_pham (id, ten, loai, gia, ton_kho) VALUES
(1, 'Nhẫn vàng 18K',     'Trang sức', 2500000.00, 50),
(2, 'Dây chuyền bạc',    'Trang sức',  800000.00, 200),
(3, 'Lắc tay vàng',      'Trang sức', 3200000.00, 30),
(4, 'Bông tai ngọc trai','Trang sức', 1500000.00, 80),
(5, 'Nhẫn bạc',          'Trang sức',  300000.00, 100);

-- HÓA ĐƠN (tổng tiền khớp chi tiết ở dưới)
INSERT INTO hoa_don (id, khach_hang_id, ngay, tong_tien) VALUES
(1, 1, '2025-08-15', 4100000.00),
(2, 2, '2025-08-15', 4100000.00);

-- CHI TIẾT HÓA ĐƠN
-- HD#1: 1x Nhẫn vàng 18K + 2x Dây chuyền bạc = 4.100.000
INSERT INTO chi_tiet_hoa_don (hoa_don_id, san_pham_id, so_luong, don_gia) VALUES
(1, 1, 1, 2500000.00),
(1, 2, 2,  800000.00);

-- HD#2: 1x Lắc tay vàng + 3x Nhẫn bạc = 4.100.000
INSERT INTO chi_tiet_hoa_don (hoa_don_id, san_pham_id, so_luong, don_gia) VALUES
(2, 3, 1, 3200000.00),
(2, 5, 3,  300000.00);

-- GIAO DỊCH
INSERT INTO giao_dich (hoa_don_id, so_tien, phuong_thuc, trang_thai) VALUES
(1, 4100000.00, 'BANKING', 'PAID'),
(2, 4100000.00, 'CASH',    'PAID');
