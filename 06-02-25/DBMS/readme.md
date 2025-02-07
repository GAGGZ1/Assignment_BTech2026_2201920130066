### README: Classes More Than 5 Students

#### Problem Overview
The goal of this problem is to find the classes that have at least five students enrolled. The data is stored in the `Courses` table, which contains:
- `student`: The name of the student.
- `class`: The name of the class in which the student is enrolled.

Each row represents a student enrolled in a specific class. We are required to return the classes that have 5 or more students.

#### SQL Query

```sql
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
```

#### Explanation:
- **`GROUP BY class`**: Groups the data by the `class` column, ensuring the count is calculated for each class.
- **`COUNT(DISTINCT student)`**: Counts the number of distinct students in each class.
- **`HAVING COUNT(DISTINCT student) >= 5`**: Filters the result to only include classes with at least five students.

#### Example

Given the input:

| student | class    |
|---------|----------|
| A       | Math     |
| B       | English  |
| C       | Math     |
| D       | Biology  |
| E       | Math     |
| F       | Computer |
| G       | Math     |
| H       | Math     |
| I       | Math     |

The result will be:

| class    |
|----------|
| Math     |

#### Conclusion
This solution identifies and lists the classes with at least five students, helping to filter out smaller classes.