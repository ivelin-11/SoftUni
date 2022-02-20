SELECT 
    c.`country_name`,
    MAX(p.`elevation`) AS `highest_peak_elevation`,
    MAX(r.`length`) AS `longest_river_length`
    -- Functions like max and min if we dont have group by they reutrn one result 
FROM
    `countries` AS c
        LEFT JOIN `mountains_countries` AS mc ON mc.`country_code` = c.`country_code`
        LEFT JOIN `peaks` AS p ON p.`mountain_id` = mc.`mountain_id`
        LEFT JOIN `countries_rivers` AS cr ON cr.`country_code` = c.`country_code`
        LEFT JOIN `rivers` AS r ON r.`id` = cr.`river_id`
GROUP BY c.`country_code`
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c.`country_name` ASC
LIMIT 5;
