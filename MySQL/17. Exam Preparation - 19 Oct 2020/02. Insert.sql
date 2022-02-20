INSERT INTO `products_stores` (`product_id`,`store_id`)
SELECT `id`,1 FROM `products` AS p
LEFT JOIN `products_stores` AS ps
ON ps.`product_id`=p.`id`
WHERE ps.`store_id` IS NULL;