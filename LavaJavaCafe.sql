/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-0ubuntu0.16.04.1 : Database - LavaJavaCafe
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`LavaJavaCafe` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `LavaJavaCafe`;

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`item_id`,`item_name`) values (1,'absdfg'),(3,'absdfg'),(6,'testubg 33'),(7,'saaaa'),(11,'testing one more time pasta'),(12,'lets doo this'),(15,'yuyu'),(17,'3'),(18,'33'),(19,'d'),(20,'2'),(21,'ee'),(22,'asfd'),(23,'dddd'),(24,'okay list'),(25,'df'),(26,'d'),(27,'dd'),(28,'ddfd'),(30,'new one'),(31,'911'),(32,'9292');

/*Table structure for table `item_customer` */

DROP TABLE IF EXISTS `item_customer`;

CREATE TABLE `item_customer` (
  `item_cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `cust_first_name` varchar(50) DEFAULT NULL,
  `cust_last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`item_cust_id`),
  KEY `item_id_fk` (`item_id`),
  CONSTRAINT `item_id_fk` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `item_customer` */

insert  into `item_customer`(`item_cust_id`,`item_id`,`cust_first_name`,`cust_last_name`) values (7,11,'hammad','ahmeds'),(8,11,'hammad','ahmeds'),(9,11,'safeer','sajjad'),(10,11,'safeer','sajjad'),(11,1,'hammad','ahmed'),(12,6,'one','two'),(13,15,'working ','now');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
