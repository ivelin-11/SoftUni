DELIMITER $$
CREATE FUNCTION udf_stadium_players_count(`stadium_name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE output INT;
SET output:=(SELECT COUNT(*)
FROM `players` AS p
JOIN `teams` AS t ON t.`id`=p.`team_id`
JOIN `stadiums` AS s ON s.`id`=t.`stadium_id`
WHERE  s.`name`=`stadium_name`
GROUP BY s.`name`);
IF(output IS NULL) THEN SET output:=0;
END IF;
RETURN output;
END$$

DELIMITER ;
SELECT udf_stadium_players_count ('Jaxworks') as `count`; 
SELECT udf_stadium_players_count ('Linklinks') as `count`; 