UPDATE `coaches` AS c
JOIN `players_coaches` AS pc ON c.`id`=pc.`coach_id`
SET c.`coach_level`=c.`coach_level`+1
WHERE c.`id`=pc.`coach_id` AND LEFT(c.`first_name`,1) LIKE 'A';