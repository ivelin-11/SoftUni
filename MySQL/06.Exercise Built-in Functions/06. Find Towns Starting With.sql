SELECT `town_id`,`name` FROM `towns`
WHERE LEFT(`name`,1) IN ('B','M','K','E') ORDER BY `name`;

SELECT `town_id`,`name` FROM `towns`
WHERE SUBSTRING(`name`,1,1) IN ('B','M','K','E') ORDER BY `name`;

SELECT `town_id`,`name` FROM `towns`
WHERE `name`  REGEXP ('^[BMKE]') ORDER BY `name`;

SELECT `town_id`,`name` FROM `towns`
WHERE `name`  LIKE ('B%') OR  
`name`  LIKE ('K%') OR
`name`  LIKE ( 'M%')  OR
`name`  LIKE ('E%') 
 ORDER BY `name`;

