SELECT  CONCAT_WS(' ',`first_name`,`middle_name`,`last_name`) AS `Full Name` FROM `employees` e
WHERE e.`salary` IN(25000,14000,12500,23600);