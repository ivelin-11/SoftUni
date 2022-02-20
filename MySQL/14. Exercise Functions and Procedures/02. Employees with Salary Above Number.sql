DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above(`minimum_salary` DECIMAL(12,4) )
BEGIN
SELECT e.`first_name`,e.`last_name`
FROM `employees` AS e
WHERE e.`salary`>=`minimum_salary`
ORDER BY e.`first_name`,e.`last_name`,e.`employee_id`;
END$$
DELIMITER ;

CALL `usp_get_employees_salary_above`(45000);