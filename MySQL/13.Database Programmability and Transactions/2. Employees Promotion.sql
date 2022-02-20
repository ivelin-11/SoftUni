DELIMITER $$
CREATE PROCEDURE `usp_raise_salaries` (department_name VARCHAR(40))
BEGIN
UPDATE `employees` AS e
JOIN  `departments` AS d ON d.`department_id`=e.`department_id`
SET `salary`=`salary`+(`salary`*0.05)
WHERE d.`name` LIKE department_name;
END$$

DELIMITER ;

CALL `usp_raise_salaries`('Finance');
SELECT e.`first_name`,e.`salary` FROM employees AS e
JOIN  `departments` AS d ON d.`department_id`=e.`department_id`
WHERE d.`name` LIKE 'Finance'
ORDER BY e.`first_name`,e.`salary`;