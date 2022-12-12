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
  `image` varchar(64) NOT NULL,
  `ingredient` varchar(64) NOT NULL,
  `category` varchar(64) NOT NULL,
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
  `enabled` tinyint(5) DEFAULT NULL,
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

INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (3, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (4, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (5, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (6, 3);