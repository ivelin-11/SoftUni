SELECT IF(CHAR_LENGTH(p.`description`)>30,
CONCAT(SUBSTRING(p.`description`,1,30),'...'),p.`description`) AS `summary`,
p.`date`
 FROM `photos` AS p
WHERE  DAY(p.`date`)=10
ORDER BY p.`date` DESC;