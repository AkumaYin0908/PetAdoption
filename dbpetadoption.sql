-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2023 at 06:35 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpetadoption`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblaccount`
--

CREATE TABLE `tblaccount` (
  `id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `account_type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblaccount_type`
--

CREATE TABLE `tblaccount_type` (
  `account_id` int(11) NOT NULL,
  `account_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE `tbladmin` (
  `admin_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `mid_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `birth_date` date NOT NULL,
  `account` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblcustomer`
--

CREATE TABLE `tblcustomer` (
  `customer_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `mid_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `birth_date` date NOT NULL,
  `account` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblpet`
--

CREATE TABLE `tblpet` (
  `pet_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT 'Lucky',
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `pet_type` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblpet_status`
--

CREATE TABLE `tblpet_status` (
  `status_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Available'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblpet_type`
--

CREATE TABLE `tblpet_type` (
  `type_id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbltransaction`
--

CREATE TABLE `tbltransaction` (
  `trans_id` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  `pet` int(11) NOT NULL,
  `trans_date` date NOT NULL,
  `trans_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbltransaction_type`
--

CREATE TABLE `tbltransaction_type` (
  `type_id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblaccount`
--
ALTER TABLE `tblaccount`
  ADD PRIMARY KEY (`user_name`),
  ADD KEY `id_idx` (`id`),
  ADD KEY `account_accounttype_fk` (`account_type`);

--
-- Indexes for table `tblaccount_type`
--
ALTER TABLE `tblaccount_type`
  ADD PRIMARY KEY (`account_id`);

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `tbladmin_account_fk` (`account`);

--
-- Indexes for table `tblcustomer`
--
ALTER TABLE `tblcustomer`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `customer_account_fk` (`account`);

--
-- Indexes for table `tblpet`
--
ALTER TABLE `tblpet`
  ADD PRIMARY KEY (`pet_id`),
  ADD KEY `pet_pettype_fk` (`pet_type`),
  ADD KEY `pet_petstatus_fk` (`status`);

--
-- Indexes for table `tblpet_status`
--
ALTER TABLE `tblpet_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `tblpet_type`
--
ALTER TABLE `tblpet_type`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `tbltransaction`
--
ALTER TABLE `tbltransaction`
  ADD PRIMARY KEY (`trans_id`),
  ADD KEY `trans_customer_fk` (`customer`),
  ADD KEY `transaction_transtype_fk` (`trans_type`),
  ADD KEY `trans_pet_fk` (`pet`);

--
-- Indexes for table `tbltransaction_type`
--
ALTER TABLE `tbltransaction_type`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblaccount_type`
--
ALTER TABLE `tblaccount_type`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblcustomer`
--
ALTER TABLE `tblcustomer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblpet`
--
ALTER TABLE `tblpet`
  MODIFY `pet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblpet_status`
--
ALTER TABLE `tblpet_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblpet_type`
--
ALTER TABLE `tblpet_type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbltransaction`
--
ALTER TABLE `tbltransaction`
  MODIFY `trans_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbltransaction_type`
--
ALTER TABLE `tbltransaction_type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblaccount`
--
ALTER TABLE `tblaccount`
  ADD CONSTRAINT `account_accounttype_fk` FOREIGN KEY (`account_type`) REFERENCES `tblaccount_type` (`account_id`) ON UPDATE CASCADE;

--
-- Constraints for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD CONSTRAINT `tbladmin_account_fk` FOREIGN KEY (`account`) REFERENCES `tblaccount` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `tblcustomer`
--
ALTER TABLE `tblcustomer`
  ADD CONSTRAINT `customer_account_fk` FOREIGN KEY (`account`) REFERENCES `tblaccount` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `tblpet`
--
ALTER TABLE `tblpet`
  ADD CONSTRAINT `pet_petstatus_fk` FOREIGN KEY (`status`) REFERENCES `tblpet_status` (`status_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pet_pettype_fk` FOREIGN KEY (`pet_type`) REFERENCES `tblpet_type` (`type_id`) ON UPDATE CASCADE;

--
-- Constraints for table `tbltransaction`
--
ALTER TABLE `tbltransaction`
  ADD CONSTRAINT `trans_customer_fk` FOREIGN KEY (`customer`) REFERENCES `tblcustomer` (`customer_id`),
  ADD CONSTRAINT `trans_pet_fk` FOREIGN KEY (`pet`) REFERENCES `tblpet` (`pet_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_transtype_fk` FOREIGN KEY (`trans_type`) REFERENCES `tbltransaction_type` (`type_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
