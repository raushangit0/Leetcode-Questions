CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT Salary FROM (SELECT Salary , DENSE_RANK()OVER (order by Salary desc)as ranking
      from Employee)
       as ranked_salaries where ranking = N
        limit 1
  );
END