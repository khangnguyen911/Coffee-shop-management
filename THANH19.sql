CREATE DATABASE  IF NOT EXISTS `THANH19`;
CREATE TABLE `THANH19`.`tbl_employees` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `ho` varchar(45) DEFAULT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `tuoi` int DEFAULT NULL,
  `email` varchar(55) DEFAULT NULL,
  `diachi` varchar(75) DEFAULT NULL,
  `bophan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);