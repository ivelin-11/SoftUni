SELECT AVG(`salary`) AS `min_average_salary`
FROM `employees`
GROUP BY `department_id` 
ORDER BY `min_average_salary` ASC LIMIT 1;