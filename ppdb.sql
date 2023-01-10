-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2023 at 06:07 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ppdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('devaakbar', 'devaakbar');

-- --------------------------------------------------------

--
-- Table structure for table `calon_siswa`
--

CREATE TABLE `calon_siswa` (
  `id_calon` int(100) NOT NULL,
  `nama_calon_siswa` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `agama` varchar(255) NOT NULL,
  `asal_sekolah` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `calon_siswa`
--

INSERT INTO `calon_siswa` (`id_calon`, `nama_calon_siswa`, `jenis_kelamin`, `alamat`, `agama`, `asal_sekolah`) VALUES
(1, 'Udin', 'Laki-Laki', 'Jl.Perdagangan No.1', 'Islam', 'SMPN 1'),
(2, 'Amira', 'Perempuan', 'Jl.Cendrawasih No.11', 'Islam', 'SMP Kelayan 1'),
(3, 'Nicolle', 'Perempuan', 'Jl.Sejahtera No.22', 'Kristen Katolik', 'SMA Kristen 1'),
(4, 'I Putu Suharsono', 'Laki-Laki', 'Jl.S.Parman No.15', 'Buddha', 'SMP N 25 Banjarmasin'),
(6, 'Udin Saprudin', 'Laki-Laki', 'Jl.Kambing Hitam', 'Islam', 'SMPN 3'),
(7, 'Rasyid', 'Laki-Laki', 'Perdagangan 3', 'Islam', 'SMPN 2'),
(11, 'Syarkawi', 'Laki-Laki', 'Kuman', 'Buddha', 'Wijaya School'),
(17, 'Raisa', 'Perempuan', 'Jl.Perdagangan No.5', 'Buddha', 'SMPN 34 Bali'),
(18, 'Sherly', 'Perempuan', 'Jl.Flamboyan', 'Kristen Protestan', 'SMP Kristen Maria'),
(19, 'Safira', 'Perempuan', 'Jl.Cendrawasih No.23', 'Buddha', 'SMPN 33 Jakarta'),
(20, 'Jarwo', 'Laki-Laki', 'Jl.Solid No.25', 'Kristen Protestan', 'SMPN 2 Jatinegara'),
(21, 'Sopo', 'Laki-Laki', 'Jl.Cahaya Bumi', 'Islam', 'MTsn 22 Boyolali'),
(22, 'Arsene', 'Perempuan', 'Jl.Bima Sakti', 'Kristen Protestan', 'SMPN 21 Maluku'),
(23, 'Zeke', 'Laki-Laki', 'Jl.Shiganshina No.17', 'Kristen Katolik', 'SMP 22 Wonogiri');

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `id_pendaftaran` int(100) NOT NULL,
  `id_siswa` int(100) NOT NULL,
  `id_sekolah` int(100) NOT NULL,
  `status_pendaftaran` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pendaftaran`
--

INSERT INTO `pendaftaran` (`id_pendaftaran`, `id_siswa`, `id_sekolah`, `status_pendaftaran`) VALUES
(3, 2, 6, 'DITERIMA'),
(4, 6, 3, 'DITERIMA'),
(8, 4, 6, 'DITOLAK');

-- --------------------------------------------------------

--
-- Table structure for table `sekolah_pilihan`
--

CREATE TABLE `sekolah_pilihan` (
  `id_sekolah` int(100) NOT NULL,
  `nama_sekolah` varchar(255) NOT NULL,
  `alamat_sekolah` varchar(255) NOT NULL,
  `akreditasi_sekolah` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sekolah_pilihan`
--

INSERT INTO `sekolah_pilihan` (`id_sekolah`, `nama_sekolah`, `alamat_sekolah`, `akreditasi_sekolah`) VALUES
(1, 'SMA Negeri 1 Banjarmasin', 'Jl.Mulawarman No.25', 'A'),
(2, 'SMA N 2 Banjarmasin', 'Jl.Mulawarman No.21', 'A'),
(3, 'SMA N 3 Banjarmasin', 'Jl.Veteran Sungai Bilu No.381', 'A'),
(5, 'SMAN 17 Banjarmasin', 'Jl.Kelayan A No.117', 'B'),
(6, 'SMA Bina Banua', 'Jl.A.Yani Km.16,5', 'A'),
(10, 'SMAN 55 Wonogiri', 'Jl.Perdamaian No.124', 'B'),
(11, 'SMAN 12 Lampung', 'Jl.Wonosobo No.12', 'B'),
(12, 'SMAN Jayapura', 'Jl.A.Yani No.23', 'C'),
(13, 'SMAN 1 Madura', 'Jl.Pahlawan No.22', 'C'),
(14, 'SMAN 2 Semarang', 'Jl.Veteran No.31', 'B'),
(15, 'SMAN 5 Mamuju', 'Jl.Pencahayaan No/22', 'C');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `calon_siswa`
--
ALTER TABLE `calon_siswa`
  ADD PRIMARY KEY (`id_calon`);

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`id_pendaftaran`),
  ADD KEY `id_siswa` (`id_siswa`,`id_sekolah`),
  ADD KEY `id_sekolah` (`id_sekolah`);

--
-- Indexes for table `sekolah_pilihan`
--
ALTER TABLE `sekolah_pilihan`
  ADD PRIMARY KEY (`id_sekolah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `calon_siswa`
--
ALTER TABLE `calon_siswa`
  MODIFY `id_calon` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  MODIFY `id_pendaftaran` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `sekolah_pilihan`
--
ALTER TABLE `sekolah_pilihan`
  MODIFY `id_sekolah` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD CONSTRAINT `pendaftaran_ibfk_1` FOREIGN KEY (`id_siswa`) REFERENCES `calon_siswa` (`id_calon`),
  ADD CONSTRAINT `pendaftaran_ibfk_2` FOREIGN KEY (`id_sekolah`) REFERENCES `sekolah_pilihan` (`id_sekolah`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
