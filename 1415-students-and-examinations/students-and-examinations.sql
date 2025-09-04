# Write your MySQL query statement below
Select s.student_id,s.student_name,sub.subject_name,Count(e.subject_name) attended_exams
from Students as s
Cross Join Subjects as sub
Left Join Examinations as e
On s.student_id = e.student_id 
    AND sub.subject_name = e.subject_name
group by sub.subject_name,s.student_id
Order by s.student_id,sub.subject_name