-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2021 at 01:37 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uasalex`
--

-- --------------------------------------------------------

--
-- Table structure for table `tanaman`
--

CREATE TABLE `tanaman` (
  `id_tanaman` int(11) NOT NULL,
  `nama_tanaman` varchar(100) NOT NULL,
  `nama_ilmiah` varchar(100) NOT NULL,
  `gambar` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tanaman`
--

INSERT INTO `tanaman` (`id_tanaman`, `nama_tanaman`, `nama_ilmiah`, `gambar`) VALUES
(1, 'Anggrek Bulan', 'Phalaenopsis amabilis', 'anggrek-bulan.png'),
(2, 'Ciplukan', 'Physalis angulata', 'ciplukan.png'),
(3, 'Mengkudu', 'Morinda citrifolia', 'mengkudu.png'),
(4, 'Belimbing Wuluh', 'Averrhoa bilimbi', 'belimbing_wuluh.png'),
(5, 'Kemang', 'Mangifera kemanga', 'kemang.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tanaman`
--
ALTER TABLE `tanaman`
  ADD PRIMARY KEY (`id_tanaman`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tanaman`
--
ALTER TABLE `tanaman`
  MODIFY `id_tanaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
