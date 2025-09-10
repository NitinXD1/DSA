    # Write your MySQL query statement below
    Select Round(Count(CASE WHEN od = dd AND rk = 1 Then 1 END) / Count(DISTINCT (customer_id))*100,2) as immediate_percentage FROM
    (
        Select customer_id , 
        Rank() Over(Partition By customer_id Order by order_date asc) rk,
        order_date as od,
        customer_pref_delivery_date as dd
        from Delivery
    )t