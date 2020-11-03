# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.4.13-MariaDB)
# Database: japaneserestaurant
# Generation Time: 2020-11-01 23:08:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table bills
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bills`;

CREATE TABLE `bills` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_date` date NOT NULL,
  `bill_total` double NOT NULL,
  `discount` double DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `FK2s1iwv6bgsmh8u9awhdd1aela` (`order_id`),
  CONSTRAINT `FK2s1iwv6bgsmh8u9awhdd1aela` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table customers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone_number` tinyblob NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;

INSERT INTO `customers` (`customer_id`, `address`, `first_name`, `last_name`, `phone_number`, `email`)
VALUES
	(10,'954 Gardiner Drive','Kevin','Zuhoski',X'3633312D3535392D38343139','kzuhoski87@gmail.com'),
	(11,'855 Smith Street','John','Smith',X'3535352D3535352D35353535','jsmith05@yahoo.com'),
	(17,'222 Pond Avenue','Bob','Jones',X'3232322D3232322D32323232','bjones@yahoo.com'),
	(18,'65 Manor Lane','Dave','Smith',X'3534352D3232322D39383034','dsmith02@gmail.com'),
	(19,'872 Fifth Avenue ','Chris','Thompson',X'3434342D3333332D32323232','Cthompson33@gmail.com');

/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table deliveries
# ------------------------------------------------------------

DROP TABLE IF EXISTS `deliveries`;

CREATE TABLE `deliveries` (
  `delivery_id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`delivery_id`),
  KEY `FKfsvruixg0c950pjc3jvqotwup` (`bill_id`),
  KEY `FKm9lst46kww5hcog9rrol0cec3` (`customer_id`),
  KEY `FK7isx0rnbgqr1dcofd5putl6jw` (`order_id`),
  CONSTRAINT `FK7isx0rnbgqr1dcofd5putl6jw` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FKfsvruixg0c950pjc3jvqotwup` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`bill_id`),
  CONSTRAINT `FKm9lst46kww5hcog9rrol0cec3` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table inquiries
# ------------------------------------------------------------

DROP TABLE IF EXISTS `inquiries`;

CREATE TABLE `inquiries` (
  `inquiry_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_days` varchar(50) NOT NULL DEFAULT '',
  `inquiry_date` datetime(6) NOT NULL,
  `inquiry_information` varchar(255) NOT NULL,
  `visit_history` char(1) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `inquiry_reason_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`inquiry_id`),
  KEY `FKmy8q2slo4b7ram3ao3a2ck1kl` (`customer_id`),
  KEY `FKbvibmsxtec2j5s9etbo9u208a` (`inquiry_reason_id`),
  CONSTRAINT `FKbvibmsxtec2j5s9etbo9u208a` FOREIGN KEY (`inquiry_reason_id`) REFERENCES `inquiry_reasons` (`inquiry_reason_id`),
  CONSTRAINT `FKmy8q2slo4b7ram3ao3a2ck1kl` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `inquiries` WRITE;
/*!40000 ALTER TABLE `inquiries` DISABLE KEYS */;

INSERT INTO `inquiries` (`inquiry_id`, `contact_days`, `inquiry_date`, `inquiry_information`, `visit_history`, `customer_id`, `inquiry_reason_id`)
VALUES
	(16,'Thursday,Friday','2020-10-28 21:52:47.134000','test','N',10,1),
	(17,'Wednesday,Thursday','2020-10-28 21:55:25.569000','test','N',17,1),
	(18,'Wednesday,Thursday','2020-10-28 21:55:52.857000','test two','N',17,1),
	(19,'Wednesday,Thursday','2020-10-31 22:38:17.821000','Test','N',19,1);

/*!40000 ALTER TABLE `inquiries` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table inquiry_reasons
# ------------------------------------------------------------

DROP TABLE IF EXISTS `inquiry_reasons`;

CREATE TABLE `inquiry_reasons` (
  `inquiry_reason_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_name` varchar(255) NOT NULL,
  PRIMARY KEY (`inquiry_reason_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `inquiry_reasons` WRITE;
/*!40000 ALTER TABLE `inquiry_reasons` DISABLE KEYS */;

INSERT INTO `inquiry_reasons` (`inquiry_reason_id`, `option_name`)
VALUES
	(1,'Catering'),
	(2,'Private Party'),
	(3,'Comments About Your Dining Experience'),
	(4,'Feedback'),
	(5,'Other');

/*!40000 ALTER TABLE `inquiry_reasons` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table menu_items
# ------------------------------------------------------------

DROP TABLE IF EXISTS `menu_items`;

CREATE TABLE `menu_items` (
  `menu_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_description` varchar(255) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_price` double NOT NULL,
  `item_type` int(11) NOT NULL,
  PRIMARY KEY (`menu_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `menu_items` WRITE;
/*!40000 ALTER TABLE `menu_items` DISABLE KEYS */;

INSERT INTO `menu_items` (`menu_item_id`, `item_description`, `item_name`, `item_price`, `item_type`)
VALUES
	(1,'SUSHI','SUSHI',30,1),
	(2,'RAMEN','RAMEN',10,1),
	(3,'SOBA AND TEMPURA','SOBA AND TEMPURA',12,1),
	(4,'JAPANESE GYOZA','JAPANESE GYOZA',7.99,1),
	(5,'UDON','UDON',9.99,1),
	(6,'TONKATSU','TONKATSU',12.99,1),
	(7,'OYAKODON','OYAKODON',13,1),
	(8,'GREEN TEA','GREEN TEA',5.99,2),
	(9,'SAKE','SAKE',10,2),
	(10,'MELON SODA','MELON SODA',4,2),
	(11,'BEER','BEER',7,2),
	(12,'OOLONG TEA','OOLONG TEA',5,2),
	(13,'SHIBUKAWA CAPPUCINIO','SHIBUKAWA CAPPUCINO',5,2),
	(14,'SASHIMI PLATTER','SASHIMI PLATTER',30,1);

/*!40000 ALTER TABLE `menu_items` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table order_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `order_menu`;

CREATE TABLE `order_menu` (
  `order_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_item_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`order_menu_id`),
  KEY `FK7ahwlx734q6r4mg4r98gr2ag8` (`menu_item_id`),
  KEY `FKmw4iqpidcbvklykhbhxewx124` (`order_id`),
  CONSTRAINT `FK7ahwlx734q6r4mg4r98gr2ag8` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_items` (`menu_item_id`),
  CONSTRAINT `FKmw4iqpidcbvklykhbhxewx124` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `order_menu` WRITE;
/*!40000 ALTER TABLE `order_menu` DISABLE KEYS */;

INSERT INTO `order_menu` (`order_menu_id`, `menu_item_id`, `order_id`, `quantity`)
VALUES
	(1,3,7,1),
	(2,2,7,2),
	(3,1,7,1),
	(4,2,8,2),
	(5,3,8,1),
	(6,3,9,1),
	(7,4,9,1),
	(8,5,9,1),
	(9,9,10,7),
	(10,11,10,1),
	(11,4,10,1),
	(12,1,11,1),
	(13,2,11,1),
	(14,3,11,2),
	(15,2,12,1),
	(16,3,12,1);

/*!40000 ALTER TABLE `order_menu` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKpxtb8awmi0dk6smoh2vp1litg` (`customer_id`),
  KEY `FK2m9qulf12xm537bku3jnrrbup` (`restaurant_id`),
  CONSTRAINT `FK2m9qulf12xm537bku3jnrrbup` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`),
  CONSTRAINT `FKpxtb8awmi0dk6smoh2vp1litg` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;

INSERT INTO `orders` (`order_id`, `customer_id`, `order_date`, `restaurant_id`)
VALUES
	(1,10,'2020-10-30',1),
	(2,10,'2020-10-30',1),
	(3,10,'2020-10-30',1),
	(4,10,'2020-10-30',1),
	(5,10,'2020-10-30',1),
	(6,10,'2020-10-30',1),
	(7,10,'2020-10-30',1),
	(8,10,'2020-10-30',1),
	(9,10,'2020-10-30',1),
	(10,10,'2020-10-30',1),
	(11,18,'2020-10-31',1),
	(12,10,'2020-11-01',1);

/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orders_menu_items
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders_menu_items`;

CREATE TABLE `orders_menu_items` (
  `orders_order_id` int(11) NOT NULL,
  `menuItems_menu_item_id` int(11) NOT NULL,
  UNIQUE KEY `UK_cjf0epcs5h2ejadlukufe1fwd` (`menuItems_menu_item_id`),
  KEY `FKafo17tdi3coirlf9pmpo04mee` (`orders_order_id`),
  CONSTRAINT `FKafo17tdi3coirlf9pmpo04mee` FOREIGN KEY (`orders_order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FKpa5lepff3wwjrqafr65m4j1j3` FOREIGN KEY (`menuItems_menu_item_id`) REFERENCES `menu_items` (`menu_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table payments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `payments`;

CREATE TABLE `payments` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `paymentType` varchar(255) NOT NULL,
  `bill_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_Id`),
  KEY `FK9565r6579khpdjxnyla0l2ycd` (`bill_id`),
  KEY `FK45dp0030s8e3myd8n6ky4e79g` (`customer_id`),
  KEY `FK81gagumt0r8y3rmudcgpbk42l` (`order_id`),
  CONSTRAINT `FK45dp0030s8e3myd8n6ky4e79g` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FK81gagumt0r8y3rmudcgpbk42l` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FK9565r6579khpdjxnyla0l2ycd` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table reservations
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reservations`;

CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `reservation_date_and_time` date NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `FK8eccffekcj27jkdiyw2e9r8ks` (`customer_id`),
  KEY `FK2tl2cjtd2o3o0nfeekcqfvt70` (`restaurant_id`),
  CONSTRAINT `FK2tl2cjtd2o3o0nfeekcqfvt70` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`),
  CONSTRAINT `FK8eccffekcj27jkdiyw2e9r8ks` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table restaurants
# ------------------------------------------------------------

DROP TABLE IF EXISTS `restaurants`;

CREATE TABLE `restaurants` (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;

INSERT INTO `restaurants` (`restaurant_id`, `address`)
VALUES
	(1,'55 Thompson Drive, Bay Shore NY 11706');

/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table reviews
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reviews`;

CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review` varchar(255) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK4sm0k8kw740iyuex3vwwv1etu` (`customer_id`),
  CONSTRAINT `FK4sm0k8kw740iyuex3vwwv1etu` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;

INSERT INTO `reviews` (`review_id`, `review`, `customer_id`)
VALUES
	(1,'This is the best Japanese restaurant I\'ve ever been to.',10),
	(2,'I will definitely come back to this restaurant again.  The food is amazing.',17),
	(5,'This restaurant is amazing!!!',18),
	(24,'I love the food here. It\'s well worth the price.  ',10);

/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `confirmPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_Id`),
  KEY `FKchxdoybbydcaj5smgxe0qq5mk` (`customer_id`),
  CONSTRAINT `FKchxdoybbydcaj5smgxe0qq5mk` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`user_Id`, `login`, `password`, `customer_id`, `confirmPassword`)
VALUES
	(10,'Zuke1987-','$2a$04$z6JEgg/exgrNh5jKObZS2OTQO.3/IRcClraYrzqGdnkYYMl1MUBQ6',10,NULL),
	(11,'jsmith05','$2a$04$lCtzLIio59WPtls8DsIkfuWUadgLv6zStFzguSl/3SgvQ774Q4OKO',11,NULL),
	(12,'Dsmith02','$2a$04$GGlRsXrtfUYSJ57Ml6cpC.UjEtEVM/zllpi6QmxeA0zrRq/khjK0q',18,NULL);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
