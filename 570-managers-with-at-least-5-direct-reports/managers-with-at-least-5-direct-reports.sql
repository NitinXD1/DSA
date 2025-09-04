# Write your MySQL query statement below
Select a.name as name
from Employee as a
Join Employee as b
On a.id = b.managerId
group by b.managerId
having Count(b.managerId) >= 5