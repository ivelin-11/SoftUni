CREATE TABLE `passports`(
`passport_id` INT PRIMARY KEY UNIQUE NOT NULL,
`passport_number` VARCHAR(9) UNIQUE NOT NULL
);

CREATE  TABLE `people`(
`person_id` INT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
`first_name` VARCHAR(30) NOT NULL,
`salary`  DECIMAL(9,2) NOT NULL,
`passport_id` INT UNIQUE NOT NULL,
CONSTRAINT FOREIGN KEY `fk_people_passports` (`passport_id`)
REFERENCES `passports`(`passport_id`)
);

INSERT INTO `passports` (`passport_id`, `passport_number`) VALUES ('101', 'N34FG21B'),
 ('102', 'K65LO4R7'),
('103', 'ZE657QP2');

INSERT INTO `people` (`person_id`, `first_name`, `salary`, `passport_id`) VALUES ('1', 'Roberto', '43300', '102'),
 ('2', 'Tom', '56100', '103'),
 ('3', 'Yana', '60200', '101');


SELECT *
 FROM `people`  AS pe 
JOIN `passports` AS pa ON pe.`passport_id`=pa.`passport_id`;