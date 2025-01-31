# Write your MySQL query statement below
select a.unique_id,e.name from Employees as e Left Join  EmployeeUNI as a on a.id=e.id;