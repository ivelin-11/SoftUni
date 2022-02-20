CREATE DATABASE `people`;

USE `people`;

CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(3,2),
`weight` DOUBLE(5,2),
`gender`  CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people`(`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)
VALUES (1,'Ivelin',NULL,2.22,111.12,'m','2002-04-26',NULL),
(2,'Ivelin',NULL,2.22,1.12,'m','2002-04-26',NULL),
(3,'Ivelin',NULL,2.22,11.12,'m','2002-04-26',NULL),
(4,'Ivelin',NULL,2.22,111,'m','2002-04-26',NULL),
(5,'Ivelin',NULL,2.22,111.1,'m','2002-04-26',NULL);


