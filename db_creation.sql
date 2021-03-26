-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: adventure_alley
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '-',
  `description` varchar(700) NOT NULL DEFAULT '-',
  `price` float NOT NULL DEFAULT '0',
  `max_participants` int NOT NULL DEFAULT '0',
  `min_age` int NOT NULL DEFAULT '0',
  `duration_minutes` int NOT NULL DEFAULT '0',
  `photo_url` varchar(200) NOT NULL DEFAULT 'https://i.imgur.com/gr0S0QQ.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (17,'GoKart','According to Wikipedia, bcrypt is a password hashing algorithm developed by David Mazières and Niels Provos, based on the Blowfish cipher. Bcrypt makes use of an adaptive hash function to store password hash. BCrypt internally returns a random salt while encoding strings and it is obvious to get different encoded hashes for the same test. But one common thing in every hash is that every time it generates a string with a length of 60.',200,6,18,60,'https://i.imgur.com/2hIqDDI.jpg'),(18,'Sumo-bodysuit Konkurrence','According to Wikipedia, bcrypt is a password hashing algorithm developed by David Mazières and Niels Provos, based on the Blowfish cipher. Bcrypt makes use of an adaptive hash function to store password hash. BCrypt internally returns a random salt while encoding strings and it is obvious to get different encoded hashes for the same test. But one common thing in every hash is that every time it generates a string with a length of 60.',195,10,18,240,'https://i.imgur.com/bwDYcDG.jpg'),(19,'Bingo','According to Wikipedia, bcrypt is a password hashing algorithm developed by David Mazières and Niels Provos, based on the Blowfish cipher. Bcrypt makes use of an adaptive hash function to store password hash. BCrypt internally returns a random salt while encoding strings and it is obvious to get different encoded hashes for the same test. But one common thing in every hash is that every time it generates a string with a length of 60.',100,30,15,120,'https://i.imgur.com/OOZeETW.jpg'),(20,'Paintball','According to Wikipedia, bcrypt is a password hashing algorithm developed by David Mazières and Niels Provos, based on the Blowfish cipher. Bcrypt makes use of an adaptive hash function to store password hash. BCrypt internally returns a random salt while encoding strings and it is obvious to get different encoded hashes for the same test. But one common thing in every hash is that every time it generates a string with a length of 60.',250,16,18,30,'https://i.imgur.com/mYxVRKp.jpg');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Event`
--

DROP TABLE IF EXISTS `Event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activity_id` int NOT NULL,
  `start_date_time` datetime NOT NULL,
  `end_date_time` datetime NOT NULL,
  `host_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_actitity_id_idx` (`activity_id`),
  KEY `FK_user_id_idx` (`host_user_id`),
  CONSTRAINT `FK_actitity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_id` FOREIGN KEY (`host_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Event`
--

LOCK TABLES `Event` WRITE;
/*!40000 ALTER TABLE `Event` DISABLE KEYS */;
INSERT INTO `Event` VALUES (4,20,'2021-04-15 10:00:00','2021-04-15 10:30:00',10),(5,20,'2021-04-28 10:00:00','2021-04-28 10:30:00',10),(6,20,'2021-04-28 16:00:00','2021-04-28 16:30:00',10),(7,18,'2021-05-01 10:00:00','2021-05-01 14:00:00',10);
/*!40000 ALTER TABLE `Event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participants` (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_event_id_idx` (`event_id`),
  CONSTRAINT `FK_event_id` FOREIGN KEY (`event_id`) REFERENCES `Event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(400) NOT NULL,
  `admin_access` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'Kira','admin','$2y$12$ZfegoBbbLEYbc82qC6Ni.udYKG1T5E1N4L7LwOJzWYLBjxb6/jSiO',1);
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

-- Dump completed on 2021-03-26 15:40:34
