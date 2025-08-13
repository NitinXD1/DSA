# Write your MySQL query statement below
Select MAX(salary) as SecondHighestSalary from Employee WHERE salary NOT IN(Select MAX(salary) from Employee);