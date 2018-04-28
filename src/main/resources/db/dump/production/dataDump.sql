CREATE DATABASE  IF NOT EXISTS `conference` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `conference`;
-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: conference
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Alex','Nosko','ANJD97'),(2,'Tinner','Turner','TTID98'),(3,'Scott','Tiger','STMD73'),(4,'John','Smith','JSSD64'),(5,'Peter	','Jackson','PJMD44'),(6,'Jacky','Chan','JCMD55'),(7,'Susan','Boyle','SBI70'),(8,'Lotus','Notes','LNSD86'),(9,'Henry','Dickson','HDI79'),(10,'Sam','Davis','SDPM86');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Reservation`
--

LOCK TABLES `Reservation` WRITE;
/*!40000 ALTER TABLE `Reservation` DISABLE KEYS */;
INSERT INTO `Reservation` VALUES (1,1,1,'2018-04-18 14:00:00','2018-04-18 15:00:00'),(2,1,1,'2018-01-18 10:00:00','2018-01-18 10:30:00'),(3,1,1,'2018-05-18 14:00:00','2018-05-18 21:00:00'),(4,1,1,'2018-04-18 15:25:00','2018-04-18 15:30:00'),(5,1,1,'2018-04-18 15:30:00','2018-04-18 16:00:00'),(6,1,1,'2018-04-18 16:00:00','2018-04-18 17:00:00'),(7,1,1,'2018-04-18 17:00:00','2018-04-18 18:00:00'),(8,1,1,'2018-04-18 18:00:00','2018-04-18 19:00:00'),(9,1,1,'2018-04-18 19:00:00','2018-04-18 20:00:00');
/*!40000 ALTER TABLE `Reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` VALUES (1,'A101',10,'Interview room'),(2,'A102',10,'Interview room'),(3,'A103',20,'Meeting room'),(4,'B101',30,'Meeting room'),(5,'B102',35,'Conference room'),(6,'C101',20,'Meeting room'),(7,'C102',15,'Interview room'),(8,'C103',40,'Presentation room'),(9,'D101',45,'Presentation room'),(10,'D102',70,'Presentation room');
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'conference'
--

--
-- Dumping routines for database 'conference'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-28 20:29:29
