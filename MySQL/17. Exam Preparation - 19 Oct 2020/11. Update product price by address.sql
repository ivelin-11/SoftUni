DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
DECLARE old_price DECIMAL(10,2);

SET old_price:=(SELECT p.`price` FROM `products` AS p
JOIN `products_stores` AS ps ON ps.`product_id`=p.`id`
JOIN `stores` AS s On s.`id`=ps.`store_id`
JOIN `addresses` AS a ON a.`id`=s.`address_id`
WHERE a.`name`=`address_name` LIMIT 1);

IF LEFT(LTRIM(old_price),1)='0'
THEN
UPDATE `products` AS p
JOIN `products_stores` AS ps ON ps.`product_id`=p.`id`
JOIN `stores` AS s On s.`id`=ps.`store_id`
JOIN `addresses` AS a ON a.`id`=s.`address_id`
SET p.`price`=p.`price`+100
WHERE a.`name`=`address_name`;

ELSE 
UPDATE `products` AS p
JOIN `products_stores` AS ps ON ps.`product_id`=p.`id`
JOIN `stores` AS s On s.`id`=ps.`store_id`
JOIN `addresses` AS a ON a.`id`=s.`address_id`
SET p.`price`=p.`price`+200
WHERE a.`name`=`address_name`;
END IF;

END$$

DELIMITER ;
CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;