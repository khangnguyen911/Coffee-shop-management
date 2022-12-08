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

CREATE TABLE `THANH19`.`tbl_product` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `tensanpham` varchar(95) DEFAULT NULL,
  `mota` varchar(95) DEFAULT NULL,
  `hinhanh` varchar(95) DEFAULT NULL,
  `thanhphan` varchar(55) DEFAULT NULL,
  `danhmuc` varchar(75) DEFAULT NULL,
  `giaban` int(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
);