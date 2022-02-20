CREATE TABLE `clients`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`client_name` VARCHAR(100) NOT NULL
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`project_id` INT
);

CREATE TABLE `projects`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`client_id` INT UNIQUE,
 CONSTRAINT FOREIGN KEY `fk_projects_cients` (`client_id`)
REFERENCES `clients`(`id`),
`project_lead_id` INT,
CONSTRAINT FOREIGN KEY `fk_projects_employees` (`project_lead_id`)
REFERENCES `employees`(`id`)
);

ALTER TABLE `employees`
ADD CONSTRAINT FOREIGN KEY `fk_employees_projects` (`project_id`)
REFERENCES `projects`(`id`);