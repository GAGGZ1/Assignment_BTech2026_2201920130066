-- 584_Find Customer Referee.sql
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL;
git add 584_Find_Customer_Referee.sql
