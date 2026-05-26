# Write your MySQL query statement below
with DirectReports as(
    select managerId,Count(*)as report_count
    from Employee
    where managerId is not null
    group BY managerId
)
select e.name
from Employee e
join DirectReports d
  on e.id=d.managerId
where d.report_count >=5;
