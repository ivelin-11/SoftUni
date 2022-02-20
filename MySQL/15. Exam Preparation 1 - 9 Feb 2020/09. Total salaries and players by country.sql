SELECT c.`name`,
COUNT(p.`id`) AS `total_count_of_players`,
SUM(p.`salary`) AS  `total_sum_of_salaries`
FROM `players` AS p
RIGHT JOIN `teams` AS t ON t.`id`=p.`team_id`
RIGHT JOIN `stadiums` AS s ON s.`id`=t.`stadium_id`
RIGHT JOIN `towns` AS tow ON tow.`id`=s.`town_id`
RIGHT JOIN `countries` AS c ON c.`id`=tow.`country_id`
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC,c.`name`;