SELECT CONCAT_WS(' ',e.`first_name`,e.`last_name`) AS `Full_name`,
s.`name` AS `Store_name`,
a.`name` AS `address`,
e.`salary`
FROM `employees` AS e
JOIN `stores` AS s ON s.`id`=e.`store_id`
JOIN `addresses` AS a ON a.`id`=s.`address_id`
WHERE e.`salary`<4000 AND
LOCATE('5',a.`name`)>0 AND
CHAR_LENGTH(s.`name`)>5 AND
RIGHT(e.`last_name`,1) = 'n';