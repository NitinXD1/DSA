# Write your MySQL query statement below
Select DATE_FORMAT(trans_date,'%Y-%m') as month , country , 
Count(CASE WHEN country is NULL THEN 0 ELSE 1 END) trans_count , 
Count(CASE WHEN state = 'approved' THEN 1 END) approved_count ,
Sum(amount) trans_total_amount , 
SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) approved_total_amount
from Transactions
Group by  DATE_FORMAT(trans_date,'%Y-%m') , country
