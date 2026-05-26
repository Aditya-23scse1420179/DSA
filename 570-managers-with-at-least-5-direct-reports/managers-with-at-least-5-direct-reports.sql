# Write your MySQL query statement below
with cte as(
    select managerId,Count(*)as report_count
    from Employee
    where managerId is not null
    group BY managerId
)
select e.name
from Employee e
join cte c
  on e.id=c.managerId
where c.report_count >=5;
