# Write your MySQL query statement below
select name 
from Employee
where id in(
    select managerId
    from employee
    group by managerID
    having count(*)>=5
)