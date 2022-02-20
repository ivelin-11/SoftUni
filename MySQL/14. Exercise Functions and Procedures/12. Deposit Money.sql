DELIMITER $$

CREATE PROCEDURE usp_deposit_money(account_id INT , money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF(money_amount<=0) THEN
ROLLBACK;
ELSE 
UPDATE `accounts` AS a
JOIN `account_holders` AS ah ON ah.`id`=a.`account_holder_id`
SET a.`balance`=a.`balance` + `money_amount` 
WHERE a.`id`=`account_id`;
END IF;
END$$

DELIMITER ;

CALL  usp_deposit_money(1,10);