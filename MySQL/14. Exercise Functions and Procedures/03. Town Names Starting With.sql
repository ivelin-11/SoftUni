DELIMITER $$

CREATE PROCEDURE `usp_get_towns_starting_with`(`string_start_with` VARCHAR(10))
BEGIN
SELECT t.`name` AS `town_name` FROM `towns`AS t
WHERE SUBSTRING(t.`name`,1,CHAR_LENGTH(`string_start_with`)) LIKE `string_start_with`
 ORDER BY `town_name`;
END$$

CREATE PROCEDURE `usp_get_towns_starting_with`(`string_start_with` VARCHAR(10))
BEGIN
SELECT t.`name` AS `town_name` FROM `towns`AS t
WHERE t.`name` LIKE CONCAT(`string_start_with`,'%')
 ORDER BY `town_name`;
END$$

DELIMITER ;

CALL `usp_get_towns_starting_with`('b');