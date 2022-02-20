SELECT e.`employee_id`,e.`first_name`
FROM `employees` AS e 
LEFT JOIN `employees_projects` AS ep
ON ep.`employee_id`=e.`employee_id`
WHERE ep.`employee_id` is NULL
ORDER BY e.`employee_id`DESC LIMIT 3;

SELECT e.`employee_id`,e.`first_name`
FROM `employees` AS e 
LEFT JOIN `employees_projects` AS ep
ON ep.`employee_id`=e.`employee_id`
WHERE ep.`project_id` is NULL
ORDER BY e.`employee_id`DESC LIMIT 3;