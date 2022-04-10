-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: zl
-- ------------------------------------------------------
-- Server version	10.7.3-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Sequence structure for `hibernate_sequence`
--

DROP SEQUENCE IF EXISTS `hibernate_sequence`;
CREATE SEQUENCE `hibernate_sequence` start with 1 minvalue 1 maxvalue 9223372036854775806 increment by 1 cache 1000 nocycle ENGINE=InnoDB;
SELECT SETVAL(`hibernate_sequence`, 3001, 0);

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL,
  `brand` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mileage` double NOT NULL,
  `newprice` double NOT NULL,
  `price` double NOT NULL,
  `firstpayment` double NOT NULL,
  `cc` float NOT NULL,
  `licensedate` date DEFAULT NULL,
  `bhairbag` bit(1) NOT NULL,
  `bcentrearmrest` bit(1) NOT NULL,
  `fhairbag` bit(1) NOT NULL,
  `fairbag` bit(1) NOT NULL,
  `fcentrearmrest` bit(1) NOT NULL,
  `ppowerseat` bit(1) NOT NULL,
  `spowerseat` bit(1) NOT NULL,
  `afterradar` bit(1) NOT NULL,
  `buttonstart` bit(1) NOT NULL,
  `formerradar` bit(1) NOT NULL,
  `gps` bit(1) NOT NULL,
  `immobilizer` bit(1) NOT NULL,
  `mfl` bit(1) NOT NULL,
  `parkassist` bit(1) NOT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES
(1090,'honda','civic',2000,3000,4000,5000,6000,'2020-01-01','\0','\0','\0','\0','\0','\0','\0','\0','\0','\0','\0','\0','\0','\0',0),
(2006,'honda','civic',2000,3000,4000,5000,1.5,'2020-01-01','','','','','','','','','','','','','','',0);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phonenumber` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `role` int(11) DEFAULT 1,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(18,'ceelia0g@gmail.com','celiae','celiae','18627193396','foo','celiae','2019-03-27 00:00:00',0,''),
(2005,'ceelia0@163.com','haha','happy',NULL,'haha','celiae',NULL,0,'\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'zl'
--
