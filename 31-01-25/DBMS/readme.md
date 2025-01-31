# Replace Employee ID With The Unique Identifier (LeetCode 1378)

## Problem Statement
Given two tables, `Employees` and `EmployeeUNI`, write an SQL query to retrieve the unique ID of each employee. If an employee does not have a unique ID, return `NULL`.

## Table Structure

### Employees
| Column Name | Type    |
|------------|---------|
| id         | int     |
| name       | varchar |

- `id` is the primary key.
- Contains employee ID and name.

### EmployeeUNI
| Column Name | Type |
|------------|---------|
| id         | int     |
| unique_id  | int     |

- `(id, unique_id)` is the primary key.
- Contains employee ID and corresponding unique ID.

## Solution
```sql
SELECT a.unique_id, e.name 
FROM Employees AS e 
LEFT JOIN EmployeeUNI AS a ON a.id = e.id;
```

## Explanation
- Use `LEFT JOIN` to ensure all employees are included.
- Match `Employees.id` with `EmployeeUNI.id`.
- If a unique ID exists, display it; otherwise, return `NULL`.

## Expected Output Format
| unique_id | name |
|-----------|------|
| 101       | John |
| NULL      | Jane |

## How to Execute
1. Create and populate the `Employees` and `EmployeeUNI` tables.
2. Run the provided SQL query.
3. Verify the output against the expected format.