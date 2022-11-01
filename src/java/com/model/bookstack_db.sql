-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2022 at 07:32 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstack_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `isbn` bigint(15) NOT NULL,
  `author` varchar(30) NOT NULL,
  `published_year` year(4) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `cover_photo` longtext NOT NULL,
  `publication` varchar(60) DEFAULT NULL,
  `discounted_price` int(11) DEFAULT NULL,
  `description` mediumtext DEFAULT NULL,
  `cover_type` int(11) NOT NULL,
  `language` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `cover_photo_name` text DEFAULT NULL,
  `vendor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `isbn`, `author`, `published_year`, `category`, `price`, `cover_photo`, `publication`, `discounted_price`, `description`, `cover_type`, `language`, `type`, `cover_photo_name`, `vendor_id`) VALUES
(4, 'Do Epic Shit', 2663522, 'Ankur Warikoo', 2021, 6, 500, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\3\\Do Epic Shit-vendor3.png', 'Mumbai Publishers', NULL, NULL, 1, 1, 1, 'Do Epic Shit-vendor3.png', 3),
(5, 'The Alchemist', 43563456455645, 'paulo coehaelo', 2002, 4, 450, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\The Alchemistt-vendor4.png', 'harper collins', 410, 'dfbdfg egbgb dfgb fg fghdfgh herth eth erth eerth rth ', 1, 2, 1, 'The Alchemistt-vendor4.png', 4),
(7, 'Rockin Rollin Rolpa', 232323234234, 'mahendra Joshi', 2018, 3, 400, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\Rockin Rollin Rolpa-vendor4.png', 'brosis india Pvt. Ltd.', NULL, 'zdfvsdfbsfd this a awesone rockin rollin book with tons of humor, drama, and culture heighlights.', 1, 1, 1, 'Rockin Rollin Rolpa-vendor4.png', 4),
(8, 'The Subtle Art of Not Giving a Fuck', 4534523533462456, 'Mark Manson', 2016, 6, 550, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\3\\The Subtle Art of Not Giving a Fuck-vendor3.png', 'Harper One Publishers', NULL, 'In this generation-defining self-help guide, a superstar blogger cuts through the crap to show us how to stop trying to be \"positive\" all the time so that we can truly become better, happier people.\r\n\r\nFor decades, weve been told that positive thinking is the key to a happy, rich life. \"F**k positivity,\" Mark Manson says. \"Lets be honest, shit is f**ked and we have to live with it.\" In his wildly popular Internet blog, Manson doesnt sugarcoat or equivocate. He tells it like it isa dose of raw, refreshing, honest truth that is sorely lacking today. The Subtle Art of Not Giving a F**k is his antidote to the coddling, lets-all-feel-good mindset that has infected modern society and spoiled a generation, rewarding them with gold medals just for showing up.\r\n\r\nManson makes the argument, backed both by academic research and well-timed poop jokes, that improving our lives hinges not on our ability to turn lemons into lemonade, but on learning to stomach lemons better. Human beings are flawed and limited\"not everybody can be extraordinary, there are winners and losers in society, and some of it is not fair or your fault.\" Manson advises us to get to know our limitations and accept them. Once we embrace our fears, faults, and uncertainties, once we stop running and avoiding and start confronting painful truths, we can begin to find the courage, perseverance, honesty, responsibility, curiosity, and forgiveness we seek.\r\n\r\nThere are only so many things we can give a f**k about so we need to figure out which ones really matter, Manson makes clear. While money is nice, caring about what you do with your life is better, because true wealth is about experience. A much-needed grab-you-by-the-shoulders-and-look-you-in-the-eye moment of real-talk, filled with entertaining stories and profane, ruthless humor, The Subtle Art of Not Giving a F**k is a refreshing slap for a generation to help them lead contented, grounded lives.', 2, 2, 1, 'The Subtle Art of Not Giving a Fuck-vendor3.png', 3),
(9, 'The Subtle Art of Not Giving a Fuck', 3245345234, 'Mark Manson', 2016, 6, 610, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\The Subtle Art of Not Giving a Fuck-vendor4.png', 'Harper One Publishers', NULL, 'sdfvsdfbsdb sdfdfv sdfgw dffgwe rgwer gwerg wrgwe rgwerg werrg', 2, 2, 1, 'The Subtle Art of Not Giving a Fuck-vendor4.png', 4),
(16, 'Rich Dad Poor Dad', 4534634, 'Robert kiyosakii', 2002, 5, 345, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\Rich Dad Poor Dad-vendor4.png', 'Harper One Publishers', NULL, 'dfvsdfs sdfvdsfgb', 2, 2, 1, 'Rich Dad Poor Dad-vendor4.png', 4);

-- --------------------------------------------------------

--
-- Table structure for table `book_cover`
--

CREATE TABLE `book_cover` (
  `id` int(11) NOT NULL,
  `cover_type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_cover`
--

INSERT INTO `book_cover` (`id`, `cover_type`) VALUES
(1, 'Soft paper cover'),
(2, 'Hardcover with ImageWrap'),
(3, 'Hardcover with Dust Jacket');

-- --------------------------------------------------------

--
-- Table structure for table `book_order`
--

CREATE TABLE `book_order` (
  `id` varchar(15) NOT NULL,
  `user_id` int(11) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_status` int(11) DEFAULT 1,
  `transaction_id` int(11) DEFAULT NULL,
  `transaction_status` int(11) DEFAULT 1,
  `order_subtotal_amount` double NOT NULL,
  `order_total_amount` double NOT NULL,
  `special_instruction` varchar(200) DEFAULT NULL,
  `payment_method` int(11) DEFAULT NULL,
  `shipping_method` int(11) DEFAULT NULL,
  `shipping_street` varchar(80) DEFAULT NULL,
  `shipping_apartment` varchar(30) DEFAULT NULL,
  `shipping_province` varchar(30) DEFAULT NULL,
  `shipping_city` varchar(30) DEFAULT NULL,
  `shipping_postcode` int(11) DEFAULT NULL,
  `shipping_country` varchar(30) NOT NULL DEFAULT 'Nepal'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_order`
--

INSERT INTO `book_order` (`id`, `user_id`, `order_date`, `order_status`, `transaction_id`, `transaction_status`, `order_subtotal_amount`, `order_total_amount`, `special_instruction`, `payment_method`, `shipping_method`, `shipping_street`, `shipping_apartment`, `shipping_province`, `shipping_city`, `shipping_postcode`, `shipping_country`) VALUES
('EuZZtdMsGp', 5, '2022-09-12 00:00:00', 1, NULL, 1, 1000, 1000, '', NULL, 1, 'shantinagar', '', '', 'kathmandu', 3440062, 'Nepal'),
('HmKGT4j2t0', 1, '2022-10-19 00:00:00', 1, NULL, 1, 1410, 1410, '', NULL, 1, 'rthdth', 'tfhrj', 'vzxfhe56hb', 'adfvaXDV', 3343353, 'Nepal'),
('s1zwyYIuez', 5, '2022-10-25 00:00:00', 1, NULL, 1, 400, 400, '', NULL, 1, 'qergqergf', 'wergerg', 'rgwrg', 'wergwerg', NULL, 'Nepal'),
('xCW0LetSmA', 1, '2022-10-22 00:00:00', 1, NULL, 1, 1295, 1295, '', NULL, 1, 'dfsvsdfdgbhfgebgfn', 'dfvwfdbvwrfvwrv', 'dsfvsdfvwfv', 'wdfvwfv', 123322, 'Nepal');

-- --------------------------------------------------------

--
-- Table structure for table `book_type`
--

CREATE TABLE `book_type` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_type`
--

INSERT INTO `book_type` (`id`, `type`) VALUES
(1, 'Brand new'),
(2, 'Used (like new)'),
(3, 'Used');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `user_id`, `book_id`, `quantity`, `created_date`) VALUES
(54, 9, 5, 1, '2022-09-13'),
(55, 9, 4, 2, '2022-09-13'),
(56, 9, 7, 1, '2022-09-13'),
(83, 1, 9, 1, '2022-10-26');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `category_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `category_name`) VALUES
(3, 'Business'),
(4, 'Novel'),
(5, 'Sci-fi'),
(6, 'Motivation'),
(8, 'Finance'),
(9, 'Romance'),
(11, 'Sports');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `city_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `country_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `id` int(11) NOT NULL,
  `language_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`id`, `language_name`) VALUES
(1, 'Nepali'),
(2, 'English'),
(3, 'Indian'),
(4, 'Japanese'),
(6, 'Newari'),
(8, 'Korean'),
(10, 'Vietnamese');

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` int(11) NOT NULL,
  `order_id` varchar(15) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit_price` double NOT NULL,
  `total_price` double NOT NULL,
  `tax_amount` double NOT NULL DEFAULT 0,
  `shipping_amount` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`id`, `order_id`, `book_id`, `quantity`, `unit_price`, `total_price`, `tax_amount`, `shipping_amount`) VALUES
(2, 'EuZZtdMsGp', 4, 1, 0, 1000, 0, 0),
(10, 'HmKGT4j2t0', 4, 2, 0, 1410, 0, 0),
(11, 'HmKGT4j2t0', 5, 1, 0, 1410, 0, 0),
(12, 'xCW0LetSmA', 7, 1, 0, 1295, 0, 0),
(13, 'xCW0LetSmA', 8, 1, 0, 1295, 0, 0),
(14, 'xCW0LetSmA', 16, 1, 0, 1295, 0, 0),
(15, 's1zwyYIuez', 7, 1, 0, 400, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE `order_status` (
  `id` int(11) NOT NULL,
  `order_status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_status`
--

INSERT INTO `order_status` (`id`, `order_status`) VALUES
(1, 'Pending'),
(2, 'Accepted');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `payment_type_id` int(11) NOT NULL,
  `provider` varchar(50) DEFAULT NULL,
  `account_number` varchar(20) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `is_default` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment_type`
--

CREATE TABLE `payment_type` (
  `id` int(11) NOT NULL,
  `payment_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_type`
--

INSERT INTO `payment_type` (`id`, `payment_type`) VALUES
(1, 'Cash On Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `id` int(11) NOT NULL,
  `province_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_address`
--

CREATE TABLE `shipping_address` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `street` varchar(100) NOT NULL,
  `apartment` varchar(50) NOT NULL,
  `city` int(11) NOT NULL,
  `province` int(11) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `country` int(11) NOT NULL,
  `is_default` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_method`
--

CREATE TABLE `shipping_method` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shipping_method`
--

INSERT INTO `shipping_method` (`id`, `name`, `price`) VALUES
(1, 'Standard Free Shipping', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_status`
--

CREATE TABLE `transaction_status` (
  `id` int(11) NOT NULL,
  `transaction_status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction_status`
--

INSERT INTO `transaction_status` (`id`, `transaction_status`) VALUES
(1, 'Pending'),
(2, 'Success');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `store_name` varchar(50) DEFAULT NULL,
  `phone_number` bigint(10) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `profile_pic` text DEFAULT NULL,
  `profile_pic_name` varchar(70) DEFAULT NULL,
  `user_type` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `store_name`, `phone_number`, `email`, `password`, `profile_pic`, `profile_pic_name`, `user_type`) VALUES
(1, 'Umesh', 'Niure', NULL, 9860474319, 'umesh@gmail.com', 'dW1lc2g=', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\user_profiles\\\\Umesh-Niure-1.png', 'Umesh-Niure-1.png', 1),
(2, 'Admin', '', NULL, NULL, 'admin@gmail.com', 'YWRtaW4=', NULL, NULL, 3),
(3, NULL, NULL, 'Himal book and stationery', 9860124322, 'vendor1@gmail.com', 'dmVuZG9yMQ==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\vendor_profiles\\43294.jpg', 'Himal book and stationery-profile_pic.jpg', 2),
(4, NULL, NULL, 'Buddha Books', 3453452222, 'vendor2@gmail.com', 'dmVuZG9yMg==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\vendor_profiles\\0dd4207f83d869d21b6320d62736b48e-1000.jpg', 'buddha books-profile_pic.jpg', 2),
(5, 'Simran', 'Acharya', NULL, NULL, 'simran@gmail.com', 'c2ltcmFu', NULL, NULL, 1),
(8, 'Arjun', 'Sitoula', NULL, 0, 'arjun@gmail.com', 'YXJqdW4=', NULL, NULL, 1),
(9, 'Prince', 'Singh', NULL, 0, 'prince@gmail.com.np', 'MTIzNDU=', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE `user_type` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_type`
--

INSERT INTO `user_type` (`id`, `type`) VALUES
(1, 'user'),
(2, 'vendor'),
(3, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `category` (`category`),
  ADD KEY `cover_type` (`cover_type`),
  ADD KEY `language` (`language`),
  ADD KEY `type` (`type`),
  ADD KEY `vendor_id` (`vendor_id`);

--
-- Indexes for table `book_cover`
--
ALTER TABLE `book_cover`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_order`
--
ALTER TABLE `book_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_status` (`order_status`),
  ADD KEY `transaction_satus` (`transaction_status`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `payment_method` (`payment_method`),
  ADD KEY `shipping_method` (`shipping_method`);

--
-- Indexes for table `book_type`
--
ALTER TABLE `book_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `payment_type_id` (`payment_type_id`);

--
-- Indexes for table `payment_type`
--
ALTER TABLE `payment_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shipping_address`
--
ALTER TABLE `shipping_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `city` (`city`),
  ADD KEY `province` (`province`),
  ADD KEY `country` (`country`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `shipping_method`
--
ALTER TABLE `shipping_method`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction_status`
--
ALTER TABLE `transaction_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_type` (`user_type`);

--
-- Indexes for table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `book_cover`
--
ALTER TABLE `book_cover`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `book_type`
--
ALTER TABLE `book_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `language`
--
ALTER TABLE `language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `order_status`
--
ALTER TABLE `order_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_type`
--
ALTER TABLE `payment_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shipping_address`
--
ALTER TABLE `shipping_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shipping_method`
--
ALTER TABLE `shipping_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transaction_status`
--
ALTER TABLE `transaction_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user_type`
--
ALTER TABLE `user_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`category`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `books_ibfk_3` FOREIGN KEY (`cover_type`) REFERENCES `book_cover` (`id`),
  ADD CONSTRAINT `books_ibfk_4` FOREIGN KEY (`type`) REFERENCES `book_type` (`id`),
  ADD CONSTRAINT `books_ibfk_5` FOREIGN KEY (`language`) REFERENCES `language` (`id`),
  ADD CONSTRAINT `books_ibfk_6` FOREIGN KEY (`vendor_id`) REFERENCES `users` (`ID`);

--
-- Constraints for table `book_order`
--
ALTER TABLE `book_order`
  ADD CONSTRAINT `book_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_2` FOREIGN KEY (`transaction_status`) REFERENCES `transaction_status` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_3` FOREIGN KEY (`order_status`) REFERENCES `order_status` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_4` FOREIGN KEY (`shipping_method`) REFERENCES `shipping_method` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_5` FOREIGN KEY (`payment_method`) REFERENCES `payment_method` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `book_order` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD CONSTRAINT `payment_method_ibfk_1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `shipping_address`
--
ALTER TABLE `shipping_address`
  ADD CONSTRAINT `shipping_address_ibfk_1` FOREIGN KEY (`country`) REFERENCES `country` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `shipping_address_ibfk_2` FOREIGN KEY (`city`) REFERENCES `city` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `shipping_address_ibfk_3` FOREIGN KEY (`province`) REFERENCES `province` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
