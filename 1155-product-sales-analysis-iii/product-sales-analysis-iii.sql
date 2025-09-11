# Write your MySQL query statement below
Select product_id,year first_year,quantity,price 
FROM (
    Select * ,
    Rank() OVER(Partition By product_id Order by year) rk
    from
    Sales
)t
Where rk = 1;