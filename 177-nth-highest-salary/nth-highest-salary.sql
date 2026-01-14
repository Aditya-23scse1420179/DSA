CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    select salary from Employee e1
    where N-1=(
        select count(distinct salary)
        from employee e2
        where e2.salary>e1.salary
    )limit 1
  );
END