SELECT `first_name`,`last_name` FROM `employees`
WHERE `first_name` LIKE 'Sa%' ORDER BY `employee_id`;

SELECT `first_name`,`last_name` FROM `employees`
WHERE `first_name` REGEXP('^Sa')
ORDER BY `employee_id`;

-- SELECT `first_name`,`last_name` FROM `employees`
-- WHERE LOWER(`first_name`) LIKE 'sa%' ORDER BY `employee_id`;