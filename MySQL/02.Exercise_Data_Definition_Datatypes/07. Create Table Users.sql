USE `people`;

CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26),
`profile_picture` BLOB,
`last_login_time` DATE,
`is_deleted` BOOLEAN
);

INSERT INTO `users`(`username`,`password`,`profile_picture`,
`last_login_time`,`is_deleted`)
VALUES ('a','123',NULL,NULL,FALSE),
('b','123',NULL,NULL,FALSE),
('c','123',NULL,NULL,FALSE),
('d','123',NULL,NULL,FALSE),
('e','123',NULL,NULL,FALSE);
