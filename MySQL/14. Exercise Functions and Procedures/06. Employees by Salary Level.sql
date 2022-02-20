DELIMITER $$
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`salary_level` VARCHAR(7))
BEGIN
    SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    WHERE (e.`salary` < 30000 AND `salary_level`= 'Low')
        OR (e.`salary` >= 30000 AND e.`salary` <= 50000 AND `salary_level` = 'Average')
        OR (e.`salary` > 50000 AND `salary_level` = 'High')
    ORDER BY e.`first_name` DESC, e.`last_name` DESC;
END $$


-- ---------------------------------------------------
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DOUBLE(19,4))
RETURNS VARCHAR(7)
DETERMINISTIC
RETURN (
    CASE 
        WHEN salary < 30000 THEN 'Low'
        WHEN salary <= 50000 THEN 'Average'
        ELSE 'High'
    END
);

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
    SELECT e.first_name, e.last_name
    FROM `employees` AS e
    WHERE ufn_get_salary_level(e.salary) = salary_level
    ORDER BY e.first_name DESC, e.last_name DESC;
END $$

DELIMITER ;
CALL `usp_get_employees_by_salary_level`('High');

