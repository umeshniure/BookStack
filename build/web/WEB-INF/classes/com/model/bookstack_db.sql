-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2023 at 07:18 PM
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
  `vendor_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `isbn`, `author`, `published_year`, `category`, `price`, `cover_photo`, `publication`, `discounted_price`, `description`, `cover_type`, `language`, `type`, `cover_photo_name`, `vendor_id`, `quantity`) VALUES
(4, 'Do Epic Shit', 2663523, 'Ankur Warikoo', 2021, 5, 500, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\3\\Do Epic Shit-vendor3.png', 'Mumbai Publishers', 479, '\"Do Epic Shit\" is a captivating and inspiring book that pushes the boundaries of personal growth and achievement. In this transformative work, author Ankur Warikoo takes readers on a journey of self-discovery and empowers them to embrace their true potential.\n\nThrough real-life stories, practical strategies, and thought-provoking insights, \"Do Epic Shit\" challenges conventional thinking and encourages readers to break free from their comfort zones. With a unique blend of motivation and actionable advice, the book equips individuals with the tools they need to overcome obstacles, unleash their creativity, and create a life that is truly extraordinary.\n\nFrom setting audacious goals to developing a resilient mindset, \"Do Epic Shit\" provides a roadmap for turning dreams into reality. It explores the power of perseverance, resilience, and self-belief, inspiring readers to step outside their comfort zones and pursue their passions with unwavering determination.\n\nWhether you\'re an aspiring entrepreneur, a creative professional, or simply someone who wants to make a positive impact in the world, \"Do Epic Shit\" will ignite your inner fire and empower you to take bold action. Get ready to embark on an epic journey of self-discovery, growth, and transformation that will leave you inspired and motivated to unleash your full potential.', 1, 1, 1, 'Do Epic Shit-vendor3.png', 3, 3),
(5, 'The Alchemist', 43563456455645, 'paulo coehaelo', 2002, 4, 450, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\The Alchemistt-vendor4.png', 'harper collins', NULL, '\"The Alchemist\" is a timeless masterpiece that weaves together adventure, wisdom, and the pursuit of one\'s dreams. Written by the renowned author Paulo Coelho, this enchanting novel takes readers on a transformative journey through the magical landscapes of Andalusia and beyond.\n\nThe story follows Santiago, a young shepherd who embarks on a quest to discover his personal legend—the ultimate purpose and meaning of his life. Guided by a series of encounters and encounters with extraordinary individuals, including an enigmatic alchemist, Santiago learns profound lessons about the power of intuition, the language of the universe, and the importance of following one\'s heart.\n\nAs the pages turn, readers are transported into a world where dreams and reality intertwine, and where the pursuit of one\'s dreams becomes a metaphor for the human journey itself. \"The Alchemist\" is a captivating tale that explores themes of self-discovery, perseverance, and the inherent wisdom that lies within each of us.\n\nWith its lyrical prose and profound insights, \"The Alchemist\" has touched the hearts of millions of readers around the world. It serves as a reminder that life\'s true treasures are often found in the most unexpected places and that the pursuit of our dreams can lead us to uncover the essence of our own existence.\n\nImmerse yourself in this literary gem and let \"The Alchemist\" inspire you to listen to your heart\'s desires, embrace the unknown, and embark on a quest of self-discovery and personal fulfillment.', 1, 2, 1, 'The Alchemistt-vendor4.png', 4, 4),
(7, 'Rockin Rollin Rolpa', 232323234234, 'mahendra Joshi', 2018, 3, 400, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\Rockin Rollin Rolpa-vendor4.png', 'brosis india Pvt. Ltd.', NULL, '\"Rockin Rolling Rolpa\" is an exhilarating adventure that transports readers to the picturesque landscapes of Rolpa, a small Himalayan region in Nepal. Written by Mahendra p. Joshi, this captivating book combines elements of travelogue, cultural exploration, and personal growth.\n\nFollow the author\'s journey as they immerse themselves in the rich tapestry of Rolpa\'s traditions, folklore, and breathtaking natural beauty. From the majestic mountains to the vibrant local communities, \"Rockin Rolling Rolpa\" offers a unique glimpse into the heart and soul of this enchanting region.\n\nThrough vivid descriptions and heartfelt storytelling, the author shares their encounters with local villagers, their struggles and triumphs, and the profound wisdom they gain along the way. As the author delves deeper into the culture and history of Rolpa, they uncover hidden treasures, both within the landscape and within themselves.\n\n\"Rockin Rolling Rolpa\" is not just a travel memoir; it\'s an exploration of the human spirit and the transformative power of stepping outside one\'s comfort zone. With each turn of the page, readers will be inspired to embrace new experiences, embrace the unknown, and discover their own inner strength.\n\nWhether you\'re an armchair traveler or an adventurer at heart, \"Rockin Rolling Rolpa\" promises to take you on an unforgettable journey. Prepare to be moved, inspired, and transported to the awe-inspiring landscapes and captivating stories that await in Rolpa.', 1, 1, 1, 'Rockin Rollin Rolpa-vendor4.png', 4, 0),
(8, 'The Subtle Art of Not Giving a Fuck', 4534523533462456, 'Mark Manson', 2016, 6, 550, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\3\\The Subtle Art of Not Giving a Fuck-vendor3.png', 'Harper One Publishers', NULL, '\"The Subtle Art of Not Giving a F*ck\" is a refreshing and unconventional guide to living a fulfilling and authentic life. Written by renowned author Mark Manson, this thought-provoking book challenges traditional notions of happiness and success.\n\nThrough a blend of humor, personal anecdotes, and practical wisdom, \"The Subtle Art of Not Giving a F*ck\" invites readers to reevaluate their priorities and embrace a more honest and meaningful approach to life. It teaches the valuable lesson of focusing on what truly matters and letting go of unnecessary worries and societal pressures.\n\nWith a no-nonsense attitude, the book explores the importance of accepting the inevitable struggles and setbacks that come with the pursuit of happiness. It encourages readers to embrace their imperfections, confront their fears, and define their own values rather than seeking external validation.\n\n\"The Subtle Art of Not Giving a F*ck\" offers valuable insights on how to develop resilience, set boundaries, and make choices that align with one\'s core values. It empowers readers to let go of the trivial and focus on what brings genuine satisfaction and fulfillment.\n\nThis book is a must-read for anyone seeking a fresh perspective on life and a practical guide to finding true happiness. It will inspire you to live authentically, pursue what truly matters, and navigate life\'s challenges with courage and resilience.', 2, 2, 1, 'The Subtle Art of Not Giving a Fuck-vendor3.png', 3, 0),
(9, 'The Subtle Art of Not Giving a Fuck', 3245345234, 'Mark Manson', 2016, 6, 610, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\The Subtle Art of Not Giving a Fuck-vendor4.png', 'Harper One Publishers', 600, '\"The Subtle Art of Not Giving a F*ck\" is a refreshing and unconventional guide to living a fulfilling and authentic life. Written by renowned author Mark Manson, this thought-provoking book challenges traditional notions of happiness and success.\n\nThrough a blend of humor, personal anecdotes, and practical wisdom, \"The Subtle Art of Not Giving a F*ck\" invites readers to reevaluate their priorities and embrace a more honest and meaningful approach to life. It teaches the valuable lesson of focusing on what truly matters and letting go of unnecessary worries and societal pressures.\n\nWith a no-nonsense attitude, the book explores the importance of accepting the inevitable struggles and setbacks that come with the pursuit of happiness. It encourages readers to embrace their imperfections, confront their fears, and define their own values rather than seeking external validation.\n\n\"The Subtle Art of Not Giving a F*ck\" offers valuable insights on how to develop resilience, set boundaries, and make choices that align with one\'s core values. It empowers readers to let go of the trivial and focus on what brings genuine satisfaction and fulfillment.\n\nThis book is a must-read for anyone seeking a fresh perspective on life and a practical guide to finding true happiness. It will inspire you to live authentically, pursue what truly matters, and navigate life\'s challenges with courage and resilience.', 2, 2, 1, 'The Subtle Art of Not Giving a Fuck-vendor4.png', 4, 1),
(16, 'Rich Dad Poor Dad', 4534634, 'Robert kiyosakii', 2002, 5, 345, 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\book_cover_photos\\4\\Rich Dad Poor Dad-vendor4.png', 'Harper One Publishers', NULL, '\"Rich Dad Poor Dad\" is a groundbreaking book by renowned author Robert Kiyosaki that challenges traditional notions about wealth and financial success. In this thought-provoking work, Kiyosaki shares his personal experiences and the invaluable lessons he learned from his two influential fathers.\n\nThrough captivating storytelling, \"Rich Dad Poor Dad\" presents a powerful contrast between his own \"poor dad\" - his biological father who struggled financially despite his well-educated background - and his \"rich dad\" - a close friend\'s father who possessed a different mindset and approach to money.\n\nThis eye-opening book offers practical insights and strategies to break free from the cycle of working for money and instead, building wealth through financial intelligence and asset accumulation. Kiyosaki emphasizes the importance of financial education, asset ownership, and developing a mindset focused on financial independence.\n\nBy challenging conventional beliefs and providing clear guidance, \"Rich Dad Poor Dad\" equips readers with the knowledge and mindset necessary to take control of their financial destiny. It explores concepts such as investing, generating passive income, and understanding the difference between assets and liabilities.\n\nWhether you are just starting your financial journey or looking to expand your wealth-building knowledge, \"Rich Dad Poor Dad\" provides a roadmap to financial freedom. Prepare to be inspired, educated, and motivated to make informed decisions about your money and embark on a path towards financial independence.', 2, 2, 1, 'Rich Dad Poor Dad-vendor4.png', 4, 0);

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
  `delivered_date` date DEFAULT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `transaction_status` int(11) DEFAULT 1,
  `order_subtotal_amount` double NOT NULL,
  `order_total_amount` double NOT NULL,
  `special_instruction` varchar(200) DEFAULT NULL,
  `payment_method` varchar(50) DEFAULT NULL,
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

INSERT INTO `book_order` (`id`, `user_id`, `order_date`, `order_status`, `delivered_date`, `transaction_id`, `transaction_status`, `order_subtotal_amount`, `order_total_amount`, `special_instruction`, `payment_method`, `shipping_method`, `shipping_street`, `shipping_apartment`, `shipping_province`, `shipping_city`, `shipping_postcode`, `shipping_country`) VALUES
('5OjEuiJOnE', 1, '2023-04-04 00:00:00', 1, NULL, NULL, 1, 1895, 2141, '', 'Cash On Delivery', 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 'Bagmati', 'Kathmandu', 123322, 'Nepal'),
('92elZRCAcK', 1, '2023-01-19 00:00:00', 1, NULL, NULL, 1, 1379, 1558, '', 'Cash On Delivery', 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 'Bagmati', 'Kathmandu', 123322, 'Nepal'),
('GM2Uh1Iav2', 1, '2023-05-11 00:00:00', 1, NULL, NULL, 1, 1579, 1784, '', 'Cash On Delivery', 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 'Bagmati', 'Kathmandu', 123322, 'Nepal'),
('HYfDcEX16w', 1, '2022-11-01 00:00:00', 4, '2023-04-04', NULL, 1, 2041, 2306, 'fyfff sthvhvhhh', 'Cash On Delivery', 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 'Bagmati', 'Kathmandu', 123322, 'Nepal'),
('jxFQwJ5TmF', 5, '2023-01-19 00:00:00', 2, NULL, NULL, 1, 400, 452, '', 'Cash On Delivery', 1, 'kasukabe shi kasukabe higashi', 'haitsunakai 202', 'Bagmati', 'Kathmandu', 3223345, 'Nepal'),
('kMq23j7Fzr', 1, '2023-05-18 00:00:00', 1, NULL, NULL, 1, 900, 1017, '', 'Cash On Delivery', 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 'Bagmati', 'Kathmandu', 123322, 'Nepal'),
('slYHt5kD2E', 1, '2023-05-27 00:00:00', 1, NULL, NULL, 1, 850, 961, '', 'Cash On Delivery', 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 'Bagmati', 'Kathmandu', 123322, 'Nepal'),
('uzXF5V3qE2', 18, '2022-11-05 00:00:00', 1, NULL, NULL, 1, 879, 993, '', 'Cash On Delivery', 1, 'siddhartha marga', 'kapan-07', 'Bagmati', 'Kathmandu', NULL, 'Nepal'),
('zvcTbWGvzZ', 1, '2022-10-31 00:00:00', 1, NULL, NULL, 1, 1220, 1379, 'please deliver ASAP!!', 'Cash On Delivery', 1, 'Bigyan marga', 'Sankhamul, New baneshwor', 'Bagmati', 'Kathmandu', NULL, 'Nepal');

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
(91, 3, 4, 1, '2022-11-01'),
(107, 5, 16, 1, '2023-04-04'),
(126, 1, 4, 1, '2023-06-02'),
(127, 1, 5, 2, '2023-06-09');

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
(11, 'Sports'),
(29, 'Mystery and horror');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `city_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `city_name`) VALUES
(1, 'Kathmandu'),
(2, 'Bhaktapur'),
(3, 'Lalitpur');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `country_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `country_name`) VALUES
(1, 'Nepal');

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
(28, 'zvcTbWGvzZ', 5, 2, 410, 820, 107, 0),
(29, 'zvcTbWGvzZ', 7, 1, 400, 400, 52, 0),
(30, 'HYfDcEX16w', 5, 3, 410, 1230, 160, 0),
(31, 'HYfDcEX16w', 7, 1, 400, 400, 52, 0),
(32, 'HYfDcEX16w', 16, 1, 345, 345, 45, 0),
(33, 'HYfDcEX16w', 4, 2, 33, 66, 9, 0),
(45, 'jxFQwJ5TmF', 7, 1, 400, 400, 52, 0),
(46, '92elZRCAcK', 5, 2, 450, 900, 117, 0),
(47, '92elZRCAcK', 4, 1, 479, 479, 62, 0),
(48, '5OjEuiJOnE', 5, 1, 450, 450, 59, 0),
(49, '5OjEuiJOnE', 8, 2, 550, 1100, 143, 0),
(50, '5OjEuiJOnE', 16, 1, 345, 345, 45, 0),
(53, 'GM2Uh1Iav2', 8, 2, 550, 1100, 143, 0),
(54, 'GM2Uh1Iav2', 4, 1, 479, 479, 62, 0),
(55, 'kMq23j7Fzr', 5, 2, 450, 900, 117, 0),
(56, 'slYHt5kD2E', 5, 1, 450, 450, 59, 0),
(57, 'slYHt5kD2E', 7, 1, 400, 400, 52, 0);

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
(2, 'Accepted'),
(3, 'On its way'),
(4, 'Completed'),
(5, 'Cancelled');

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

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`id`, `user_id`, `payment_type_id`, `provider`, `account_number`, `expiry_date`, `is_default`) VALUES
(1, 5, 1, NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment_type`
--

CREATE TABLE `payment_type` (
  `id` int(11) NOT NULL,
  `payment_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_type`
--

INSERT INTO `payment_type` (`id`, `payment_type`) VALUES
(1, 'Cash On Delivery'),
(2, 'Digital payment (eSewa)'),
(3, 'Credit card (Master/Visa/JCB/American express)');

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `id` int(11) NOT NULL,
  `province_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`id`, `province_name`) VALUES
(1, 'Bagmati');

-- --------------------------------------------------------

--
-- Table structure for table `shipping_address`
--

CREATE TABLE `shipping_address` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `street` varchar(100) NOT NULL,
  `apartment` varchar(50) DEFAULT NULL,
  `city` int(11) NOT NULL,
  `province` int(11) NOT NULL,
  `postal_code` int(11) DEFAULT NULL,
  `country` int(11) NOT NULL,
  `is_default` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shipping_address`
--

INSERT INTO `shipping_address` (`id`, `user_id`, `street`, `apartment`, `city`, `province`, `postal_code`, `country`, `is_default`) VALUES
(1, 1, 'Simrik marga, Buddhanagar', 'New baneshwor', 1, 1, 123322, 1, 0),
(20, 2, 'dfgsrthg tgwrth uolioliiu olololo', 'New baneshwor gaa', 1, 1, 1011, 1, 0),
(25, 18, 'bindabasini marga', 'imaodol-3', 2, 1, NULL, 1, 1),
(26, 18, 'siddhartha marga', 'kapan-07', 1, 1, NULL, 1, 0),
(28, 5, 'kasukabe shi kasukabe higashi', 'haitsunakai 202', 1, 1, 3223345, 1, 1),
(29, 19, 'Sas', 'AAAA,Zxy', 1, 1, NULL, 1, 1);

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
-- Table structure for table `test_book_tbl`
--

CREATE TABLE `test_book_tbl` (
  `id` int(11) NOT NULL,
  `bookName` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `test_book_tbl`
--

INSERT INTO `test_book_tbl` (`id`, `bookName`, `author`, `price`) VALUES
(7, 'The Alchemist', 'paulo coehlo', 510),
(8, 'apple', 'umesh', 200);

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
(1, 'Umesh', 'Niure', NULL, 9860474319, 'umesh@gmail.com', 'ZmUOcSxRr7cAGBZ9gEHINA==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\user_profiles\\\\Umesh-Niure-1.png', 'Umesh-Niure-1.png', 1),
(2, 'Admin', '', NULL, NULL, 'admin@gmail.com', 'kJtJkaA80+e8YdaBcIbV/Q==', NULL, NULL, 3),
(3, NULL, NULL, 'Himal book and stationery', 9860124322, 'vendor1@gmail.com', '+gXlyymelJ1izfldD1BKKQ==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\vendor_profiles\\43294.jpg', 'Himal book and stationery-profile_pic.jpg', 2),
(4, NULL, NULL, 'Buddha Books', 3453452222, 'vendor2@gmail.com', 'fd5WcY9Frib89A/H+iDN9w==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\vendor_profiles\\0dd4207f83d869d21b6320d62736b48e-1000.jpg', 'buddha books-profile_pic.jpg', 2),
(5, 'Simran', 'Acharya', NULL, 0, 'simran@gmail.com', 'LDLcvOFyjEPOLf4Dx6jrpA==', NULL, NULL, 1),
(8, 'Arjun', 'Sitoula', NULL, 0, 'arjun@gmail.com', 'yB7Lx9sWN06Silkz4dbOUA==', NULL, NULL, 1),
(9, 'Prince', 'Singh', NULL, 0, 'prince@gmail.com.np', 'Aze7DbgfyAimASCWbFFmkQ==', NULL, NULL, 1),
(13, NULL, NULL, 'Pairabi Prakashan PVT. LTD.', 9860452342, 'vendor3@gmail.com', 'YNQZEx9vyg30ki7t58xs9g==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\vendor_profiles\\Pairabi Prakashan-profile_pic.png', 'Pairabi Prakashan-profile_pic.png', 2),
(18, 'Ramesh', 'Niure Sharma', NULL, 1234567890, 'ramesh@gmail.com', '4S6i1pudRPnAhZ12/aEQCA==', 'C:\\Users\\Umesh\\OneDrive\\Documents\\NetBeansProjects\\BookStack\\web\\images\\user_profiles\\\\Ramesh-Niure Sharma-18.png', 'Ramesh-Niure Sharma-18.png', 1);

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
-- Indexes for table `test_book_tbl`
--
ALTER TABLE `test_book_tbl`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `book_cover`
--
ALTER TABLE `book_cover`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `book_type`
--
ALTER TABLE `book_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `language`
--
ALTER TABLE `language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `order_status`
--
ALTER TABLE `order_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `payment_type`
--
ALTER TABLE `payment_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `shipping_address`
--
ALTER TABLE `shipping_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `shipping_method`
--
ALTER TABLE `shipping_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `test_book_tbl`
--
ALTER TABLE `test_book_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `transaction_status`
--
ALTER TABLE `transaction_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
  ADD CONSTRAINT `books_ibfk_6` FOREIGN KEY (`vendor_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `book_order`
--
ALTER TABLE `book_order`
  ADD CONSTRAINT `book_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_2` FOREIGN KEY (`transaction_status`) REFERENCES `transaction_status` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_3` FOREIGN KEY (`order_status`) REFERENCES `order_status` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `book_order_ibfk_4` FOREIGN KEY (`shipping_method`) REFERENCES `shipping_method` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `book_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
