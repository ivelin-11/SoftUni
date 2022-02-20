USE `minions`;


-- PRIMARY KEY constraint is not changed unless we drop it 
ALTER TABLE `towns`
CHANGE `town_id` `id` INT AUTO_INCREMENT;

-- in the judge only below one
ALTER TABLE `minions` 
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns FOREIGN KEY `minions`(`town_id`)
REFERENCES `towns`(`id`);