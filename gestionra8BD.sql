CREATE DATABASE  IF NOT EXISTS `sql7776134` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sql7776134`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sql7776134
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `carrito_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `fecha_compra` datetime NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `pdf_factura` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (3,12,'2025-05-07 00:00:00',11.40,''),(4,12,'2025-05-07 00:00:00',9.98,''),(5,12,'2025-05-07 00:00:00',6.30,''),(6,12,'2025-05-07 00:00:00',11.00,''),(7,12,'2025-05-07 00:00:00',1.20,''),(8,12,'2025-05-07 00:00:00',3.50,''),(9,12,'2025-05-07 00:00:00',2.10,''),(10,12,'2025-05-07 00:00:00',3.40,''),(11,12,'2025-05-07 00:00:00',9.25,''),(12,12,'2025-05-07 00:00:00',9.60,''),(13,12,'2025-05-07 00:00:00',8.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_13.pdf'),(14,12,'2025-05-08 00:00:00',0.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_14.pdf'),(15,12,'2025-05-08 00:00:00',3.60,''),(16,12,'2025-05-08 00:00:00',4.40,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_16.pdf'),(17,12,'2025-05-08 00:00:00',13.20,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_17.pdf'),(18,12,'2025-05-08 00:00:00',2.30,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_18.pdf'),(19,12,'2025-05-08 00:00:00',8.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_19.pdf'),(20,12,'2025-05-08 00:00:00',3.80,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_20.pdf'),(21,12,'2025-05-08 00:00:00',7.00,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_21.pdf'),(22,12,'2025-05-08 00:00:00',24.10,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_22.pdf'),(23,12,'2025-05-08 00:00:00',3.10,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_23.pdf'),(24,12,'2025-05-08 00:00:00',20.47,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf\\factura_compra_24.pdf'),(25,12,'2025-05-08 00:00:00',4.15,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdffactura_compra_25.pdf'),(26,12,'2025-05-08 00:00:00',21.80,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_26.pdf'),(27,12,'2025-05-08 00:00:00',17.39,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_27.pdf'),(28,1,'2025-05-11 00:00:00',25.69,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_28.pdf'),(29,1,'2025-05-11 00:00:00',3.75,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_29.pdf'),(30,12,'2025-05-12 00:00:00',28.44,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_30.pdf'),(31,12,'2025-05-14 00:00:00',12.15,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_31.pdf'),(32,12,'2025-05-14 00:00:00',5.75,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_32.pdf'),(33,12,'2025-05-14 00:00:00',48.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_33.pdf'),(34,12,'2025-05-14 00:00:00',5.00,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_34.pdf'),(35,12,'2025-05-14 00:00:00',25.20,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_35.pdf'),(36,12,'2025-05-15 00:00:00',13.55,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_36.pdf'),(37,12,'2025-05-15 00:00:00',45.00,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_37.pdf'),(38,12,'2025-05-16 00:00:00',2.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_38.pdf'),(39,12,'2025-05-16 00:00:00',7.50,''),(40,12,'2025-05-16 00:00:00',6.40,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_40.pdf'),(41,12,'2025-05-17 00:00:00',6.40,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_41.pdf'),(42,12,'2025-05-17 00:00:00',4.95,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico42.pdf'),(43,12,'2025-05-18 00:00:00',14.25,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_43.pdf'),(44,12,'2025-05-18 00:00:00',10.35,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_44.pdf'),(45,1,'2025-05-18 00:00:00',18.35,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_juanperez_45.pdf'),(46,12,'2025-05-18 00:00:00',9.75,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_46.pdf'),(47,12,'2025-05-18 00:00:00',2.20,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_47.pdf'),(48,12,'2025-05-18 00:00:00',9.75,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_48.pdf'),(49,12,'2025-05-18 00:00:00',10.10,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_49.pdf'),(50,2,'2025-05-18 00:00:00',7.80,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Mariagarcia_50.pdf'),(51,12,'2025-05-18 00:00:00',12.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_51.pdf'),(52,12,'2025-05-18 00:00:00',20.00,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_52.pdf'),(53,12,'2025-05-18 00:00:00',1.60,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_53.pdf'),(54,12,'2025-05-18 00:00:00',9.55,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Toniferico_54.pdf'),(55,2,'2025-05-19 00:00:00',12.50,'C:\\Users\\ajsan\\OneDrive\\Escritorio\\testpdf/factura_compra_Mariagarcia_55.pdf');
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_compra` (`id_compra`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id`) ON DELETE CASCADE,
  CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
INSERT INTO `detalle_compra` VALUES (2,5,6,3,2.10),(3,6,12,5,2.20),(4,7,4,2,0.60),(5,8,10,1,3.50),(6,9,6,1,2.10),(7,10,22,2,1.70),(8,11,28,5,1.85),(9,12,30,4,2.40),(10,13,17,10,0.85),(11,14,3,2,0.25),(12,15,5,3,1.20),(13,16,27,4,1.10),(14,17,12,6,2.20),(15,18,18,1,2.30),(16,19,22,5,1.70),(17,20,9,2,1.90),(18,21,3,2,0.25),(19,21,12,2,2.20),(20,21,6,1,2.10),(21,22,11,4,4.75),(22,22,21,1,3.40),(23,22,22,1,1.70),(24,23,5,1,1.20),(25,23,9,1,1.90),(26,24,8,1,3.80),(27,24,22,1,1.70),(28,24,29,3,4.99),(29,25,17,1,0.85),(30,25,27,1,1.10),(31,25,12,1,2.20),(32,26,30,5,2.40),(33,26,10,1,3.50),(34,26,9,3,1.90),(35,26,4,1,0.60),(36,27,8,2,3.80),(37,27,22,1,1.70),(38,27,29,1,4.99),(39,27,28,1,1.85),(40,27,3,5,0.25),(41,28,8,5,3.80),(42,28,22,1,1.70),(43,28,29,1,4.99),(44,29,2,1,0.40),(45,29,3,1,0.25),(46,29,23,1,1.25),(47,29,28,1,1.85),(48,30,29,1,4.99),(49,30,22,1,1.70),(50,30,21,1,3.40),(51,30,24,1,0.95),(52,30,26,1,4.20),(53,30,33,1,2.90),(54,30,37,1,1.30),(55,30,45,1,3.20),(56,30,49,1,5.80),(57,31,36,1,2.50),(58,31,45,1,3.20),(59,31,14,1,1.80),(60,31,38,1,3.20),(61,31,55,1,1.45),(62,32,47,5,1.15),(63,33,9,1,1.90),(64,33,10,2,3.50),(65,33,60,4,7.50),(66,33,59,3,2.60),(67,33,58,2,0.90),(68,34,36,2,2.50),(69,35,54,6,4.20),(70,36,25,1,1.20),(71,36,6,1,2.10),(72,36,12,1,2.20),(73,36,47,7,1.15),(74,37,60,6,7.50),(75,38,1,1,2.50),(76,39,60,1,7.50),(77,40,45,2,3.20),(78,41,8,1,3.80),(79,41,22,1,1.70),(80,41,58,1,0.90),(81,42,1,1,2.50),(82,42,2,1,0.40),(83,42,3,1,0.25),(84,42,4,1,0.60),(85,42,5,1,1.20),(86,43,1,5,2.50),(87,43,2,1,0.40),(88,43,3,1,0.25),(89,43,7,1,1.10),(90,44,45,1,3.20),(91,44,15,1,2.95),(92,44,54,1,4.20),(93,45,37,5,1.30),(94,45,38,1,3.20),(95,45,39,1,2.75),(96,45,40,1,3.90),(97,45,44,1,2.00),(98,46,56,3,3.25),(99,47,12,1,2.20),(100,48,58,1,0.90),(101,48,36,1,2.50),(102,48,42,1,2.40),(103,48,47,1,1.15),(104,48,57,1,2.80),(105,49,9,1,1.90),(106,49,10,1,3.50),(107,49,18,1,2.30),(108,49,30,1,2.40),(109,50,1,1,2.50),(110,50,2,5,0.40),(111,50,3,4,0.25),(112,50,18,1,2.30),(113,51,1,5,2.50),(115,53,2,4,0.40),(116,54,1,1,2.50),(117,54,24,1,0.95),(118,54,33,1,2.90),(119,54,38,1,3.20),(120,55,1,5,2.50);
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos_proveedor` (`id`) ON DELETE CASCADE,
  CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido`
--

LOCK TABLES `detalle_pedido` WRITE;
/*!40000 ALTER TABLE `detalle_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_proveedor`
--

DROP TABLE IF EXISTS `pedidos_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos_proveedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `fecha_pedido` date NOT NULL,
  `estado` enum('pendiente','recibido') DEFAULT 'pendiente',
  PRIMARY KEY (`id`),
  KEY `pedidos_proveedor_fk_usuario` (`id_usuario`),
  CONSTRAINT `pedidos_proveedor_fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_proveedor`
--

LOCK TABLES `pedidos_proveedor` WRITE;
/*!40000 ALTER TABLE `pedidos_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `categoria` varchar(50) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `iva` tinyint NOT NULL,
  `descuento` tinyint DEFAULT '0',
  `imagen_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Cuaderno A4 Rayado','Cuaderno formato A4 con 80 hojas rayadas y tapa blanda.','Cuadernos',2.50,35,21,0,'imagenes/cuaderno_a4.png'),(2,'Bolígrafo Azul BIC','Bolígrafo clásico de tinta azul con punta media.','Escritura',0.40,496,21,0,'imagenes/boligrafo_bic.png'),(3,'Lápiz HB','Lápiz de grafito HB con goma incorporada.','Escritura',0.25,300,21,0,'imagenes/lapiz_hb.png'),(4,'Goma de Borrar Blanca','Goma suave ideal para borrar lápiz sin dañar el papel.','Accesorios',0.60,200,21,0,'imagenes/goma_blanca.png'),(5,'Regla 15 cm Transparente','Regla plástica transparente de 15 centímetros.','Accesorios',1.20,150,21,0,'imagenes/regla_30cm.png'),(6,'Tijeras Escolares','Tijeras con punta redonda y mango ergonómico.','Accesorios',2.10,80,21,5,'imagenes/tijeras_escolares.png'),(7,'Pegamento en Barra 20g','Pegamento no tóxico en barra de 20 gramos.','Adhesivos',1.10,100,21,0,'imagenes/pegamento_barra.png'),(8,'Rotuladores de Colores (12)','Set de 12 rotuladores con colores surtidos.','Coloración',3.80,90,21,10,'imagenes/rotuladores.png'),(9,'Carpeta A4 de Gomas','Carpeta de cartón con solapas y gomas, varios colores.','Organización',1.90,75,21,0,'imagenes/carpeta_gomas.png'),(10,'Archivador Palanca A4','Archivador de cartón forrado con palanca metálica.','Organización',3.50,60,21,5,'imagenes/archivador.png'),(11,'Papel Fotocopia A4 80g','Resma de 500 hojas de papel blanco A4.','Papel',4.75,200,21,0,'imagenes/papel_a4.png'),(12,'Corrector en Cinta','Corrector de cinta seca para una corrección limpia.','Accesorios',2.20,85,21,0,'imagenes/corrector.png'),(13,'Marcador Fluorescente Amarillo','Resaltador amarillo de tinta fluorescente.','Coloración',0.95,110,21,0,'imagenes/resaltador.png'),(14,'Bloc de Notas Adhesivas','Paquete de notas adhesivas de colores (76x76 mm).','Notas',1.80,90,21,0,'imagenes/postits.png'),(15,'Compás Escolar','Compás metálico con mina y protector.','Instrumentos',2.95,40,21,5,'imagenes/compas.png'),(16,'Estuche Triple Cremallera','Estuche escolar con tres compartimentos y diseño moderno.','Estuches',5.90,30,21,10,'imagenes/estuche.png'),(17,'Sacapuntas Metálico','Sacapuntas de una hoja con cuerpo de metal.','Accesorios',0.85,150,21,0,'imagenes/sacapuntas.png'),(18,'Pack 5 Subcarpetas A4','Lote de 5 subcarpetas de cartulina en colores surtidos.','Organización',2.30,70,21,0,'imagenes/subcarpetas.png'),(19,'Agenda Escolar 2024-2025','Agenda diaria con tapa dura y espiral.','Agendas',6.99,25,21,15,'imagenes/agenda.png'),(20,'Pinceles Escolares (6)','Set de 6 pinceles con mango corto y cerdas suaves.','Coloración',2.50,50,21,0,'imagenes/pinceles.png'),(21,'Bloc de Dibujo A3','Bloc con 20 hojas blancas de papel grueso formato A3.','Papel',3.40,35,21,0,'imagenes/bloc_a3.png'),(22,'Cartulina de Colores (10)','Pack de 10 cartulinas de colores vivos.','Papel',1.70,90,21,0,'imagenes/cartulinas.png'),(23,'Rotulador Permanente Negro','Marcador permanente punta media, resistente al agua.','Escritura',1.25,100,21,0,'imagenes/permanente.png'),(24,'Cinta Adhesiva Transparente','Rollo de cinta adhesiva de 33 metros.','Adhesivos',0.95,130,21,0,'imagenes/cinta.png'),(25,'Notas Adhesivas Índice','Notas adhesivas en tiras de colores para marcar páginas.','Notas',1.20,75,21,0,'imagenes/indice.png'),(26,'Calculadora Básica','Calculadora de 8 dígitos con pantalla LCD.','Instrumentos',4.20,20,21,5,'imagenes/calculadora.png'),(27,'Borrador Tinta y Lápiz','Goma doble para borrar tinta y grafito.','Accesorios',1.10,95,21,0,'imagenes/goma_doble.png'),(28,'Portaminas 0.5 mm','Portaminas con goma y clip, recargable.','Escritura',1.85,65,21,0,'imagenes/portaminas.png'),(29,'Estuche Lápices de Colores (24)','Caja de 24 lápices de colores de madera.','Coloración',4.99,45,21,10,'imagenes/lapices_colores.png'),(30,'Caja Organizadora Pequeña','Caja plástica para clips, gomas y otros accesorios.','Organización',2.40,50,21,0,'imagenes/caja_organizador.png'),(31,'Cuaderno A5 Cuadriculado','Cuaderno formato A5 con 100 hojas cuadriculadas y tapa dura.','Cuadernos',2.30,140,21,0,'imagenes/cuaderno_a5.png'),(32,'Bolígrafo Negro Pilot','Bolígrafo de tinta líquida negra con grip ergonómico.','Escritura',1.20,180,21,0,'imagenes/boligrafo_pilot.png'),(33,'Lápices de Colores (12)','Set de 12 lápices de colores surtidos.','Coloración',2.90,95,21,0,'imagenes/lapices_colores_12.png'),(34,'Goma de Borrar Milan','Goma sintética de alta calidad, suave y no abrasiva.','Accesorios',0.70,210,21,0,'imagenes/goma_milan.png'),(35,'Regla Flexible 20 cm','Regla de plástico flexible resistente a roturas.','Accesorios',1.00,130,21,0,'imagenes/regla_flexible.png'),(36,'Tijeras de Precisión','Tijeras pequeñas con hoja fina para recorte detallado.','Accesorios',2.50,60,21,5,'imagenes/tijeras_precision.png'),(37,'Pegamento Líquido 100ml','Pegamento líquido con aplicador de precisión.','Adhesivos',1.30,90,21,0,'imagenes/pegamento_liquido.png'),(38,'Rotuladores Pizarra Blanca (4)','Set de 4 rotuladores para pizarra blanca.','Coloración',3.20,50,21,10,'imagenes/rotuladores_pizarra.png'),(39,'Carpeta Clasificadora A4','Carpeta con separadores de colores, 12 compartimentos.','Organización',2.75,70,21,0,'imagenes/carpeta_clasificadora.png'),(40,'Archivador Escolar A4','Archivador con diseño juvenil, palanca y lomo ancho.','Organización',3.90,55,21,0,'imagenes/archivador_escolar.png'),(41,'Papel Milimetrado A4','Bloc con hojas A4 de papel milimetrado.','Papel',2.80,85,21,0,'imagenes/papel_milimetrado.png'),(42,'Cinta Correctora Retráctil','Corrector en cinta con sistema retráctil.','Accesorios',2.40,70,21,0,'imagenes/corrector_retractil.png'),(43,'Marcadores Fluorescentes (4)','Set de 4 resaltadores en colores neón.','Coloración',3.10,75,21,0,'imagenes/resaltadores_colores.png'),(44,'Notas Adhesivas Grandes','Notas adhesivas de gran tamaño (100x100 mm).','Notas',2.00,80,21,0,'imagenes/notas_grandes.png'),(45,'Compás con Adaptador','Compás con accesorio para sujetar bolígrafo o lápiz.','Instrumentos',3.20,35,21,5,'imagenes/compas_adaptador.png'),(46,'Estuche Escolar de Tela','Estuche resistente con cierre y compartimentos internos.','Estuches',4.80,40,21,10,'imagenes/estuche_tela.png'),(47,'Sacapuntas con Depósito','Sacapuntas con depósito de virutas y tapa.','Accesorios',1.15,120,21,0,'imagenes/sacapuntas_deposito.png'),(48,'Pack 10 Fundas Plásticas A4','Juego de 10 fundas transparentes perforadas.','Organización',2.10,100,21,0,'imagenes/fundas_a4.png'),(49,'Agenda Semanal 2025','Agenda semanal con espacio para notas y contactos.','Agendas',5.80,30,21,10,'imagenes/agenda_semanal.png'),(50,'Paleta de Acuarelas Escolar','Paleta de 12 colores básicos con pincel.','Coloración',3.50,50,21,0,'imagenes/acuarelas.png'),(51,'Carpeta con Clip A4','Carpeta con clip metálico para sujetar hojas.','Organización',1.95,65,21,0,'imagenes/carpeta_clip.png'),(52,'Taco de Notas Multicolor','Taco de hojas sueltas de colores surtidos.','Notas',1.75,90,21,0,'imagenes/taco_notas.png'),(53,'Bolígrafo Borrable Azul','Bolígrafo de tinta azul con borrador incluido.','Escritura',2.10,85,21,0,'imagenes/boligrafo_borrable.png'),(54,'Bloc de Bocetos A4','Bloc de 50 hojas lisas para dibujo artístico.','Papel',4.20,40,21,0,'imagenes/bloc_bocetos.png'),(55,'Pegamento en Gel','Pegamento en formato gel, ideal para trabajos manuales.','Adhesivos',1.45,70,21,0,'imagenes/pegamento_gel.png'),(56,'Marcadores Permanentes (3)','Set de 3 marcadores permanentes de colores.','Escritura',3.25,60,21,0,'imagenes/marcadores_permanentes.png'),(57,'Grapadora Mini','Grapadora pequeña con caja de grapas.','Accesorios',2.80,55,21,0,'imagenes/grapadora_mini.png'),(58,'Clips Metálicos (100 uds)','Caja de 100 clips metálicos tamaño estándar.','Accesorios',0.90,150,21,0,'imagenes/clips.png'),(59,'Separadores de Cartón A4','Juego de 10 separadores con pestañas.','Organización',2.60,70,21,0,'imagenes/separadores.png'),(60,'Calculadora Científica','Calculadora con funciones científicas básicas.','Instrumentos',7.50,25,21,5,'imagenes/calculadora_cientifica.png');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `rol` enum('cliente','admin') NOT NULL DEFAULT 'cliente',
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'juanperez','juan.perez@example.com','juan123','600123456','cliente'),(2,'Mariagarcia','maria.garcia@example2.com','maria123','611234567','cliente'),(3,'Carlos','carlos.lopez@example.com','carlos123','622345678','cliente'),(4,'laurafernandez','laura.fernandez@example.com','laura123','633456789','cliente'),(5,'andresgomez','andres.gomez@example.com','andres123','644567890','cliente'),(6,'sofiaramirez','sofia.ramirez@example.com','sofia123','655678901','cliente'),(7,'diegosanchez','diego.sanchez@example.com','diego123','666789012','cliente'),(8,'alejandramoreno','alejandra.moreno@example.com','alejandra123','677890123','cliente'),(9,'ricardotorres','ricardo.torres@example.com','ricardo123','688901234','cliente'),(10,'veronicacastro','veronica.castro88@gmail.com','veronica123','699012345','cliente'),(11,'admin','admin@admin.com','admin123','000000000','admin'),(12,'Toniferico','tonifero@gmail.com','tonii18','644877298','cliente');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `estrellas` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `valoraciones_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `producto_id` int NOT NULL,
  `unidades_compradas` int NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ventas_ibfk_1` (`producto_id`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,36,1,'2025-05-14 09:45:36'),(2,45,1,'2025-05-14 09:45:36'),(3,14,1,'2025-05-14 09:45:36'),(4,38,1,'2025-05-14 09:45:36'),(5,55,1,'2025-05-14 09:45:36'),(6,47,5,'2025-05-14 09:47:20'),(7,9,1,'2025-05-14 09:52:44'),(8,10,2,'2025-05-14 09:52:44'),(9,60,4,'2025-05-14 09:52:44'),(10,59,3,'2025-05-14 09:52:44'),(11,58,2,'2025-05-14 09:52:45'),(12,36,2,'2025-05-14 10:42:14'),(13,54,6,'2025-05-14 13:43:54'),(14,25,1,'2025-05-14 22:45:57'),(15,6,1,'2025-05-14 22:45:57'),(16,12,1,'2025-05-14 22:45:57'),(17,47,7,'2025-05-14 22:45:57'),(18,60,6,'2025-05-15 11:04:15'),(19,1,1,'2025-05-15 22:25:14'),(20,60,1,'2025-05-16 10:43:55'),(21,45,2,'2025-05-16 10:44:15'),(22,8,1,'2025-05-17 16:08:25'),(23,22,1,'2025-05-17 16:08:25'),(24,58,1,'2025-05-17 16:08:25'),(25,1,1,'2025-05-17 16:46:49'),(26,2,1,'2025-05-17 16:46:49'),(27,3,1,'2025-05-17 16:46:49'),(28,4,1,'2025-05-17 16:46:49'),(29,5,1,'2025-05-17 16:46:49'),(30,1,5,'2025-05-18 13:01:27'),(31,2,1,'2025-05-18 13:01:27'),(32,3,1,'2025-05-18 13:01:27'),(33,7,1,'2025-05-18 13:01:27'),(34,45,1,'2025-05-18 13:07:40'),(35,15,1,'2025-05-18 13:07:40'),(36,54,1,'2025-05-18 13:07:40'),(37,37,5,'2025-05-18 15:30:54'),(38,38,1,'2025-05-18 15:30:54'),(39,39,1,'2025-05-18 15:30:54'),(40,40,1,'2025-05-18 15:30:54'),(41,44,1,'2025-05-18 15:30:54'),(42,56,3,'2025-05-18 15:42:15'),(43,12,1,'2025-05-18 15:45:06'),(44,58,1,'2025-05-18 15:56:20'),(45,36,1,'2025-05-18 15:56:20'),(46,42,1,'2025-05-18 15:56:20'),(47,47,1,'2025-05-18 15:56:20'),(48,57,1,'2025-05-18 15:56:20'),(49,9,1,'2025-05-18 17:47:01'),(50,10,1,'2025-05-18 17:47:01'),(51,18,1,'2025-05-18 17:47:01'),(52,30,1,'2025-05-18 17:47:01'),(53,1,1,'2025-05-18 17:49:34'),(54,2,5,'2025-05-18 17:49:34'),(55,3,4,'2025-05-18 17:49:34'),(56,18,1,'2025-05-18 17:49:34'),(57,1,5,'2025-05-18 18:12:25'),(59,2,4,'2025-05-18 18:36:06'),(60,1,1,'2025-05-18 18:36:38'),(61,24,1,'2025-05-18 18:36:38'),(62,33,1,'2025-05-18 18:36:38'),(63,38,1,'2025-05-18 18:36:38'),(64,1,5,'2025-05-18 23:03:13');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-19  1:53:08
