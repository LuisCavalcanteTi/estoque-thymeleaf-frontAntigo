-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: estoqueartesanart
-- ------------------------------------------------------
-- Server version	8.0.26

/*PRECISA CRIAR PRIMEIRO UM BANCO DE DADOS CHAMADO  estoqueartesanart*/

/*JOGUE ESSE CODIGO NO SEU BANCO DE DADOS MYSQL, ASSIM ELE CRIARÁ UM USUARIO PARA VOCÊ ACESSAR*/

create database estoqueartesanart;
use  estoqueartesanart;

/*senha de acesso igual ao do login -------> Login:luis e senha:luis*/

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('luis','ROLE_ADM'),('mais','ROLE_ESTOQUE'),('mais1','ROLE_ESTOQUE'),('ricardo','ROLE_ESTOQUE'),('rogerio','ROLE_ESTOQUE'),('sidinei','ROLE_ESTOQUE'),('tentando','ROLE_ESTOQUE'),('usuario','ROLE_USUARIO');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_produto` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `hora_finalizacao` varchar(255) DEFAULT NULL,
  `hora_impresso` varchar(255) DEFAULT NULL,
  `hora_requisicao` varchar(255) DEFAULT NULL,
  `medida` varchar(255) DEFAULT NULL,
  `nome_do_finalizante` varchar(255) DEFAULT NULL,
  `nome_do_requisitante` varchar(255) DEFAULT NULL,
  `quantidade` varchar(255) DEFAULT NULL,
  `quantidade_entregue` varchar(255) DEFAULT NULL,
  `setor_do_requisitante` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjgvb1pj32pv4ub09dofgm2eoh` (`user_username`),
  CONSTRAINT `FKjgvb1pj32pv4ub09dofgm2eoh` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (82,'ROLO4679,','Suporte Bolinha P/ Instalação da Rolo 32Mm Marrom',NULL,'Thu Feb 03 21:16:17 BRT 2022','Thu Feb 03 20:46:57 BRT 2022','Metros',NULL,'luis','100',NULL,'TI','IMPRESSO','luis'),(83,'ROLO4679,','Suporte Bolinha P/ Instalação da Rolo 32Mm Marrom',NULL,'Thu Feb 03 21:16:17 BRT 2022','Thu Feb 03 20:49:31 BRT 2022','Metros',NULL,'luis','100',NULL,'TI','IMPRESSO','luis');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'ROLO4675','Suporte Cruzeta P/ Instalação da Rolo 32Mm Preto'),(2,'ROLO4677','Suporte Bolinha P/ Instalação da Rolo 32Mm Branco'),(3,'ROLO4678','Suporte Bolinha P/ Instalação da Rolo 32Mm Bege'),(4,'ROLO4679','Suporte Bolinha P/ Instalação da Rolo 32Mm Marrom'),(5,'ROLO4676','Suporte Cruzeta P/ Instalação da Rolo 32Mm Cinza');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `setor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('luis','$2a$10$HlrX2DeJTmUzbGg9lLwiBeMj79tr1HP0KdDl3fAyCrnF1AIenX/Wa',1,NULL),('mais','$2a$10$SWsEeCvvQL0LGq4rmGMmhuYBMmIgdDl/kFKG3ENReKsw7UeiolT1m',1,NULL),('mais1','$2a$10$jI9mUF3WAvA4QbKrDfMmT.rDLSpUxVt6HdroQ0631EOfvFQ1WjwsG',1,NULL),('ricardo','$2a$10$0hoAu8zz8E5yoAQoPF8jZOtizCEFd8H7eGKas3gqz3B4LmWUlnkZK',1,NULL),('rogerio','$2a$10$x8y5mE7zYEU68VjbYZFp/.mu9uEGITzvRFzKRfhItC77v5HuZJNNy',1,NULL),('sidinei','$2a$10$BeEFShpBaHMkAzhmCfh.ouXaYqSUYbAqiG29qNkFibOqX8yf8oqSa',1,NULL),('tentando','$2a$10$mTpXbDKinrcoaOng3DcfaewMRfv5Gj9lZ9sH9YMGU.Oi6DdrD.SFi',1,NULL),('usuario','$2a$10$AMz3eFONvM78WjsHFydoUeumn.H4WXWhiE4hhLSMr44hDlp/mJ4NW',1,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-19 10:29:01
