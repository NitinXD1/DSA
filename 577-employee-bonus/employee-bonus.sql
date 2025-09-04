# Write your MySQL query statement below
Select e.name , b.bonus 
from Employee as e
Left Join Bonus as b
On e.empId = b.empId
Where b.bonus < 1000 OR b.bonus is null; 