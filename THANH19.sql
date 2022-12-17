CREATE DATABASE  IF NOT EXISTS `THANH19`;
USE `THANH19`;

CREATE TABLE `THANH19`.`tbl_employees` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `age` int NOT NULL,
  `email` varchar(64) NOT NULL,
  `address` varchar(96) NOT NULL,
  `position` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `THANH19`.`tbl_product` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(96) NOT NULL,
  `description` varchar(128) NOT NULL,
  `ingredient` varchar(64) NOT NULL,
  `price` int(15) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `THANH19`.`tbl_users` (
  `user_id` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(64) DEFAULT NULL,
  `lastname` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `address` varchar(96) DEFAULT NULL,
  `verification_code` varchar(64) DEFAULT NULL,
  `enabled` tinyint(5) DEFAULT NULL,
  `failed_attempt` tinyint(4) DEFAULT 0 NULL,
  `account_non_locked` tinyint(4) DEFAULT 1 NULL,
  `lock_time` datetime DEFAULT NULL,
  `tokenresetpassword` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);

CREATE TABLE `THANH19`.`tbl_roles` (
  `role_id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
);

CREATE TABLE `THANH19`.`tbl_users_roles` (
  `user_id` int(15) NOT NULL,
  `role_id` int(15) NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `tbl_roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `tbl_users` (`user_id`)
);

INSERT INTO `tbl_employees` (`firstname`, `lastname`, `age`, `email`, `address`, `position`) 
	VALUES ('Khang', 'Nguyen Phuc Duy', 22, 'khang@gmail.com', 'TPHCM', 'Phuc vu');
INSERT INTO `tbl_employees` (`firstname`, `lastname`, `age`, `email`, `address`, `position`) 
	VALUES ('Cong', 'Bui', 22, 'cong@gmail.com', 'TPHCM', 'Phuc vu');
INSERT INTO `tbl_employees` (`firstname`, `lastname`, `age`, `email`, `address`, `position`) 
	VALUES ('Thanh', 'Bui Cong', 23, 'thanh@gmail.com', 'TPHCM', 'Pha che');
INSERT INTO `tbl_employees` (`firstname`, `lastname`, `age`, `email`, `address`, `position`) 
	VALUES ('Phuc', 'Nguyen', 23, 'phuc@gmail.com', 'TPHCM', 'Pha che');
INSERT INTO `tbl_employees` (`firstname`, `lastname`, `age`, `email`, `address`, `position`) 
	VALUES ('Tan', 'Nguyen Minh', 24, 'tan@gmail.com', 'TPHCM', 'Thu ngan');
INSERT INTO `tbl_employees` (`firstname`, `lastname`, `age`, `email`, `address`, `position`) 
	VALUES ('Duy', 'Nguyen', 24, 'duy@gmail.com', 'TPHCM', 'Thu ngan');
    
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Americano Caffè', 'Espresso shots topped with hot water create a light layer of crema
              culminating in this wonderfully rich cup with depth and nuance.', 'Water, Brewed Espresso', 50000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Misto Caffè', ' A one-to-one combination of fresh-brewed coffee and steamed milk
              add up to one distinctly delicious coffee drink remarkably mixed.', 'Brewed Coffee, Milk', 55000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Blonde Caffè Americano', 'Espresso shots topped with hot water to produce a light layer of
              crema and are made with our Starbucks® Blonde Roast for an
              extra-smooth, subtly sweet and nuanced cup.', 'Water, Brewed Espresso', 53000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Blonde Roast', 'Lightly roasted coffee that\'s soft, mellow and flavorful.
              Easy-drinking on its own and delicious with milk, sugar or
              flavored with vanilla, caramel or hazelnut.', 'Brewed Coffee', 49000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Dark Roast Coffee', 'This full-bodied dark roast coffee with bold, robust flavors
              showcases our roasting and blending artistry—an essential blend of
              balanced and lingering flavors.', 'Brewed Coffee', 59000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Pike Place Roast', 'From our first store in Seattle’s Pike Place Market to our
              coffeehouses around the world, customers requested a freshly
              brewed coffee they could enjoy throughout the day.', 'Brewed Coffee', 57000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Decaf Pike Place Roast', 'From our first store in Seattle’s Pike Place Market to our
              coffeehouses around the world, customers requested a freshly
              brewed coffee they could enjoy throughout the day.', 'Brewed Decaf Coffee', 67000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Cappuccino', 'Dark, rich espresso lies in wait under a smoothed and stretched
              layer of thick milk foam. An alchemy of barista artistry and
              craft.', 'Milk, Brewed Espresso', 61000);
 INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Blonde Cappuccino', ' Our seriously smooth and subtly sweet Blonde Espresso lies in wait
              under a smoothed and stretched layer of thick foam.', 'Milk, Brewed Espresso', 65000);
 INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Espresso', 'Our smooth signature Espresso Roast with rich flavor and caramelly
              sweetness is at the very heart of everything we do.', 'Brewed Espresso', 67000);              
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Espresso Macchiato', 'Our rich espresso marked with dollop of steamed milk and foam. A
              European-style classic.', 'Brewed Espresso, Milk', 63000);
INSERT INTO `tbl_product` (`name`, `description`, `ingredient`, `price`) 
	VALUES ('Flat White', 'Smooth ristretto shots of espresso get the perfect amount of
              steamed whole milk to create a not-too-strong, not-too-creamy,
              just-right flavor.', ' Milk, Brewed Espresso', 75000);
              
INSERT INTO `tbl_roles` (`name`) VALUES ('USER');
INSERT INTO `tbl_roles` (`name`) VALUES ('MANAGER');
INSERT INTO `tbl_roles` (`name`) VALUES ('ADMIN');

INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('user', '1234', 'user', '$2a$10$2X11Jg/REQHvgOABIUGGU.C38P.jSGL7fvcRWXCYVL5k9z7wRMNQy', 'user1234@gmail.com', 'Sai Gon', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('manager', '4321', 'manager', '$2a$10$8M3n30x3TGZmfH.mhWSLLeuv2okxk.CCh3ppGeyrLEqx318BstCBC', 'manager4321@gmail.com', 'Sai Gon', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('admin', '2345', 'admin', '$2a$10$4rRjIxYxKRUI.qxzgOvuIeuEErQGlDLEbNA38AfAYYoEIe0jAYCZe', 'admin2345@gmail.com', 'Sai Gon', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Khang', 'Nguyen Phuc Duy', 'npdkhang', '$2a$10$Y.TBVja2ZsMn3xzb1IxfsOH/t7y9ULmBpQRMmUgjXP/UMTHSOilia', 'npdkhang@gmail.com', 'TPHCM', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Tan', 'Nguyen Minh', 'nminhtan', '$2a$10$vSj8XgUgsopxJGB6YzsUtOnbkDHEc9dHoIBDMHIwWA1Dqn6VFiuH6', 'nminhtan@gmail.com', 'TPHCM', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Thanh', 'Bui Cong', 'buicthanh', '$2a$10$BKZVetEVREUQegZ504A3jeq6qCcdtUNRc5tovzVFt/NXc4gpbJR7a', 'buicthanh@gmail.com', 'TPHCM', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Duy', 'Nguyen Phuc', 'nphucduy', '$2a$10$XDX3OpF/jHoCCQLv84Zz1u38RG3vZv4nX9tAf1vTUdL3ENdM671Fe', 'nphucduy@gmail.com', 'Long An', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Minh', 'Nguyen', 'nguyenminh', '$2a$10$j9gUHPpdGArOkeupLaI6K.waxyWJVOkAHxgXz6skTYRktuG1xFMv6', 'nguyenminh@gmail.com', 'Binh Duong', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Cong', 'Bui', 'buiicong', '$2a$10$fz0YH95u8YBGdMVU2qJniOnKU2Mb9IAnsPKwShx8tto.F7dDqNNeW', 'buiicong@gmail.com', 'An Giang', '1');
INSERT INTO `tbl_users` (`firstname`, `lastname`, `username`, `password`, `email`, `address`, `enabled`) 
	VALUES ('Phuc', 'Nguyen', 'nguyenphuc', '$2a$10$Ya5b49hkoSYWWdv80UJjaeruE9UjhfDJa09w7NBfVe6YUx7MjOYrC', 'nguyenphuc@gmail.com', 'Can Tho', '1');
    
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (3, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (4, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (5, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (6, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (7, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (8, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (9, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (10, 1);