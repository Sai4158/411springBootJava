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
	(1,'Stephen','Em','Stephen.Em@psu.edu'),
	(2,'Luke','Hanrahan','Luke.Hanrahan@psu.edu'),
	(3,'Nicholas','Kazanjian','Nicholas.Kazanjian@psu.edu'),
	(4,'Stephanie','Milovich','Stephanie.Milovich@psu.edu'),
	(5,'Kenneth','Wolf','Kenneth.Wolf@psu.edu');employeeemployee