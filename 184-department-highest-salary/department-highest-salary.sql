SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM (
    select e.*,
    dense_rank()over(partition by departmentId order by salary desc)as rnk
    from Employee e
)e
join Department d
on d.id=e.departmentId
where rnk=1;