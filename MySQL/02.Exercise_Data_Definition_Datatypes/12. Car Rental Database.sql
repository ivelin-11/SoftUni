CREATE  DATABASE `car_rental`;

USE `car_rental`;

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(20) NOT NULL,
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE,
`monthly_rate` DOUBLE,
`weekend_rate` DOUBLE
);

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT ,
`plate_number` VARCHAR(10) NOT NULL,
`make` VARCHAR(15) NOT NULL,
`model` VARCHAR(15) NOT NULL,
`car_year` INT NOT NULL, 
`category_id` INT NOT NULL, 
`doors` INT,
`picture` BLOB, 
`car_condition` TEXT, 
`available` BOOLEAN
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20),
`last_name` VARCHAR(20),
`title` VARCHAR(20),
`notes` TEXT
);

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`drive_licence_number` INT NOT NULL,
`full_name` VARCHAR(40),
`address` VARCHAR(30),
`city` VARCHAR(10),
`zip_code` VARCHAR(10),
`notes`TEXT
);

CREATE TABLE `rental_orders`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL, 
`customer_id` INT NOT NULL, 
`car_id` INT NOT NULL, 
`car_condition` TEXT, 
`tank_level` INT, 
`kilometrage_start` INT , 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date` DATE, 
`end_date` DATE, 
`total_days` INT,
 `rate_applied` DOUBLE, 
 `tax_rate` DOUBLE, 
 `order_status` VARCHAR(10), 
 `notes` TEXT
);

INSERT INTO `categories`
VALUES ('1','category test','1.0','2.0','3.0','4.0'),
 ('2','category test','1.0','2.0','3.0','4.0'),
 ('3','category test','1.0','2.0','3.0','4.0');

INSERT INTO `cars`
VALUES ('1','number','make','model',2001,1,4,NULL,NULL,1),
('2','number','make','model',2001,1,4,NULL,NULL,1),
('3','number','make','model',2001,1,4,NULL,NULL,1);

INSERT INTO `employees` 
VALUES ('1','name1','name2','title',NULL),
('2','name1','name2','title',NULL),
('3','name1','name2','title',NULL);

INSERT INTO `customers`
VALUES  ('1','111','full name','adress','city','zip code',NULL),
('2','111','full name','adress','city','zip code',NULL),
('3','111','full name','adress','city','zip code',NULL);

INSERT INTO `rental_orders` 
VALUES ('1','1','1','1',NULL,'50','1000','2000','3000','2010-12-11','2010-12-11',3,1.1,2.1,'order',NULL),
('2','1','1','1',NULL,'50','1000','2000','3000','2010-12-11','2010-12-11',3,1.1,2.1,'order',NULL),
('3','1','1','1',NULL,'50','1000','2000','3000','2010-12-11','2010-12-11',3,1.1,2.1,'order',NULL);
