-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 17, 2015 at 08:48 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pointofsale`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `addproduct`
--
CREATE TABLE IF NOT EXISTS `addproduct` (
`product_id` int(5)
,`product_name` varchar(150)
,`brand_Name` varchar(50)
,`name` varchar(200)
);

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE IF NOT EXISTS `brand` (
  `id` int(5) NOT NULL,
  `brand_Name` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `brand_Name`) VALUES
(1, 'marill'),
(2, 'fdasd'),
(3, 'nmj'),
(4, 'dfd'),
(5, 'nb'),
(6, 'nb'),
(7, 'dfd'),
(8, 'mnk'),
(9, 'dfs'),
(10, 'mn');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(5) NOT NULL,
  `name` varchar(200) NOT NULL,
  `parent_id` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `parent_id`) VALUES
(1, 'fgdf', 0),
(3, 'manik', 0),
(4, 'rer', 0),
(5, 'sdf', 0),
(6, 'd', 0);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE IF NOT EXISTS `inventory` (
  `id` int(5) NOT NULL,
  `product_id` int(5) NOT NULL,
  `purchase_price` int(11) NOT NULL,
  `minimum_sale_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `exp_date` datetime NOT NULL,
  `purchase_date` datetime NOT NULL,
  `supplier_id` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `product_id`, `purchase_price`, `minimum_sale_price`, `quantity`, `exp_date`, `purchase_date`, `supplier_id`) VALUES
(1, 1, 456, 460, 4, '2015-09-30 00:00:00', '2015-09-30 00:00:00', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `mainproduct`
--
CREATE TABLE IF NOT EXISTS `mainproduct` (
`id` int(5)
,`purchase_price` int(11)
,`minimum_sale_price` int(11)
,`quantity` int(11)
,`product_name` varchar(150)
,`product_id` int(5)
);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(5) NOT NULL,
  `product_name` varchar(150) NOT NULL,
  `category_id` int(5) NOT NULL,
  `brand_id` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `category_id`, `brand_id`) VALUES
(1, 'horlisk', 300, 350),
(2, 'rice', 40, 42),
(3, 'Wizard T-shirt for Men (White)', 350, 370),
(4, 'Olodum T-shirt for Men (White)', 350, 370),
(5, 'Mr. Cool T-shirt for Men (Red)', 330, 350),
(6, 'Loyalty T-shirt for Men (Black)', 350, 370),
(8, 'fd', 4, 8),
(9, 'fdsdf', 5, 4),
(10, 'manik', 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `id` int(5) NOT NULL,
  `date_time` datetime NOT NULL,
  `grand_total` int(30) NOT NULL,
  `user_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sales_details`
--

CREATE TABLE IF NOT EXISTS `sales_details` (
  `id` int(5) NOT NULL,
  `sales_id` int(5) NOT NULL,
  `product_id` int(5) NOT NULL,
  `unit` int(5) NOT NULL,
  `unit_price` int(11) NOT NULL,
  `sub_total` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `company_location` varchar(250) NOT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `company_location`, `phone`) VALUES
(1, 'provati', 'dhaka', '243534234534');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `role` int(5) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_name`, `full_name`, `role`, `password`) VALUES
(1, 'manik', 'Md manik', 1, 'manik123');

-- --------------------------------------------------------

--
-- Structure for view `addproduct`
--
DROP TABLE IF EXISTS `addproduct`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `addproduct` AS (select `p`.`product_id` AS `product_id`,`p`.`product_name` AS `product_name`,`b`.`brand_Name` AS `brand_Name`,`c`.`name` AS `name` from ((`product` `p` join `category` `c` on((`p`.`category_id` = `c`.`id`))) join `brand` `b` on((`p`.`brand_id` = `b`.`id`))));

-- --------------------------------------------------------

--
-- Structure for view `mainproduct`
--
DROP TABLE IF EXISTS `mainproduct`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mainproduct` AS (select `i`.`id` AS `id`,`i`.`purchase_price` AS `purchase_price`,`i`.`minimum_sale_price` AS `minimum_sale_price`,`i`.`quantity` AS `quantity`,`p`.`product_name` AS `product_name`,`p`.`product_id` AS `product_id` from (`inventory` `i` join `product` `p` on((`i`.`product_id` = `p`.`product_id`))));

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales_details`
--
ALTER TABLE `sales_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sales_details`
--
ALTER TABLE `sales_details`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
