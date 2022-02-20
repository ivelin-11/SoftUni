DELIMITER $$
CREATE FUNCTION `ufn_calculate_future_value`(`initial_sum` DECIMAL(19,4),
`yearly_interest_rate` DECIMAL(19,4),`number_of_years` INT)
RETURNS DECIMAL(30,4)
DETERMINISTIC
BEGIN

RETURN `initial_sum`*(POW((1+`yearly_interest_rate`),`number_of_years`));

END$$

CREATE PROCEDURE `usp_calculate_future_value_for_account` (`id` INT,`interest_rate` DECIMAL(19,4))
BEGIN
SELECT a.`id` AS `account_id`,ah.`first_name`,ah.`last_name`, a.`balance` AS `current_balance`,
 `ufn_calculate_future_value`(a.`balance`,`interest_rate`,5) AS `balance_in_5_years`
FROM `account_holders` AS ah
JOIN `accounts` AS a ON a.`account_holder_id`=ah.`id`
WHERE a.`id`=`id`;

END$$

DELIMITER ;
CALL `usp_calculate_future_value_for_account`(1,0.1);