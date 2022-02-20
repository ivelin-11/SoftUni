CREATE TABLE `directors` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `genres` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(30) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(30) NOT NULL,
    `notes` TEXT
);


CREATE TABLE `movies` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(30) NOT NULL,
    `director_id` INT NOT NULL,
    `copyright_year` YEAR,
    `length` TIME,
    `genre_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `rating` INT,
    `notes` TEXT
);


INSERT INTO `directors`(`director_name`,`notes`)
VALUES ('director 1',NULL),
('director 2',NULL),
('director 3',NULL),
('director 4',NULL),
('director 5',NULL);

INSERT INTO `genres`(`genre_name`,`notes`)
VALUES ('genre 1',NULL),
('genre 2',NULL),
('genre 3',NULL),
('genre 4',NULL),
('genre 5',NULL);

INSERT INTO `categories`(`category_name`,`notes`)
VALUES ('category 1',NULL),
('category 2',NULL),
('category 3',NULL),
('category 4',NULL),
('category 5',NULL);


INSERT INTO `movies`(`title`,`director_id`,`copyright_year`,`length`,`genre_id`,`category_id`,
`rating`,`notes`)
VALUES ('film 1',5,NULL,NULL,1,5,NULL,NULL),
 ('film 2',4,NULL,NULL,2,4,NULL,NULL),
 ('film 3',3,NULL,NULL,3,3,NULL,NULL),
 ('film 4',2,NULL,NULL,4,2,NULL,NULL),
 ('film 5',1,NULL,NULL,5,1,NULL,NULL);