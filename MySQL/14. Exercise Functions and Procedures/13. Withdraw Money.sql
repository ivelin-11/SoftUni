DELIMITER $$

CREATE PROCEDURE usp_withdraw_money(account_id INT , money_amount DECIMAL(19,4))
BEGIN
DECLARE amount DECIMAL(19,4);
SET amount:=( SELECT `balance` FROM `accounts` WHERE `id`=`account_id`);

START TRANSACTION;

IF(money_amount<=0 OR money_amount>amount ) THEN
ROLLBACK;
ELSE 
UPDATE `accounts` AS a
JOIN `account_holders` AS ah ON ah.`id`=a.`account_holder_id`
SET a.`balance`=a.`balance` - `money_amount` 
WHERE a.`id`=`account_id`;
END IF;
END$$

DELIMITER ;

CALL  usp_withdraw_money (1,10);