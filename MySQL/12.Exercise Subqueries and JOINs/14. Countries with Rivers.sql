SELECT c.`country_name` ,r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr ON c.`country_code`=cr.`country_code`
LEFT JOIN `rivers` AS r ON cr.`river_id`=r.`id`
JOIN `continents` AS co ON co.`continent_code`=c.`continent_code`
WHERE co.`continent_name` LIKE 'Africa'
ORDER BY c.`country_name` ASC LIMIT 5;