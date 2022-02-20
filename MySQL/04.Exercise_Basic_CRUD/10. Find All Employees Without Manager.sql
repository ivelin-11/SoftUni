SELECT `first_name`,`last_name` FROM `employees`
WHERE `manager_id` IS NULL;
-- with = NULL does not work