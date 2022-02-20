SELECT p.`peak_name`,r.`river_name`,
LOWER(CONCAT(SUBSTRING(p.`peak_name`,1,CHAR_LENGTH(p.`peak_name`)-1),r.`river_name`)) AS `mix`
FROM `peaks` AS p,`rivers` as `r`
WHERE RIGHT(p.`peak_name`,1)=LEFT(r.`river_name`,1)
ORDER BY `mix`; 

SELECT p.`peak_name`,r.`river_name`,
LOWER(CONCAT(p.`peak_name`,SUBSTRING(r.`river_name`,2,CHAR_LENGTH(r.`river_name`)))) AS `mix`
FROM `peaks` AS p,`rivers` as `r`
WHERE RIGHT(p.`peak_name`,1)=LEFT(r.`river_name`,1)
ORDER BY `mix`; 