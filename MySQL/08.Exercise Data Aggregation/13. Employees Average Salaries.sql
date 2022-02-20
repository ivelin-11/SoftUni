SELECT `department_id`,IF(`department_id`=1,AVG(`salary`)+5000,AVG(`salary`)) AS `avg_salary`
FROM `employees`
WHERE `salary`>30000 AND `manager_id`!=41
GROUP BY `department_id`
ORDER BY `department_id`;

-- -------------------------
 
CREATE TABLE `salaries_than_30000` AS 
(SELECT *
FROM `employees`
WHERE `salary`>30000);

ALTER TABLE `salaries_than_30000`
ADD CONSTRAINT PRIMARY KEY  (`employee_id`);

DELETE FROM  `salaries_than_30000`
WHERE `manager_id`=42 AND `employee_id`>0;

UPDATE `salaries_than_30000`
SET `salary`=`salary`+5000
WHERE `employee_id`>0 AND `department_id`=1;


SELECT `department_id`,AVG(`salary`) AS `avg_salary`
FROM `salaries_than_30000`
GROUP BY `department_id`
ORDER BY `department_id`;