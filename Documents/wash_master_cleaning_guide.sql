-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: wash_master
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cleaning_guide`
--

DROP TABLE IF EXISTS `cleaning_guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cleaning_guide` (
  `cleaning_guide_id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_id` int(11) DEFAULT NULL,
  `cargo_loaded_id` int(11) DEFAULT NULL,
  `method` varchar(100) DEFAULT NULL,
  `P` varchar(100) DEFAULT NULL,
  `M` varchar(100) DEFAULT NULL,
  `X` varchar(100) DEFAULT NULL,
  `S` varchar(250) DEFAULT NULL,
  `LUB` varchar(250) DEFAULT NULL,
  `notes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`cleaning_guide_id`),
  KEY `cargo_id` (`cargo_id`),
  KEY `cargo_loaded_id` (`cargo_loaded_id`),
  CONSTRAINT `cleaning_guide_ibfk_1` FOREIGN KEY (`cargo_id`) REFERENCES `previous_cargo` (`cargo_id`) ON DELETE CASCADE,
  CONSTRAINT `cleaning_guide_ibfk_2` FOREIGN KEY (`cargo_loaded_id`) REFERENCES `cargo_to_be_loaded` (`cargo_loaded_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cleaning_guide`
--

LOCK TABLES `cleaning_guide` WRITE;
/*!40000 ALTER TABLE `cleaning_guide` DISABLE KEYS */;
INSERT INTO `cleaning_guide` VALUES (1,1,1,'No washing required - strip and drain well Refer Notes: 1 & 2',NULL,NULL,NULL,NULL,NULL,'1. Tanks to be stripped dry such that any liquid ROB is confined to the pump well - or better.\n            2. Pump columns, deck lines, drops etc are to be blown clear and drained free of all product and water.');
/*!40000 ALTER TABLE `cleaning_guide` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-31 13:58:18
