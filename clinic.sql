-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2021 at 01:07 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `P_NIC` varchar(11) NOT NULL,
  `P_Name` varchar(80) NOT NULL,
  `P_HomeNo` varchar(10) NOT NULL,
  `P_StreetName` varchar(50) NOT NULL,
  `P_City` varchar(20) NOT NULL,
  `P_DOB` date NOT NULL,
  `P_Sex` varchar(5) NOT NULL,
  `P_pno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`P_NIC`, `P_Name`, `P_HomeNo`, `P_StreetName`, `P_City`, `P_DOB`, `P_Sex`, `P_pno`) VALUES
('986545123v', 'yomal', '87', 'iui', 'kjh', '2021-06-27', 'Male', '0786545123'),
('987545612v', 'nanan', '54', 'dfg', 'dfb', '2021-06-27', 'Male', '0786532123'),
('994585212v', 'lahiru', '54', 'koh', 'oho', '2021-06-28', 'Male', '0');

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `Token_Id` int(11) NOT NULL,
  `Token_date` date NOT NULL,
  `Token_time` time NOT NULL,
  `P_Id` varchar(11) NOT NULL,
  `U_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `U_Id` int(11) NOT NULL,
  `U_Name` varchar(50) NOT NULL,
  `U_pno` int(10) NOT NULL,
  `U_Password` varchar(50) NOT NULL,
  `usertype` varchar(10) NOT NULL DEFAULT 'moderator'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`U_Id`, `U_Name`, `U_pno`, `U_Password`, `usertype`) VALUES
(0, 'janith', 789635452, 'Janith12345', 'admin'),
(1, 'jagath', 714545654, '272a30996fdd49d2779dc9f2fd629a73', 'admin'),
(2, 'kamala', 718565456, 'ba7186524a5c49d9ed21c3ee563358b5', 'moderator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`P_NIC`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`Token_Id`),
  ADD KEY `U_Id` (`U_Id`),
  ADD KEY `P_Id` (`P_Id`) USING BTREE;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`U_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `token`
--
ALTER TABLE `token`
  MODIFY `Token_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `token_ibfk_1` FOREIGN KEY (`P_Id`) REFERENCES `patient` (`P_NIC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `token_ibfk_2` FOREIGN KEY (`U_Id`) REFERENCES `user` (`U_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
