-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: wheelfinder
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL,
  PRIMARY KEY (`admin_id`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buys`
--

DROP TABLE IF EXISTS `buys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buys` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `timeBuy` varchar(255) DEFAULT NULL,
  `totalFee` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `buys_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `buys_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buys`
--

LOCK TABLES `buys` WRITE;
/*!40000 ALTER TABLE `buys` DISABLE KEYS */;
INSERT INTO `buys` VALUES (1,8,24,'23-11-2024  06:16',34000),(2,8,13,'23-11-2024  06:55',25000),(3,8,14,'23-11-2024  06:57',35000),(4,8,21,'23-11-2024  06:59',43000),(5,8,29,'23-11-2024  09:00',45000),(6,8,29,'23-11-2024  09:04',45000),(7,8,29,'23-11-2024  09:09',45000);
/*!40000 ALTER TABLE `buys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `color` varchar(20) DEFAULT NULL,
  `yearRelease` int DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `available` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'Toyota','Camry','White',2022,30000.00,12),(2,'Toyota','Corolla','Black',2021,20000.00,7),(3,'Honda','Civic','Silver',2020,22000.00,9),(4,'Honda','Accord','Blue',2022,35000.00,12),(5,'Ford','Focus','Red',2019,18000.00,12),(6,'Ford','Mustang','Yellow',2023,45000.00,12),(7,'BMW','X5','Black',2022,60000.00,11),(8,'BMW','3 Series','White',2021,40000.00,7),(9,'Mercedes','C-Class','Gray',2021,50000.00,8),(10,'Mercedes','E-Class','Black',2023,70000.00,9),(11,'Hyundai','Elantra','White',2020,17000.00,9),(12,'Hyundai','Santa Fe','Blue',2021,32000.00,6),(13,'Kia','Seltos','Red',2022,25000.00,11),(14,'Kia','Sorento','White',2021,35000.00,10),(15,'Mazda','CX-5','Silver',2022,33000.00,12),(16,'Mazda','Mazda3','Black',2021,21000.00,11),(17,'Chevrolet','Malibu','Blue',2020,23000.00,12),(18,'Chevrolet','Tahoe','Black',2023,55000.00,9),(19,'Nissan','Altima','White',2021,24000.00,12),(20,'Nissan','Rogue','Silver',2022,27000.00,11),(21,'Audi','A4','Gray',2022,43000.00,6),(22,'Audi','Q5','Black',2023,52000.00,6),(23,'Volkswagen','Passat','White',2021,30000.00,6),(24,'Volkswagen','Tiguan','Blue',2022,34000.00,6),(25,'Subaru','Outback','Green',2021,32000.00,7),(26,'Subaru','Forester','Silver',2022,28000.00,12),(27,'Tesla','Model 3','Red',2023,55000.00,7),(28,'Tesla','Model Y','Black',2023,60000.00,12),(29,'Lexus','RX','White',2022,45000.00,11);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL,
  PRIMARY KEY (`client_id`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phoneNum` varchar(50) NOT NULL,
  `passwrd` varchar(50) NOT NULL,
  `typeNum` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Quang','Pham','admin10212004@gmail.com','000','211004',1),(2,'Quang','Pham','admin10212004@gmail.com','000','211004',1),(3,'hung','dao','dvhung','111','111',0),(4,'han','pham','hp123@gmail.com','hp123@gmail.com','111',0),(5,'client0','000','111','000','111',0),(6,'Anakin','Skywalker','admin2@gmail.com','000','1',1),(7,'Han','Pham','admin3@gmail.com','000','1',1),(8,'quang','pham','admin@gmail.com','111','1',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-25 10:48:34
