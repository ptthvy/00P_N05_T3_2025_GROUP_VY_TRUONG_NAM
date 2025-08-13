-- GoldShop - MySQL 8 / Aiven
SET NAMES utf8mb4;

-- Bảng kiểm tra app
CREATE TABLE IF NOT EXISTS app_health (
  id INT PRIMARY KEY AUTO_INCREMENT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  note VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- KHÁCH HÀNG
CREATE TABLE IF NOT EXISTS khach_hang (
  id INT PRIMARY KEY AUTO_INCREMENT,
  ten VARCHAR(100) NOT NULL,
  sdt VARCHAR(20),
  email VARCHAR(100),
  dia_chi VARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- SẢN PHẨM
CREATE TABLE IF NOT EXISTS san_pham (
  id INT PRIMARY KEY AUTO_INCREMENT,
  ten VARCHAR(120) NOT NULL,
  loai VARCHAR(60),
  gia DECIMAL(15,2) NOT NULL,
  ton_kho INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- HÓA ĐƠN
CREATE TABLE IF NOT EXISTS hoa_don (
  id INT PRIMARY KEY AUTO_INCREMENT,
  khach_hang_id INT NOT NULL,
  ngay DATE NOT NULL,
  tong_tien DECIMAL(15,2) NOT NULL,
  INDEX idx_hd_kh (khach_hang_id),
  CONSTRAINT fk_hd_kh FOREIGN KEY (khach_hang_id)
    REFERENCES khach_hang(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- CHI TIẾT HÓA ĐƠN
CREATE TABLE IF NOT EXISTS chi_tiet_hoa_don (
  id INT PRIMARY KEY AUTO_INCREMENT,
  hoa_don_id INT NOT NULL,
  san_pham_id INT NOT NULL,
  so_luong INT NOT NULL,
  don_gia DECIMAL(15,2) NOT NULL,
  INDEX idx_ct_hd (hoa_don_id),
  INDEX idx_ct_sp (san_pham_id),
  CONSTRAINT fk_ct_hd FOREIGN KEY (hoa_don_id)
    REFERENCES hoa_don(id) ON DELETE CASCADE,
  CONSTRAINT fk_ct_sp FOREIGN KEY (san_pham_id)
    REFERENCES san_pham(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- GIAO DỊCH (thanh toán)
CREATE TABLE IF NOT EXISTS giao_dich (
  id INT PRIMARY KEY AUTO_INCREMENT,
  hoa_don_id INT NOT NULL,
  so_tien DECIMAL(15,2) NOT NULL,
  phuong_thuc VARCHAR(30) NOT NULL,      -- CASH/CARD/BANKING...
  trang_thai VARCHAR(20) NOT NULL DEFAULT 'PENDING', -- PENDING/PAID/FAILED
  thoi_gian TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  INDEX idx_gd_hd (hoa_don_id),
  CONSTRAINT fk_gd_hd FOREIGN KEY (hoa_don_id)
    REFERENCES hoa_don(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

