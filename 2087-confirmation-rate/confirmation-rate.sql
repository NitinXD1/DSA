# Write your MySQL query statement below
Select 
    s.user_id user_id,
    Round(IFNULL(SUM(c.action = 'confirmed') / COUNT(c.action), 0),2) as confirmation_rate
from Signups as s
Left Join Confirmations as c
On s.user_id = c.user_id
group by s.user_id
