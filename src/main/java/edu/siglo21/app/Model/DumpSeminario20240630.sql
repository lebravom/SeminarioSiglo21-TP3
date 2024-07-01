CREATE DATABASE  IF NOT EXISTS `seminario` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `seminario`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: seminario
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `idArticulo` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `categoria` varchar(50) DEFAULT NULL,
  `idMarca` int DEFAULT NULL,
  `idUnidadMedida` int DEFAULT NULL,
  `fecha_entrada` datetime DEFAULT NULL,
  `fecha_vencimiento` datetime DEFAULT NULL,
  `stock_disponible` int DEFAULT NULL,
  `stock_minimo` int DEFAULT NULL,
  `idProveedor` int DEFAULT NULL,
  PRIMARY KEY (`idArticulo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `idCategoria_idx` (`categoria`),
  KEY `idMarca_idx` (`idMarca`),
  KEY `idProveedor_idx` (`idProveedor`),
  CONSTRAINT `idMarca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`),
  CONSTRAINT `idProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (1,'123','qwer','qwer',NULL,NULL,NULL,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,NULL),(2,'1234','qwer','qwer',NULL,NULL,NULL,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,NULL),(3,'12344','qwer','qwer','17',2,NULL,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(4,'124','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(5,'321','asdasd','asdasd','14',NULL,4,'1969-12-31 00:00:00','1969-12-31 00:00:00',123,123,4),(6,'45234','wertwqe','wertwe','11',NULL,3,'1969-12-31 00:00:00','1969-12-31 00:00:00',234,543,1),(7,'7689','wert','weqtr','11',NULL,3,'1969-12-31 00:00:00','1969-12-31 00:00:00',123,123,1),(8,'3462','wert','wert','11',NULL,3,'1969-12-31 00:00:00','1969-12-31 00:00:00',544,5345,1),(9,'76','erty','dfgh','14',NULL,7,'1969-12-31 00:00:00','1969-12-31 00:00:00',4563,345,3),(10,'234523','qwerqwer','qwerqwer','14',NULL,6,'1969-12-31 00:00:00','1969-12-31 00:00:00',123451234,12341234,5),(11,'53245','werwqe','qwerqwe','11',NULL,3,'1969-12-31 00:00:00','1969-12-31 00:00:00',234,234,1),(12,'224','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(13,'2234','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(14,'22334','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(15,'272334','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(16,'2712334','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(17,'4','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(18,'5','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(19,'6','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(20,'7','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(21,'8','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(22,'9','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(23,'90','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(24,'91','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(25,'92','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(26,'93','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(27,'94','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(28,'890','asdf','fds','12',NULL,5,'1969-12-31 00:00:00','1969-12-31 00:00:00',123,123,1),(29,'2345654','etr','ert','13',NULL,7,'1969-12-31 00:00:00','1969-12-31 00:00:00',1234,234,2),(30,'95','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(31,'96','qwer','qwer','17',2,12,'2024-06-30 00:00:00','2024-06-30 00:00:00',200,100,6),(32,'68768','rtyey','ertyrty','11',4,5,'1969-12-31 00:00:00','1969-12-31 00:00:00',3456,3456,2);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(100) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT (curdate()),
  `fecha_eliminacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `nombre_categoria_UNIQUE` (`nombre_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (11,'Filtros (filtro de aceite, filtro de aire, filtro de combustible, etc.).','2024-06-30 00:00:00',NULL),(12,'Sistema de frenos (pastillas de freno, discos de freno, cilindros de freno, etc.).','2024-06-30 00:00:00',NULL),(13,'Partes del motor (pistones, válvulas, correas, bombas de agua, etc.).','2024-06-30 00:00:00',NULL),(14,'Sistema de transmisión (embragues, cajas de cambios, ejes de transmisión, etc.).','2024-06-30 00:00:00',NULL),(15,'Partes eléctricas (baterías, alternadores, bujías, cables de encendido, etc.).','2024-06-30 00:00:00',NULL),(16,'Sistema de suspensión y dirección (amortiguadores, barras estabilizadoras, rótulas, etc.).','2024-06-30 00:00:00',NULL),(17,'Iluminación (faros delanteros, luces traseras, bombillas, etc.).','2024-06-30 00:00:00',NULL),(18,'Partes de la carrocería (parachoques, capó, puertas, espejos, etc.).','2024-06-30 00:00:00',NULL),(19,'Sistemas de refrigeración (radiadores, termostatos, bombas de agua, etc.).','2024-06-30 00:00:00',NULL),(20,'Accesorios y equipamiento interior (alfombrillas, volantes, sistemas de audio, etc.).','2024-06-30 00:00:00',NULL);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `idMarca` int NOT NULL AUTO_INCREMENT,
  `nombre_marca` varchar(100) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT (curdate()),
  `fecha_eliminacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idMarca`),
  UNIQUE KEY `nombre_categoria_UNIQUE` (`nombre_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'AC Delco','2024-06-30 00:00:00',NULL),(2,'Motorcraft','2024-06-30 00:00:00',NULL),(3,'Monroe','2024-06-30 00:00:00',NULL),(4,'NGK','2024-06-30 00:00:00',NULL),(5,'Gates','2024-06-30 00:00:00',NULL),(6,'Mann-Filter','2024-06-30 00:00:00',NULL),(7,'SKF','2024-06-30 00:00:00',NULL),(8,'Akebono','2024-06-30 00:00:00',NULL),(9,'TRW','2024-06-30 00:00:00',NULL),(10,'Hella','2024-06-30 00:00:00',NULL);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` varchar(100) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT (curdate()),
  `fecha_eliminacion` datetime DEFAULT NULL,
  `persona_contacto` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `nombre_categoria_UNIQUE` (`nombre_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'YPF Directo','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(2,'Grupo Darc','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(3,'Grupo Sur','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(4,'New Repuestos','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(5,'Casiro','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(6,'Grupo Tres Arroyos','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(7,'Grupo Scania','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(8,'Grupo Mega','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(9,'Grupo Lander','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL),(10,'Grupo Automotores','2024-06-30 00:00:00',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmedida`
--

DROP TABLE IF EXISTS `unidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadmedida` (
  `idunidadMedida` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idunidadMedida`),
  UNIQUE KEY `idunidadMedida_UNIQUE` (`idunidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmedida`
--

LOCK TABLES `unidadmedida` WRITE;
/*!40000 ALTER TABLE `unidadmedida` DISABLE KEYS */;
INSERT INTO `unidadmedida` VALUES (1,'metro','longitud','metro'),(2,'centrimetro','longitud','metro / 100'),(3,'Centímetro (cm)',NULL,NULL),(4,'Metro (m)',NULL,NULL),(5,'Pulgadas (in)',NULL,NULL),(6,'Pies (ft)',NULL,NULL),(7,'Gramos (g)',NULL,NULL),(8,'Kilogramo (kg)',NULL,NULL),(9,'Onzas (oz)',NULL,NULL),(10,'Libras (lb)',NULL,NULL),(11,'Mililitros (ml)',NULL,NULL),(12,'Litro (l)',NULL,NULL),(13,'Centímetros cúbicos',NULL,NULL),(14,'Metros cúbicos',NULL,NULL),(15,'Unidad (u)',NULL,NULL),(16,'Docena (doc)',NULL,NULL),(17,'Miles',NULL,NULL);
/*!40000 ALTER TABLE `unidadmedida` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-30 22:51:57
