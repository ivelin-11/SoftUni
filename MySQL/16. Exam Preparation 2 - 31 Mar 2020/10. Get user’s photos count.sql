CREATE FUNCTION `udf_users_photos_count`(username VARCHAR(30))
RETURNS INT
DETERMINISTIC
RETURN (SELECT COUNT(*) FROM `users` AS u
JOIN `users_photos` AS up ON up.`user_id`=u.`id`
WHERE u.`username` LIKE `username`);


SELECT udf_users_photos_count('ssantryd') AS photosCount;