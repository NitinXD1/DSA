# Write your MySQL query statement below
Select r.contest_id , ROUND(COUNT(u.user_id) * 100.0 / total.total_users, 2) AS percentage
from Users u
Inner Join Register r
On u.user_id = r.user_id
CROSS JOIN (SELECT COUNT(*) AS total_users FROM Users) total
GROUP BY r.contest_id, total.total_users
ORDER BY percentage DESC, r.contest_id ASC;