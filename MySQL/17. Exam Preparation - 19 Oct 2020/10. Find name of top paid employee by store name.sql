DELIMITER $$
SET `sql_mode`='';
CREATE FUNCTION udf_top_paid_employee_by_store(`store_name` VARCHAR(50))

RETURNS TEXT
DETERMINISTIC
BEGIN
DECLARE fname TEXT;
DECLARE mname CHAR(1);
DECLARE lname TEXT;
DECLARE diff INT;

SET fname:=(SELECT e.first_name
FROM `stores` AS s
JOIN  `employees` AS e ON e.`store_id`=s.`id` 
WHERE s.`id`=e.`store_id`  AND s.`name`=`store_name` 
GROUP BY s.`id`
HAVING MAX(e.`salary`));

SET mname:=(SELECT e.middle_name
FROM `stores` AS s
JOIN  `employees` AS e ON e.`store_id`=s.`id` 
WHERE s.`id`=e.`store_id`  AND s.`name`=`store_name`
GROUP BY s.`id`
HAVING MAX(e.`salary`));

SET lname:=(SELECT e.last_name
FROM `stores` AS s
JOIN  `employees` AS e ON e.`store_id`=s.`id` 
WHERE s.`id`=e.`store_id`  AND s.`name`=`store_name`
GROUP BY s.`id`
HAVING MAX(e.`salary`));

SET diff:=TIMESTAMPDIFF(YEAR,(SELECT e.`hire_date`
FROM `stores` AS s
JOIN  `employees` AS e ON e.`store_id`=s.`id` 
WHERE s.`id`=e.`store_id`  AND s.`name`=`store_name`  
GROUP BY s.`id`
HAVING MAX(e.`salary`)),'2020-10-18');

RETURN  CONCAT(COCNCAT_WS(' 'fname,mname)'. ',lname
,' ', 'works in store for ',diff, ' years');

END$$


DELIMITER ;

SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';
SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';

