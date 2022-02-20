SELECT e.`employee_id`,e.`first_name`,IF(YEAR(p.`start_date`)>=2005,NULL,p.`name`) AS `project_name`
FROM `employees` AS e
JOIN `employees_projects` AS ep ON ep.`employee_id`=e.`employee_id`
RIGHT JOIN `projects` AS  p ON p.`project_id`=ep.`project_id`
WHERE ep.`employee_id`=24
ORDER BY `project_name`;