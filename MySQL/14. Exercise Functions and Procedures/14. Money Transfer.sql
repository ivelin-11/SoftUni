DELIMITER $$

CREATE PROCEDURE usp_transfer_money(from_account_id INT , 
to_account_id INT ,amount DECIMAL(19,4))
BEGIN

DECLARE check_account_sender INT;
DECLARE check_account_receiver INT;
DECLARE available_money_sender  DECIMAL(19,4);

SET check_account_sender := (SELECT COUNT(*) FROM `accounts`
WHERE `id`=from_account_id);

SET check_account_receiver := (SELECT COUNT(*) FROM `accounts`
WHERE `id`=to_account_id);

SET available_money_sender := (SELECT balance FROM `accounts`
WHERE `id`=from_account_id);

START TRANSACTION;
IF(check_account_sender<>1 OR check_account_receiver <>1) THEN
ROLLBACK;

ELSE IF(amount<=0 OR amount>available_money_sender ) THEN
ROLLBACK;

ELSE 
UPDATE `accounts` AS a
SET a.`balance`=a.`balance` - `amount` 
WHERE a.`id`=`from_account_id`;

UPDATE `accounts` AS a
SET a.`balance`=a.`balance` + `amount` 
WHERE a.`id`=`to_account_id`;

END IF;
END IF;
END$$

DELIMITER ;

CALL  usp_transfer_money (1,2,10);