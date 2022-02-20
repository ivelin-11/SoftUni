SELECT `country_name`,`iso_code` FROM `countries`
WHERE `country_name` LIKE ('%A%a%a%') ORDER BY `iso_code`;

SELECT `country_name`,`iso_code` FROM `countries`
WHERE `country_name` REGEXP('(\\w*a\\w*){3,}') ORDER BY `iso_code`;

SELECT `country_name`,`iso_code` FROM `countries`
WHERE `country_name` REGEXP('(*a.*){3,}') ORDER BY `iso_code`;

SELECT `country_name`,`iso_code` FROM `countries`
WHERE (CHAR_LENGTH(`country_name`)-CHAR_LENGTH(REPLACE(LOWER(`country_name`),'a','')))>=3
ORDER BY `iso_code`;

