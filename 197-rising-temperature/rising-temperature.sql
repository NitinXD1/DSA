# Write your MySQL query statement below
Select w2.id
from Weather as w1
Join Weather as w2
ON DateDiff(w2.recordDate,w1.recordDate) = 1
WHERE w2.temperature > w1.temperature;