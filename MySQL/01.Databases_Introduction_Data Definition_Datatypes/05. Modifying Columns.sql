USE `gamebar`;



/*-- Modify doesnt support change name only constraints
-- modify is faster than change  
ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(30);
*/

ALTER TABLE `employees`
CHANGE COLUMN `middle_name` `middle_name` VARCHAR(100);