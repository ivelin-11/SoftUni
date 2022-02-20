CREATE DATABASE `soft_uni`;

USE `soft_uni`;

CREATE TABLE `towns` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `adress_text` TEXT ,
    `town_id` INT,
    CONSTRAINT `fk_addresses_towns` FOREIGN KEY (`town_id`)
        REFERENCES `towns` (`id`)
);

CREATE TABLE `departments` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30)
);

CREATE TABLE `employees` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(20) NOT NULL,
    `middle_name` VARCHAR(20) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `job_title` VARCHAR(20) NOT NULL,
    `department_id` INT NOT NULL,
    CONSTRAINT `fk_employees_departments` FOREIGN KEY (`department_id`)
        REFERENCES `departments` (`id`),
    `hire_date` DATE,
    `salary` DOUBLE,
    `address_id` INT NOT NULL,
    CONSTRAINT `fk_employees_addresses` FOREIGN KEY (`address_id`)
        REFERENCES `addresses` (`id`)
);

INSERT INTO `towns`
VALUES ('1','Sofia'),
('2','Plovdiv'),
('3','Varna'),
('4','Burgas');

INSERT INTO `departments`
VALUES ('1','Engineering'), 
 ('2','Sales'),
 ('3','Marketing'),
 ('4','Software Development'),
 ('5','Quality Assurance');

INSERT INTO `addresses`
VALUES (1,'Sofia',1),
(2,'Plovdiv',2),
(3,'Varna',3),
(4,'Burgas',4);


INSERT INTO `employees`
VALUES ('1','Ivan','Ivanov','Ivanov','.NET Developer','4','2013-02-01',3500.00,'1'),
('2','Petar','Petrov','Petrov','Senior Engineer','1','2004-03-02',4000.00,'2'),
('3','Maria','Petrova','Ivanova','Intern','5','2016-08-28',525.25,'3'),
('4','Georgi','Terziev ','Ivanov','CEO','2','2007-12-09',3000.00,'4'),
('5','Peter','Pan','Pan','Intern','3','2016-08-28',599.88,'1');