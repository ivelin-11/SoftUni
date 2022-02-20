
DELIMITER $$

-- var 1 
CREATE PROCEDURE `usp_raise_salary_by_id` (id INT)
BEGIN
IF((SELECT COUNT(*) FROM `employees` AS e WHERE e.`employee_id`=`id`) = 1) THEN
UPDATE `employees` AS e
JOIN  `departments` AS d ON d.`department_id`=e.`department_id`
SET `salary`=`salary`+(`salary`*0.05)
WHERE e.`employee_id` = id;
END IF;
END$$


-- var2 
CREATE PROCEDURE `usp_raise_salary_by_id` (id INT)
BEGIN
START TRANSACTION;
IF((SELECT COUNT(*) FROM `employees` AS e WHERE e.`employee_id`=`id`) <> 1) THEN
ROLLBACK;
ELSE 
UPDATE `employees` AS e
JOIN  `departments` AS d ON d.`department_id`=e.`department_id`
SET `salary`=`salary`+(`salary`*0.05)
WHERE e.`employee_id` = id;
END IF;
END$$

DELIMITER ;

-- local test 
CALL `usp_raise_salary_by_id`(1);
SELECT * FROM `employees` AS e WHERE e.`employee_id`=1;