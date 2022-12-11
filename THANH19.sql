CREATE DATABASE  IF NOT EXISTS `THANH19`;
USE `THANH19`;

CREATE TABLE `THANH19`.`tbl_employees` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(64) DEFAULT NULL,
  `lastname` varchar(64) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `address` varchar(96) DEFAULT NULL,
  `position` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `THANH19`.`tbl_product` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(96) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `image` varchar(64) DEFAULT NULL,
  `ingredient` varchar(64) DEFAULT NULL,
  `category` varchar(64) DEFAULT NULL,
  `price` int(15) DEFAULT NULL,
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

INSERT INTO `tbl_roles` (`name`) VALUES ('USER');
INSERT INTO `tbl_roles` (`name`) VALUES ('CREATOR');
INSERT INTO `tbl_roles` (`name`) VALUES ('EDITOR');
INSERT INTO `tbl_roles` (`name`) VALUES ('ADMIN');

INSERT INTO `tbl_users` (`username`, `password`, `enabled`) VALUES ('user', '$2a$10$2X11Jg/REQHvgOABIUGGU.C38P.jSGL7fvcRWXCYVL5k9z7wRMNQy', '1');
INSERT INTO `tbl_users` (`username`, `password`, `enabled`) VALUES ('creator', '$2a$10$6A7g1L1Hw1M.aVqdorvXrumBjJCkWuL6EyJ9oMpBQ2xGXBJQ1S9t6', '1');
INSERT INTO `tbl_users` (`username`, `password`, `enabled`) VALUES ('editor', '$2a$10$d1xXOMGyBHugrj6woE/Ziu2LSKz9igp0IBJd6AfFkMZyajy2dr/Ym', '1');
INSERT INTO `tbl_users` (`username`, `password`, `enabled`) VALUES ('admin', '$2a$10$lXCq5fNe.oD1LBmnlIwHZORTq7kK5rMpFbfMQkQGBTMPU1U1C/Tt2', '1');
INSERT INTO `tbl_users` (`username`, `password`, `enabled`) VALUES ('npdkhang', '$2a$10$JiNxSTUZlwsI1ndQ8ndf1eAlh6eQXuGXBEdYC1.bC9u7hxLZW9XuS', '1');

INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (3, 3);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (4, 4);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (5, 2);
INSERT INTO `tbl_users_roles` (`user_id`, `role_id`) VALUES (5, 3);