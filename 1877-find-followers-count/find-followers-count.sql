# Write your MySQL query statement below
Select user_id,Count(user_id) followers_Count
from Followers
group by user_id
Order by user_id;
