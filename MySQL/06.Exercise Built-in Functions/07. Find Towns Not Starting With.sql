SELECT `town_id`,`name` FROM `towns` 
WHERE `name` REGEXP('^(?![RBD])') 
ORDER BY `name`;

SELECT `town_id`,`name` FROM `towns` 
WHERE LEFT(`name`,1) NOT IN('B','R','D')
ORDER BY `name`;

SELECT `town_id`,`name` FROM `towns` 
WHERE SUBSTRING(`name`,1,1) NOT IN('B','R','D')
ORDER BY `name`;

-- we can use and or for the two top ones way but it doesn't make sense 