UPDATE `employees` 
SET `salary`=`salary`+100
WHERE `id`>0 AND `job_title`='Manager';

SELECT `salary` FROM `employees`;