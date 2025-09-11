# Write your MySQL query statement below
Select activity_date day , Count(distinct user_id) active_users
from Activity
Where activity_date > '2019-06-27' AND activity_date <= '2019-07-27'
Group by activity_date
order by activity_date; 