# Write your MySQL query statement below
Select p.project_id , ROUND(SUM(e.experience_years)/Count(e.employee_id),2) as average_years
from Project as p
Left Join Employee as e
On p.employee_id = e.employee_id
group by p.project_id;