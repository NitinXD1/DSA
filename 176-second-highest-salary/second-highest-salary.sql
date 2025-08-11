# Write your MySQL query statement below
Select MAX(salary) as SecondHighestSalary from Employee WHERE salary NOT IN (select MAX(salary) from employee);