SELECT t.`name` AS `team_name`,
t.`established`,
t.`fan_base`,
(SELECT COUNT(*) FROM `players` AS p WHERE p.`team_id`=t.`id`) AS `players_count`
 FROM `teams` AS t
 ORDER BY `players_count` DESC,t.`fan_base` DESC;

