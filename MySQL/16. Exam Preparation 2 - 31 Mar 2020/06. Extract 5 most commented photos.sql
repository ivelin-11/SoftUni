SELECT p.`id`,
p.`date` AS `date_and_time`,
p.`description`,
COUNT(c.`photo_id`) AS  `commentsCount`
FROM `photos` AS p
JOIN `comments` AS c ON c.`photo_id`=p.`id`
GROUP BY c.`photo_id`
ORDER BY `commentsCount` DESC,c.`photo_id` ASC
LIMIT 5;
