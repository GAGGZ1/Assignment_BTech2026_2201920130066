# README: Employee Bonus

## Problem Description

The task is to report the name and bonus amount of each employee who has a bonus less than 1000. Additionally, employees who do not have any bonus should also be included in the result.

### SQL Schema

#### Table: Employee

| Column Name | Type    |
|-------------|---------|
| empId       | int     |
| name        | varchar |
| supervisor  | int     |
| salary      | int     |

- `empId` is the unique identifier for each employee.
- Each row contains information about an employee's name, ID, salary, and supervisor's ID.

#### Table: Bonus

| Column Name | Type |
|-------------|------|
| empId       | int  |
| bonus       | int  |

- `empId` is the unique identifier for each employee in this table and serves as a foreign key referencing the Employee table.
- Each row contains an employee's ID and their respective bonus amount.

## Solution

### SQL Query:

```sql
SELECT e.name, b.bonus
FROM Employee e
LEFT JOIN Bonus b ON e.empId = b.empId
WHERE b.bonus IS NULL OR b.bonus < 1000;
```

### Explanation:

- **LEFT JOIN**: Ensures that all employees from the Employee table are included, even if they don't have a corresponding bonus record.
- **WHERE b.bonus IS NULL OR b.bonus < 1000**: Filters employees who either have a bonus less than 1000 or no bonus at all (NULL).

### Output:
- The query returns the employee's name and bonus, including employees with NULL bonuses.
