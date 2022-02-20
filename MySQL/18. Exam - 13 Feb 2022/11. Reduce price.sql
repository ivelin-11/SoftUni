DELIMITER $$
CREATE PROCEDURE udp_reduce_price(`category_name` VARCHAR(50))
BEGIN
UPDATE `categories` AS c
JOIN `products` AS p ON p.`category_id`=c.`id`
JOIN `reviews` As r ON r.`id`=p.`review_id`
SET p.`price`=p.`price`-(p.`price`*0.3)
WHERE c.`name`=`category_name` AND r.`rating`<4;
END$$

DELIMITER ;
CALL udp_reduce_price ('Phones and tablets');
SELECT * FROM `categories` AS c
JOIN `products` AS p ON p.`category_id`=c.`id`
JOIN `reviews` As r ON r.`id`=p.`review_id`
WHERE c.`name`='Phones and tablets' AND r.`rating`<4;