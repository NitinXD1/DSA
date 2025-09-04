# Write your MySQL query statement below
Select machine_id , Round(AVG(time),3) as processing_time from
(
    Select a.machine_id , (b.timestamp - a.timestamp) time 
    from Activity as a 
    Join Activity as b
    On a.machine_id = b.machine_id
    Where a.process_id = b.process_id And a.activity_type = 'start' And b.activity_type = 'end'
)t GROUP BY machine_id;