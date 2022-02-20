UPDATE `employees`
SET `salary`=`salary`+(0.1*`salary`)
WHERE (`id`>0);

SELECT `salary` FROM `employees`;