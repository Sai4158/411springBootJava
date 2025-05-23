CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@psu.edu'),
	(2,'Emma','Baumgarten','emma@psu.edu'),
	(3,'Avani','Gupta','avani@psu.edu'),
	(4,'Yuri','Petrov','yuri@psu.edu'),
	(5,'Juan','Vega','juan@psu.edu'),
    (6,'Kenneth','Wolf','k.wolf@psu.edu'),
	(7,'Luke','Hanrahan','luke.hanrahan@psu.edu'),
	(8,'Nicholas','Kazanjian','n.kazanjian@psu.edu'),
	(9,'Raymond','Fogle','ray.fogle@psu.edu'),
	(10,'Stephanie','Milovich','steph.milovich@psu.edu');

