# Write your MySQL query statement below
Select 
    v.customer_id ,
    Count(v.visit_id) as count_no_trans
    from Visits as v
    Left Join Transactions as t 
    On v.visit_id = t.visit_id
    where t.transaction_id IS NULL 
    Group By v.customer_id;