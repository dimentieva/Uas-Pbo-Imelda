-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 03, 2024 at 06:22 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_brg` varchar(10) NOT NULL,
  `nama_brg` varchar(100) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `hrgbeli` decimal(10,0) DEFAULT NULL,
  `hrgjual` decimal(10,0) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_brg`, `nama_brg`, `jenis`, `hrgbeli`, `hrgjual`, `stok`) VALUES
('BR002', 'pensil warna', 'Tas', 10000, 12000, 70),
('BR004', 'tas sekolah', 'tas', 40000, 50000, 988),
('BR005', 'ketas bufalo', 'Kertas', 500, 1000, 98),
('BR006', 'totebag', 'Tas', 3000, 15000, 11),
('BR007', 'tas laptop', 'Tas', 20000, 25000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `detailpenjualan`
--

CREATE TABLE `detailpenjualan` (
  `nofaktur` varchar(20) DEFAULT NULL,
  `idbarang` varchar(10) DEFAULT NULL,
  `namabrg` varchar(100) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` decimal(10,0) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailpenjualan`
--

INSERT INTO `detailpenjualan` (`nofaktur`, `idbarang`, `namabrg`, `jumlah`, `harga`, `total`) VALUES
('TR0001', 'BR002', 'pensil warna', 1, 12000, 12000),
('TR0001', 'BR002', 'pensil warna', 1, 12000, 12000),
('TR0001', 'BR002', 'pensil warna', 1, 12000, 12000),
('TR0002', 'BR002', 'pensil warna', 2, 12000, 24000),
('TR0003', 'BR004', 'tas sekolah', 12, 50000, 600000),
('TR0004', 'BR002', 'pensil warna', 5, 12000, 60000),
('TR0005', 'BR006', 'totebag', 1, 15000, 15000),
('TR0005', 'BR005', 'ketas bufalo', 2, 1000, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `nofak` varchar(20) NOT NULL,
  `tanggal` varchar(20) DEFAULT NULL,
  `totalbeli` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`nofak`, `tanggal`, `totalbeli`) VALUES
('TR0001', '18-07-2024', 12000),
('TR0002', '18-07-2024', 24000),
('TR0003', '19-07-2024', 600000),
('TR0004', '19-07-2024', 60000),
('TR0005', '19-07-2024', 17000),
('TR0006', '19-07-2024', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_brg`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`nofak`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
