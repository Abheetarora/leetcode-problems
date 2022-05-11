CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
     SELECT distinct salary
     FROM (
         SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) as rn
         FROM Employee
     ) as sub_select
     WHERE rn = N
  );
END