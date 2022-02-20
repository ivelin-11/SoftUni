SELECT MAX(sd.`speed`) AS `max_speed` ,
tow.`name`FROM `players` AS p
RIGHT JOIN `skills_data` AS sd ON p.`skills_data_id`=sd.`id`
RIGHT JOIN `teams` AS t ON t.`id`=p.`team_id`
RIGHT JOIN `stadiums` AS s ON s.`id`=t.`stadium_id`
RIGHT JOIN `towns` AS tow ON tow.`id`=s.`town_id`
WHERE t.`name`!='Devify'
GROUP BY tow.`id`
ORDER BY `max_speed` DESC,tow.`name`;
