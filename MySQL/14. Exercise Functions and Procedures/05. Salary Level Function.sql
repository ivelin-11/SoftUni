DELIMITER $$

CREATE FUNCTION `ufn_get_salary_level`(`searched_salary` DECIMAL(19,4))
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE `salary_level` TEXT;
    CASE
        WHEN `searched_salary` < 30000 THEN SET `salary_level`:= 'Low';
        WHEN `searched_salary` BETWEEN 30000 AND 50000 THEN SET `salary_level`:= 'Average';
        ELSE SET `salary_level`:='High';
        END CASE;
    RETURN `salary_level`;
  END  $$
    
    DELIMITER ;
    
    SELECT `ufn_get_salary_level`(16000);
