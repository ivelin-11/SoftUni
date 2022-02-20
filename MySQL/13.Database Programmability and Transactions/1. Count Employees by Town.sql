DELIMITER $$
CREATE FUNCTION `ufn_count_employees_by_town` (town_name VARCHAR(40))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE e_count INT;
SET e_count:=(SELECT COUNT(*) AS `count` FROM `employees` AS e
JOIN `addresses`  AS a ON a.`address_id`=e.`address_id`
JOIN `towns` as t ON t.`town_id`=a.`town_id`
WHERE t.`name`=`town_name`);
RETURN   e_count;
END$$

DELIMITER ;
SELECT  `ufn_count_employees_by_town`('Sofia');