USE `minions`;

-- it is not needed add id beacuse its auto increment
-- but in this case jduge wants it :)


-- first into towns because its foreign key 
INSERT INTO `towns`(`id`,`name`)
VALUES ('1','Sofia'),
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO `minions` (`id`,`name`,`age`,`town_id`)
VALUES (1,'Kevin',22,'1'),
(2,'Bob',15,'3'),
(3,'Steward',NULL,'2');

  