-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 07, 2026 at 11:41 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `argoport_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_pengguna` varchar(10) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `wilayah` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_pengguna`, `nip`, `wilayah`) VALUES
('U001', '198501012010011001', 'Balikpapan'),
('U002', '198803052012022002', 'Samarinda'),
('U003', '199002102014031003', 'Bontang'),
('U004', '199105152015012004', 'Tanah Grogot'),
('U005', '198707202011011005', 'Berau');

-- --------------------------------------------------------

--
-- Table structure for table `dermaga`
--

CREATE TABLE `dermaga` (
  `id_dermaga` varchar(10) NOT NULL,
  `nama_dermaga` varchar(50) NOT NULL,
  `status_dermaga` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dermaga`
--

INSERT INTO `dermaga` (`id_dermaga`, `nama_dermaga`, `status_dermaga`) VALUES
('A06', 'Dermaga Mahakam I', 'Tersedia'),
('A07', 'Dermaga Mahakam II', 'Sibuk'),
('A08', 'Dermaga Palaran', 'Perbaikan'),
('A09', 'Dermaga Ulu', 'Tersedia'),
('A10', 'Dermaga Ilir', 'Tersedia'),
('G11', 'Dermaga Lok Tuan I', 'Tersedia'),
('G12', 'Dermaga Lok Tuan II', 'Sibuk'),
('G13', 'Dermaga Pupuk Kaltim I', 'Tersedia'),
('G14', 'Dermaga Pupuk Kaltim II', 'Perbaikan'),
('G15', 'Dermaga Tanjung Laut', 'Tersedia'),
('N01', 'Dermaga Semayang I', 'Tersedia'),
('N02', 'Dermaga Semayang II', 'Sibuk'),
('N03', 'Dermaga Kariangau I', 'Tersedia'),
('N04', 'Dermaga Kariangau II', 'Tersedia'),
('N05', 'Dermaga Petikemas', 'Tersedia'),
('T15', 'Dermaga Tanah Grogot I', 'Tersedia'),
('T16', 'Dermaga Tanah Grogot II', 'Tersedia'),
('T17', 'Dermaga Lolo', 'Sibuk'),
('T18', 'Dermaga Paser Belengkong', 'Tersedia'),
('U20', 'Dermaga Tanjung Redeb I', 'Tersedia'),
('U21', 'Dermaga Tanjung Redeb II', 'Sibuk'),
('U22', 'Dermaga Sambaliung', 'Tersedia'),
('U23', 'Dermaga Teluk Bayur', 'Tersedia'),
('U24', 'Dermaga Segah', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_sandar`
--

CREATE TABLE `jadwal_sandar` (
  `id_jadwal` varchar(10) NOT NULL,
  `waktu_sandar` datetime NOT NULL,
  `waktu_lepas` datetime NOT NULL,
  `Kapal_id_kapal` varchar(10) NOT NULL,
  `Dermaga_id_dermaga` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jadwal_sandar`
--

INSERT INTO `jadwal_sandar` (`id_jadwal`, `waktu_sandar`, `waktu_lepas`, `Kapal_id_kapal`, `Dermaga_id_dermaga`) VALUES
('JS01', '2026-10-25 09:00:00', '2026-10-26 15:00:00', 'K001', 'A06'),
('JS02', '2026-10-26 12:30:00', '2026-10-27 10:00:00', 'K003', 'A07'),
('JS03', '2026-10-27 07:00:00', '2026-10-27 18:00:00', 'K005', 'A08'),
('JS04', '2026-10-27 08:30:00', '2026-10-28 12:00:00', 'K006', 'A09'),
('JS05', '2026-10-27 12:00:00', '2026-10-28 20:00:00', 'K008', 'A10'),
('JS06', '2026-10-28 07:30:00', '2026-10-29 10:00:00', 'K010', 'G11'),
('JS07', '2026-10-28 11:00:00', '2026-10-29 14:00:00', 'K012', 'G12'),
('JS08', '2026-10-29 06:30:00', '2026-10-30 08:00:00', 'K014', 'G13'),
('JS09', '2026-10-29 09:00:00', '2026-10-30 15:00:00', 'K015', 'G14'),
('JS10', '2026-10-30 08:00:00', '2026-10-31 12:00:00', 'K002', 'G15'),
('JS11', '2026-10-30 10:00:00', '2026-10-31 16:00:00', 'K004', 'N01'),
('JS12', '2026-10-31 07:00:00', '2026-11-01 10:00:00', 'K007', 'N02'),
('JS13', '2026-10-31 13:00:00', '2026-11-01 22:00:00', 'K009', 'N03'),
('JS14', '2026-11-01 06:00:00', '2026-11-02 12:00:00', 'K011', 'N04'),
('JS15', '2026-11-01 09:30:00', '2026-11-02 18:00:00', 'K013', 'N05'),
('JS16', '2026-11-02 07:00:00', '2026-11-03 14:00:00', 'K016', 'T15'),
('JS17', '2026-11-02 09:00:00', '2026-11-03 16:00:00', 'K017', 'T16'),
('JS18', '2026-11-03 08:00:00', '2026-11-04 12:00:00', 'K018', 'T17'),
('JS19', '2026-11-03 10:00:00', '2026-11-04 18:00:00', 'K019', 'T18'),
('JS20', '2026-11-04 06:30:00', '2026-11-05 10:00:00', 'K020', 'U20'),
('JS21', '2026-11-04 08:30:00', '2026-11-05 15:00:00', 'K021', 'U21'),
('JS22', '2026-11-05 07:00:00', '2026-11-06 12:00:00', 'K022', 'U22'),
('JS23', '2026-11-05 10:00:00', '2026-11-06 20:00:00', 'K023', 'U23'),
('JS24', '2026-11-06 08:00:00', '2026-11-07 14:00:00', 'K024', 'U24');

-- --------------------------------------------------------

--
-- Table structure for table `kapal`
--

CREATE TABLE `kapal` (
  `id_kapal` varchar(10) NOT NULL,
  `nama_kapal` varchar(50) NOT NULL,
  `jenis_kapal` varchar(30) NOT NULL,
  `gross_tonnage` decimal(10,2) NOT NULL,
  `draf_kapal` decimal(5,2) NOT NULL,
  `status_kapal` varchar(30) NOT NULL,
  `waktu_kedatangan` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kapal`
--

INSERT INTO `kapal` (`id_kapal`, `nama_kapal`, `jenis_kapal`, `gross_tonnage`, `draf_kapal`, `status_kapal`, `waktu_kedatangan`) VALUES
('K001', 'KM Mahakam Express', 'Kargo', '4500.00', '6.50', 'Sandar', '2026-10-25 08:00:00'),
('K002', 'KM Balikpapan Jaya', 'Container', '6200.00', '8.00', 'Berlayar', '2026-10-26 10:30:00'),
('K003', 'MV Kaltim Perkasa', 'Tanker', '7500.00', '9.20', 'Sandar', '2026-10-26 12:00:00'),
('K004', 'KM Samarinda Indah', 'Kargo', '3800.00', '5.80', 'Berlayar', '2026-10-26 14:15:00'),
('K005', 'KM Nusantara IKN', 'Container', '5100.00', '7.10', 'Sandar', '2026-10-27 06:30:00'),
('K006', 'KM Semayang Permai', 'Feri', '2900.00', '4.50', 'Sandar', '2026-10-27 08:00:00'),
('K007', 'KM Baruna Kaltim', 'Kargo', '4600.00', '6.60', 'Berlayar', '2026-10-27 09:45:00'),
('K008', 'MV Energy Balikpapan', 'Tanker', '8100.00', '10.00', 'Sandar', '2026-10-27 11:20:00'),
('K009', 'KM Palaran Trade', 'Container', '6400.00', '8.30', 'Berlayar', '2026-10-27 13:00:00'),
('K010', 'KM Delta Mahakam', 'Kargo', '4200.00', '6.00', 'Sandar', '2026-10-28 07:10:00'),
('K011', 'KM Benua Etam', 'Kargo', '3900.00', '5.50', 'Berlayar', '2026-10-28 09:00:00'),
('K012', 'KM Kutai Sejahtera', 'Container', '7000.00', '8.90', 'Sandar', '2026-10-28 10:30:00'),
('K013', 'MV Pertamina Kaltim', 'Tanker', '8500.00', '10.50', 'Berlayar', '2026-10-28 13:15:00'),
('K014', 'KM Rimba Kalimantan', 'Kargo', '4800.00', '6.80', 'Sandar', '2026-10-29 06:00:00'),
('K015', 'KM Pesona Etam', 'Feri', '3100.00', '4.80', 'Sandar', '2026-10-29 08:30:00'),
('K016', 'KM Bontang Sejahtera', 'Container', '5300.00', '7.40', 'Sandar', '2026-10-29 09:15:00'),
('K017', 'MV Pupuk Kaltim II', 'Tanker', '7200.00', '9.00', 'Berlayar', '2026-10-29 11:00:00'),
('K018', 'KM Sangatta Permai', 'Kargo', '4100.00', '6.10', 'Sandar', '2026-10-30 07:00:00'),
('K019', 'KM Berau Indah', 'Kargo', '4900.00', '6.90', 'Berlayar', '2026-10-30 08:30:00'),
('K020', 'KM Penajam Nusantara', 'Feri', '2800.00', '4.20', 'Sandar', '2026-10-30 10:00:00'),
('K021', 'KM Paser Sejahtera', 'Kargo', '3600.00', '5.50', 'Berlayar', '2026-10-30 13:00:00'),
('K022', 'KM Mahakam Ulu', 'Kargo', '3400.00', '5.20', 'Sandar', '2026-10-31 06:30:00'),
('K023', 'KM Kutai Kartanegara', 'Container', '6100.00', '7.80', 'Berlayar', '2026-10-31 09:00:00'),
('K024', 'KM Samboja Indah', 'Feri', '3000.00', '4.60', 'Sandar', '2026-10-31 10:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `kargo`
--

CREATE TABLE `kargo` (
  `id_kargo` varchar(10) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `berat_ton` decimal(10,2) NOT NULL,
  `status_kargo` varchar(30) NOT NULL,
  `Kapal_id_kapal` varchar(10) NOT NULL,
  `Slot_Gudang_id_slot` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kargo`
--

INSERT INTO `kargo` (`id_kargo`, `nama_barang`, `berat_ton`, `status_kargo`, `Kapal_id_kapal`, `Slot_Gudang_id_slot`) VALUES
('KG01', 'Besi Baja Proyek IKN', '120.50', 'Selesai', 'K001', 'SG01'),
('KG02', 'Peti Kemas Elektronik', '250.00', 'Disimpan', 'K002', 'SG02'),
('KG03', 'Bahan Bakar Industri', '450.20', 'Disimpan', 'K003', 'SG03'),
('KG04', 'Beras Logistik Kaltim', '180.00', 'Dalam Pengiriman', 'K004', 'SG04'),
('KG05', 'Suku Cadang Alat Berat IKN', '95.40', 'Disimpan', 'K005', 'SG05'),
('KG06', 'Kendaraan Bermotor', '310.00', 'Disimpan', 'K006', 'SG06'),
('KG07', 'Pupuk Subsidi Pertanian', '210.50', 'Disimpan', 'K007', 'SG07'),
('KG08', 'Bahan Kimia Pemurnian', '150.00', 'Disimpan', 'K008', 'SG08'),
('KG09', 'Kayu Olahan Plywood', '135.20', 'Disimpan', 'K009', 'SG09'),
('KG10', 'Kertas HVS Lokal', '88.00', 'Disimpan', 'K010', 'SG10'),
('KG11', 'Karet Lembaran Etam', '160.00', 'Disimpan', 'K011', 'SG11'),
('KG12', 'Tekstil & Pakaian Jadi', '75.30', 'Disimpan', 'K012', 'SG12'),
('KG13', 'Biji Tambang Lokal', '290.00', 'Disimpan', 'K013', 'SG13'),
('KG14', 'Gula Pasir Konsumsi', '140.00', 'Disimpan', 'K014', 'SG14'),
('KG15', 'Alat Berat Konstruksi', '520.00', 'Disimpan', 'K015', 'SG15'),
('KG16', 'Peti Kemas Ekspor', '300.00', 'Disimpan', 'K016', 'SG16'),
('KG17', 'Pupuk Urea Curah', '420.00', 'Disimpan', 'K017', 'SG17'),
('KG18', 'Batu Bara Kalbar', '600.00', 'Disimpan', 'K018', 'SG18'),
('KG19', 'Hasil Hutan Kayu', '230.00', 'Disimpan', 'K019', 'SG19'),
('KG20', 'Logistik Pendukung IKN', '190.00', 'Disimpan', 'K020', 'SG20'),
('KG21', 'Hasil Perkebunan Sawit', '350.00', 'Disimpan', 'K021', 'SG21'),
('KG22', 'Sembako Masyarakat', '110.00', 'Disimpan', 'K022', 'SG22'),
('KG23', 'Material Bangunan', '270.00', 'Disimpan', 'K023', 'SG23'),
('KG24', 'Kendaraan Niaga', '280.00', 'Disimpan', 'K024', 'SG24');

-- --------------------------------------------------------

--
-- Table structure for table `laporan`
--

CREATE TABLE `laporan` (
  `id_laporan` varchar(10) NOT NULL,
  `periode_mulai` date NOT NULL,
  `periode_selesai` date NOT NULL,
  `jumlah_kapal` int NOT NULL,
  `total_tonase` decimal(12,2) NOT NULL,
  `total_pendapatan` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE `operator` (
  `id_pengguna` varchar(10) NOT NULL,
  `shift_kerja` varchar(30) NOT NULL,
  `area_tugas` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`id_pengguna`, `shift_kerja`, `area_tugas`) VALUES
('U016', 'Pagi', 'A06'),
('U017', 'Malam', 'A06'),
('U018', 'Pagi', 'A07'),
('U019', 'Malam', 'A07'),
('U020', 'Pagi', 'A08'),
('U021', 'Malam', 'A08'),
('U022', 'Pagi', 'A09'),
('U023', 'Malam', 'A09'),
('U024', 'Pagi', 'A10'),
('U025', 'Malam', 'A10'),
('U026', 'Pagi', 'G11'),
('U027', 'Malam', 'G11'),
('U028', 'Pagi', 'G12'),
('U029', 'Malam', 'G12'),
('U030', 'Pagi', 'G13'),
('U031', 'Malam', 'G13'),
('U032', 'Pagi', 'G14'),
('U033', 'Malam', 'G14'),
('U034', 'Pagi', 'G15'),
('U035', 'Malam', 'G15'),
('U036', 'Pagi', 'N01'),
('U037', 'Malam', 'N01'),
('U038', 'Pagi', 'N02'),
('U039', 'Malam', 'N02'),
('U040', 'Pagi', 'N03'),
('U041', 'Malam', 'N03'),
('U042', 'Pagi', 'N04'),
('U043', 'Malam', 'N04'),
('U044', 'Pagi', 'N05'),
('U045', 'Malam', 'N05'),
('U046', 'Pagi', 'T15'),
('U047', 'Malam', 'T15'),
('U048', 'Pagi', 'T16'),
('U049', 'Malam', 'T16'),
('U050', 'Pagi', 'T17'),
('U051', 'Malam', 'T17'),
('U052', 'Pagi', 'T18'),
('U053', 'Malam', 'T18'),
('U054', 'Pagi', 'U20'),
('U055', 'Malam', 'U20'),
('U056', 'Pagi', 'U21'),
('U057', 'Malam', 'U21'),
('U058', 'Pagi', 'U22'),
('U059', 'Malam', 'U22'),
('U060', 'Pagi', 'U23'),
('U061', 'Malam', 'U23'),
('U062', 'Pagi', 'U24'),
('U063', 'Malam', 'U24');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` varchar(10) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama_lengkap`, `username`, `password`, `status`) VALUES
('U001', 'Budi Santoso', 'budi_adm_bpp', 'budi123', 'Aktif'),
('U002', 'Dewi Lestari', 'dewi_adm_smd', 'dewi123', 'Aktif'),
('U003', 'Eko Saputra', 'eko_adm_btg', 'eko123', 'Aktif'),
('U004', 'Siti Rahma', 'siti_adm_tgt', 'siti123', 'Aktif'),
('U005', 'Ahmad Dani', 'ahmad_adm_bru', 'ahmad123', 'Aktif'),
('U016', 'Andi Pratama', 'andi_op', 'andi123', 'Aktif'),
('U017', 'Bayu Setyo', 'bayu_op', 'bayu123', 'Aktif'),
('U018', 'Candra Wijaya', 'candra_op', 'candra123', 'Aktif'),
('U019', 'Dian Kusuma', 'dian_op', 'dian123', 'Aktif'),
('U020', 'Fajar Sidik', 'fajar_op', 'fajar123', 'Aktif'),
('U021', 'Gilang Ramadhan', 'gilang_op', 'gilang123', 'Aktif'),
('U022', 'Hadi Sucipto', 'hadi_op', 'hadi123', 'Aktif'),
('U023', 'Irfan Hakim', 'irfan_op', 'irfan123', 'Aktif'),
('U024', 'Jefri Nichol', 'jefri_op', 'jefri123', 'Aktif'),
('U025', 'Kurniawan', 'kurniawan_op', 'kurniawan123', 'Aktif'),
('U026', 'Lukman Hakim', 'lukman_op', 'lukman123', 'Aktif'),
('U027', 'Muhammad Ali', 'ali_op', 'ali123', 'Aktif'),
('U028', 'Noval Aulia', 'noval_op', 'noval123', 'Aktif'),
('U029', 'Oky Setiawan', 'oky_op', 'oky123', 'Aktif'),
('U030', 'Prasetyo', 'prasetyo_op', 'prasetyo123', 'Aktif'),
('U031', 'Qomarudin', 'qomar_op', 'qomar123', 'Aktif'),
('U032', 'Rahmat Hidayat', 'rahmat_op', 'rahmat123', 'Aktif'),
('U033', 'Rian Dhyani', 'rian_op', 'rian123', 'Aktif'),
('U034', 'Sandy Pratama', 'sandy_op', 'sandy123', 'Aktif'),
('U035', 'Teguh Prakoso', 'teguh_op', 'teguh123', 'Aktif'),
('U036', 'Utomo', 'utomo_op', 'utomo123', 'Aktif'),
('U037', 'Vicky Prasetyo', 'vicky_op', 'vicky123', 'Aktif'),
('U038', 'Wahyu Hidayat', 'wahyu_op', 'wahyu123', 'Aktif'),
('U039', 'Zainal Arifin', 'zainal_op', 'zainal123', 'Aktif'),
('U040', 'Yoga Pratama', 'yoga_op', 'yoga123', 'Aktif'),
('U041', 'Dimas Saputra', 'dimas_op', 'dimas123', 'Aktif'),
('U042', 'Reza Mahendra', 'reza_op', 'reza123', 'Aktif'),
('U043', 'Aditya Pratama', 'aditya_op', 'aditya123', 'Aktif'),
('U044', 'Rizky Ramadhan', 'rizky_op', 'rizky123', 'Aktif'),
('U045', 'Fauzan Akbar', 'fauzan_op', 'fauzan123', 'Aktif'),
('U046', 'Galih Wicaksono', 'galih_op', 'galih123', 'Aktif'),
('U047', 'Bagas Nugroho', 'bagas_op', 'bagas123', 'Aktif'),
('U048', 'Satria Pratama', 'satria_op', 'satria123', 'Aktif'),
('U049', 'Maulana Malik', 'maulana_op', 'maulana123', 'Aktif'),
('U050', 'Ilham Maulana', 'ilham_op', 'ilham123', 'Aktif'),
('U051', 'Aldi Taher', 'aldi_op', 'aldi123', 'Aktif'),
('U052', 'Rian Mahendra', 'rian_op', 'rian123', 'Aktif'),
('U053', 'Dicky Wahyudi', 'dicky_op', 'dicky123', 'Aktif'),
('U054', 'Eko Prasetyo', 'eko_op', 'eko123', 'Aktif'),
('U055', 'Fajar Nugraha', 'fajar_op', 'fajar123', 'Aktif'),
('U056', 'Gilang Pratama', 'gilang_op', 'gilang123', 'Aktif'),
('U057', 'Hendra Setiawan', 'hendra_op', 'hendra123', 'Aktif'),
('U058', 'Irfan Bachdim', 'irfan_op', 'irfan123', 'Aktif'),
('U059', 'Joko Anwar', 'joko_op', 'joko123', 'Aktif'),
('U060', 'Doni Setiawan', 'doni_op', 'doni123', 'Aktif'),
('U061', 'Rahmat Hidayat', 'rahmat_op', 'rahmat123', 'Aktif'),
('U062', 'Yoga Pratama', 'yoga2_op', 'yoga123', 'Aktif'),
('U063', 'Arya Wiguna', 'arya_op', 'arya123', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `retribusi`
--

CREATE TABLE `retribusi` (
  `id_retribusi` varchar(10) NOT NULL,
  `total_biaya` decimal(12,2) NOT NULL,
  `tarif` decimal(12,2) NOT NULL,
  `tanggal_bayar` date NOT NULL,
  `status_bayar` varchar(30) NOT NULL,
  `Admin_id_pengguna` varchar(10) NOT NULL,
  `Kapal_id_kapal` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `retribusi`
--

INSERT INTO `retribusi` (`id_retribusi`, `total_biaya`, `tarif`, `tanggal_bayar`, `status_bayar`, `Admin_id_pengguna`, `Kapal_id_kapal`) VALUES
('R001', '2500000.00', '500000.00', '2026-10-25', 'Lunas', 'U001', 'K001'),
('R002', '3100000.00', '500000.00', '2026-10-26', 'Lunas', 'U001', 'K002'),
('R003', '4200000.00', '600000.00', '2026-10-26', 'Lunas', 'U002', 'K003'),
('R004', '2100000.00', '400000.00', '2026-10-26', 'Lunas', 'U002', 'K004'),
('R005', '2800000.00', '500000.00', '2026-10-27', 'Lunas', 'U003', 'K005'),
('R006', '1900000.00', '350000.00', '2026-10-27', 'Lunas', 'U003', 'K006'),
('R007', '2600000.00', '500000.00', '2026-10-27', 'Lunas', 'U004', 'K007'),
('R008', '4500000.00', '700000.00', '2026-10-27', 'Lunas', 'U004', 'K008'),
('R009', '3300000.00', '550000.00', '2026-10-27', 'Lunas', 'U005', 'K009'),
('R010', '2300000.00', '450000.00', '2026-10-28', 'Lunas', 'U005', 'K010'),
('R011', '2150000.00', '400000.00', '2026-10-28', 'Lunas', 'U001', 'K011'),
('R012', '3800000.00', '600000.00', '2026-10-28', 'Lunas', 'U001', 'K012'),
('R013', '4700000.00', '750000.00', '2026-10-28', 'Lunas', 'U001', 'K013'),
('R014', '2700000.00', '500000.00', '2026-10-29', 'Lunas', 'U001', 'K014'),
('R015', '2000000.00', '350000.00', '2026-10-29', 'Lunas', 'U001', 'K015'),
('R016', '3200000.00', '500000.00', '2026-10-29', 'Lunas', 'U001', 'K016'),
('R017', '4100000.00', '650000.00', '2026-10-29', 'Lunas', 'U001', 'K017'),
('R018', '2400000.00', '400000.00', '2026-10-30', 'Lunas', 'U001', 'K018'),
('R019', '2900000.00', '500000.00', '2026-10-30', 'Lunas', 'U001', 'K019'),
('R020', '1800000.00', '300000.00', '2026-10-30', 'Lunas', 'U001', 'K020'),
('R021', '2250000.00', '400000.00', '2026-10-30', 'Lunas', 'U001', 'K021'),
('R022', '2050000.00', '350000.00', '2026-10-31', 'Lunas', 'U001', 'K022'),
('R023', '3900000.00', '600000.00', '2026-10-31', 'Lunas', 'U001', 'K023'),
('R024', '1950000.00', '350000.00', '2026-10-31', 'Lunas', 'U001', 'K024');

-- --------------------------------------------------------

--
-- Table structure for table `slot_gudang`
--

CREATE TABLE `slot_gudang` (
  `id_slot` varchar(10) NOT NULL,
  `kode_blok` varchar(20) NOT NULL,
  `status_slot` enum('Kosong','Terisi','Penuh') DEFAULT 'Kosong',
  `Operator_id_pengguna` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `slot_gudang`
--

INSERT INTO `slot_gudang` (`id_slot`, `kode_blok`, `status_slot`, `Operator_id_pengguna`) VALUES
('SG01', 'Blok D001-A', 'Terisi', 'U016'),
('SG02', 'Blok D002-A', 'Kosong', 'U017'),
('SG03', 'Blok D003-A', 'Terisi', 'U018'),
('SG04', 'Blok D004-A', 'Kosong', 'U019'),
('SG05', 'Blok D005-A', 'Terisi', 'U020'),
('SG06', 'Blok D006-A', 'Kosong', 'U021'),
('SG07', 'Blok D007-A', 'Terisi', 'U022'),
('SG08', 'Blok D008-A', 'Kosong', 'U023'),
('SG09', 'Blok D009-A', 'Terisi', 'U024'),
('SG10', 'Blok D010-A', 'Kosong', 'U025'),
('SG11', 'Blok D011-A', 'Terisi', 'U026'),
('SG12', 'Blok D012-A', 'Kosong', 'U027'),
('SG13', 'Blok D013-A', 'Terisi', 'U028'),
('SG14', 'Blok D014-A', 'Kosong', 'U029'),
('SG15', 'Blok D015-A', 'Terisi', 'U030'),
('SG16', 'Blok D016-A', 'Kosong', 'U031'),
('SG17', 'Blok D017-A', 'Terisi', 'U032'),
('SG18', 'Blok D018-A', 'Kosong', 'U033'),
('SG19', 'Blok D019-A', 'Terisi', 'U034'),
('SG20', 'Blok D020-A', 'Kosong', 'U035'),
('SG21', 'Blok D021-A', 'Terisi', 'U036'),
('SG22', 'Blok D022-A', 'Kosong', 'U037'),
('SG23', 'Blok D023-A', 'Terisi', 'U038'),
('SG24', 'Blok D024-A', 'Kosong', 'U039');

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_admin_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_admin_detail` (
`id_pengguna` varchar(10)
,`nip` varchar(30)
,`status` varchar(30)
,`username` varchar(50)
,`wilayah` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_estimasi_bersandar`
-- (See below for the actual view)
--
CREATE TABLE `v_estimasi_bersandar` (
`id_jadwal` varchar(10)
,`nama_dermaga` varchar(50)
,`nama_kapal` varchar(50)
,`waktu_lepas` datetime
,`waktu_sandar` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_jadwal_sandar_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_jadwal_sandar_detail` (
`kategori_kapal` varchar(30)
,`nama_kapal` varchar(50)
,`username_operator` varchar(50)
,`waktu_lepas` datetime
,`waktu_sandar` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_kapal_kargo`
-- (See below for the actual view)
--
CREATE TABLE `v_kapal_kargo` (
`draf_kapal` decimal(5,2)
,`gross_tonnage` decimal(10,2)
,`id_kapal` varchar(10)
,`jenis_kapal` varchar(30)
,`nama_kapal` varchar(50)
,`status_kapal` varchar(30)
,`waktu_kedatangan` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_kargo_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_kargo_detail` (
`berat_ton` decimal(10,2)
,`id_kargo` varchar(10)
,`lokasi_slot` varchar(20)
,`nama_barang` varchar(50)
,`nama_kapal` varchar(50)
,`status_kargo` varchar(30)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_kargo_slot_gudang`
-- (See below for the actual view)
--
CREATE TABLE `v_kargo_slot_gudang` (
`gross_tonnage` decimal(10,2)
,`id_kapal` varchar(10)
,`kode_dermaga` varchar(10)
,`nama_dermaga` varchar(50)
,`nama_kapal` varchar(50)
,`slot_gudang` varchar(16)
,`waktu_lepas` datetime
,`waktu_sandar` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_kategori_kapal`
-- (See below for the actual view)
--
CREATE TABLE `v_kategori_kapal` (
`draf_kapal` decimal(5,2)
,`gross_tonnage` decimal(10,2)
,`id_kapal` varchar(10)
,`jenis_kapal` varchar(30)
,`kategori_ukuran` varchar(11)
,`nama_kapal` varchar(50)
,`status_kapal` varchar(30)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_monitoring_dermaga`
-- (See below for the actual view)
--
CREATE TABLE `v_monitoring_dermaga` (
`id_dermaga` varchar(10)
,`nama_dermaga` varchar(50)
,`total_kapal_sandar` bigint
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_operator_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_operator_detail` (
`area_tugas` varchar(10)
,`id_pengguna` varchar(10)
,`shift_kerja` varchar(30)
,`status` varchar(30)
,`username` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_retribusi_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_retribusi_detail` (
`id_retribusi` varchar(10)
,`nama_admin` varchar(100)
,`nama_kapal` varchar(50)
,`status_bayar` varchar(30)
,`tanggal_bayar` date
,`total_biaya` decimal(12,2)
);

-- --------------------------------------------------------

--
-- Structure for view `v_admin_detail`
--
DROP TABLE IF EXISTS `v_admin_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_admin_detail`  AS SELECT `p`.`id_pengguna` AS `id_pengguna`, `p`.`username` AS `username`, `a`.`nip` AS `nip`, `a`.`wilayah` AS `wilayah`, `p`.`status` AS `status` FROM (`pengguna` `p` join `admin` `a` on((`p`.`id_pengguna` = `a`.`id_pengguna`)))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_estimasi_bersandar`
--
DROP TABLE IF EXISTS `v_estimasi_bersandar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_estimasi_bersandar`  AS SELECT `js`.`id_jadwal` AS `id_jadwal`, `k`.`nama_kapal` AS `nama_kapal`, `d`.`nama_dermaga` AS `nama_dermaga`, `js`.`waktu_sandar` AS `waktu_sandar`, `js`.`waktu_lepas` AS `waktu_lepas` FROM ((`jadwal_sandar` `js` join `kapal` `k` on((`js`.`Kapal_id_kapal` = `k`.`id_kapal`))) join `dermaga` `d` on((`js`.`Dermaga_id_dermaga` = `d`.`id_dermaga`)))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_jadwal_sandar_detail`
--
DROP TABLE IF EXISTS `v_jadwal_sandar_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_jadwal_sandar_detail`  AS SELECT `p`.`username` AS `username_operator`, `k`.`nama_kapal` AS `nama_kapal`, `k`.`jenis_kapal` AS `kategori_kapal`, `js`.`waktu_sandar` AS `waktu_sandar`, `js`.`waktu_lepas` AS `waktu_lepas` FROM ((((`jadwal_sandar` `js` join `kapal` `k` on((`js`.`Kapal_id_kapal` = `k`.`id_kapal`))) join `dermaga` `d` on((`js`.`Dermaga_id_dermaga` = `d`.`id_dermaga`))) join `operator` `o` on((`d`.`id_dermaga` = `o`.`area_tugas`))) join `pengguna` `p` on((`o`.`id_pengguna` = `p`.`id_pengguna`)))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_kapal_kargo`
--
DROP TABLE IF EXISTS `v_kapal_kargo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_kapal_kargo`  AS SELECT `k`.`id_kapal` AS `id_kapal`, `k`.`nama_kapal` AS `nama_kapal`, `k`.`jenis_kapal` AS `jenis_kapal`, `k`.`gross_tonnage` AS `gross_tonnage`, `k`.`draf_kapal` AS `draf_kapal`, `k`.`status_kapal` AS `status_kapal`, `k`.`waktu_kedatangan` AS `waktu_kedatangan` FROM `kapal` AS `k` WHERE (`k`.`jenis_kapal` = 'Kargo')  ;

-- --------------------------------------------------------

--
-- Structure for view `v_kargo_detail`
--
DROP TABLE IF EXISTS `v_kargo_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_kargo_detail`  AS SELECT `kg`.`id_kargo` AS `id_kargo`, `kg`.`nama_barang` AS `nama_barang`, `kg`.`berat_ton` AS `berat_ton`, `kg`.`status_kargo` AS `status_kargo`, `k`.`nama_kapal` AS `nama_kapal`, `sg`.`kode_blok` AS `lokasi_slot` FROM ((`kargo` `kg` join `kapal` `k` on((`kg`.`Kapal_id_kapal` = `k`.`id_kapal`))) join `slot_gudang` `sg` on((`kg`.`Slot_Gudang_id_slot` = `sg`.`id_slot`)))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_kargo_slot_gudang`
--
DROP TABLE IF EXISTS `v_kargo_slot_gudang`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_kargo_slot_gudang`  AS SELECT `k`.`id_kapal` AS `id_kapal`, `k`.`nama_kapal` AS `nama_kapal`, `k`.`gross_tonnage` AS `gross_tonnage`, `d`.`nama_dermaga` AS `nama_dermaga`, `js`.`Dermaga_id_dermaga` AS `kode_dermaga`, (case when (`js`.`Dermaga_id_dermaga` = 'N01') then 'Blok N01A' when (`js`.`Dermaga_id_dermaga` = 'N02') then 'Blok N02B' when (`js`.`Dermaga_id_dermaga` = 'N03') then 'Blok N03C' else concat('Blok ',`js`.`Dermaga_id_dermaga`,'A') end) AS `slot_gudang`, `js`.`waktu_sandar` AS `waktu_sandar`, `js`.`waktu_lepas` AS `waktu_lepas` FROM ((`jadwal_sandar` `js` join `kapal` `k` on((`js`.`Kapal_id_kapal` = `k`.`id_kapal`))) join `dermaga` `d` on((`js`.`Dermaga_id_dermaga` = `d`.`id_dermaga`))) WHERE (`k`.`jenis_kapal` = 'Kargo')  ;

-- --------------------------------------------------------

--
-- Structure for view `v_kategori_kapal`
--
DROP TABLE IF EXISTS `v_kategori_kapal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_kategori_kapal`  AS SELECT `kapal`.`id_kapal` AS `id_kapal`, `kapal`.`nama_kapal` AS `nama_kapal`, `kapal`.`jenis_kapal` AS `jenis_kapal`, `kapal`.`gross_tonnage` AS `gross_tonnage`, `kapal`.`draf_kapal` AS `draf_kapal`, `kapal`.`status_kapal` AS `status_kapal`, (case when (`kapal`.`gross_tonnage` > 4000) then 'Kapal Besar' else 'Kapal Kecil' end) AS `kategori_ukuran` FROM `kapal``kapal`  ;

-- --------------------------------------------------------

--
-- Structure for view `v_monitoring_dermaga`
--
DROP TABLE IF EXISTS `v_monitoring_dermaga`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_monitoring_dermaga`  AS SELECT `d`.`id_dermaga` AS `id_dermaga`, `d`.`nama_dermaga` AS `nama_dermaga`, count(`js`.`id_jadwal`) AS `total_kapal_sandar` FROM (`dermaga` `d` left join `jadwal_sandar` `js` on((`d`.`id_dermaga` = `js`.`Dermaga_id_dermaga`))) GROUP BY `d`.`id_dermaga`, `d`.`nama_dermaga``nama_dermaga`  ;

-- --------------------------------------------------------

--
-- Structure for view `v_operator_detail`
--
DROP TABLE IF EXISTS `v_operator_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_operator_detail`  AS SELECT `p`.`id_pengguna` AS `id_pengguna`, `p`.`username` AS `username`, `o`.`shift_kerja` AS `shift_kerja`, `o`.`area_tugas` AS `area_tugas`, `p`.`status` AS `status` FROM (`pengguna` `p` join `operator` `o` on((`p`.`id_pengguna` = `o`.`id_pengguna`)))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_retribusi_detail`
--
DROP TABLE IF EXISTS `v_retribusi_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_retribusi_detail`  AS SELECT `r`.`id_retribusi` AS `id_retribusi`, `p`.`nama_lengkap` AS `nama_admin`, `k`.`nama_kapal` AS `nama_kapal`, `r`.`total_biaya` AS `total_biaya`, `r`.`tanggal_bayar` AS `tanggal_bayar`, `r`.`status_bayar` AS `status_bayar` FROM (((`retribusi` `r` join `admin` `a` on((`r`.`Admin_id_pengguna` = `a`.`id_pengguna`))) join `pengguna` `p` on((`a`.`id_pengguna` = `p`.`id_pengguna`))) join `kapal` `k` on((`r`.`Kapal_id_kapal` = `k`.`id_kapal`)))  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `dermaga`
--
ALTER TABLE `dermaga`
  ADD PRIMARY KEY (`id_dermaga`);

--
-- Indexes for table `jadwal_sandar`
--
ALTER TABLE `jadwal_sandar`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `Kapal_id_kapal` (`Kapal_id_kapal`),
  ADD KEY `Dermaga_id_dermaga` (`Dermaga_id_dermaga`);

--
-- Indexes for table `kapal`
--
ALTER TABLE `kapal`
  ADD PRIMARY KEY (`id_kapal`);

--
-- Indexes for table `kargo`
--
ALTER TABLE `kargo`
  ADD PRIMARY KEY (`id_kargo`),
  ADD KEY `Kapal_id_kapal` (`Kapal_id_kapal`),
  ADD KEY `Slot_Gudang_id_slot` (`Slot_Gudang_id_slot`);

--
-- Indexes for table `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`id_laporan`);

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `retribusi`
--
ALTER TABLE `retribusi`
  ADD PRIMARY KEY (`id_retribusi`),
  ADD KEY `Admin_id_pengguna` (`Admin_id_pengguna`),
  ADD KEY `Kapal_id_kapal` (`Kapal_id_kapal`);

--
-- Indexes for table `slot_gudang`
--
ALTER TABLE `slot_gudang`
  ADD PRIMARY KEY (`id_slot`),
  ADD KEY `Operator_id_pengguna` (`Operator_id_pengguna`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jadwal_sandar`
--
ALTER TABLE `jadwal_sandar`
  ADD CONSTRAINT `jadwal_sandar_ibfk_1` FOREIGN KEY (`Kapal_id_kapal`) REFERENCES `kapal` (`id_kapal`),
  ADD CONSTRAINT `jadwal_sandar_ibfk_2` FOREIGN KEY (`Dermaga_id_dermaga`) REFERENCES `dermaga` (`id_dermaga`);

--
-- Constraints for table `kargo`
--
ALTER TABLE `kargo`
  ADD CONSTRAINT `kargo_ibfk_1` FOREIGN KEY (`Kapal_id_kapal`) REFERENCES `kapal` (`id_kapal`),
  ADD CONSTRAINT `kargo_ibfk_2` FOREIGN KEY (`Slot_Gudang_id_slot`) REFERENCES `slot_gudang` (`id_slot`);

--
-- Constraints for table `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `operator_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `retribusi`
--
ALTER TABLE `retribusi`
  ADD CONSTRAINT `retribusi_ibfk_1` FOREIGN KEY (`Admin_id_pengguna`) REFERENCES `admin` (`id_pengguna`),
  ADD CONSTRAINT `retribusi_ibfk_2` FOREIGN KEY (`Kapal_id_kapal`) REFERENCES `kapal` (`id_kapal`);

--
-- Constraints for table `slot_gudang`
--
ALTER TABLE `slot_gudang`
  ADD CONSTRAINT `slot_gudang_ibfk_1` FOREIGN KEY (`Operator_id_pengguna`) REFERENCES `operator` (`id_pengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
