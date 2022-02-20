SELECT t.`town_id`,t.`name`,a.`address_text` FROM `addresses` AS a
 JOIN `towns` AS t USING(`town_id`)
 WHERE t.`name` IN ('Sofia','San Francisco','Carnation')
ORDER BY a.`town_id`,a.`address_id`;


SELECT t.`town_id`,t.`name`,a.`address_text`
FROM `towns` AS t
 JOIN `addresses` AS a ON t.`town_id`=a.`town_id`
WHERE t.`name` IN ('Sofia','San Francisco','Carnation')
ORDER BY a.`town_id`,a.`address_id`;


SELECT t.`town_id`,t.`name`,a.`address_text` FROM `addresses` AS a
 JOIN `towns` AS t ON t.`town_id`=a.`town_id`
 WHERE t.`name` IN ('Sofia','San Francisco','Carnation')
ORDER BY a.`town_id`,a.`address_id`;