### README: Number of Unique Subjects Taught by Each Teacher

#### Problem Overview
This problem aims to calculate the number of unique subjects taught by each teacher in a university. We are provided with a `Teacher` table that contains the following columns:
- `teacher_id`: The unique identifier for each teacher.
- `subject_id`: The unique identifier for each subject.
- `dept_id`: The unique identifier for each department.

Each row in the table indicates that a particular teacher teaches a specific subject in a given department. The combination of `subject_id` and `dept_id` is unique for each subject taught in a department.

#### Goal
We need to calculate the number of unique subjects taught by each teacher. The result will show:
- The `teacher_id` for each teacher.
- The count of unique subjects they teach.

#### SQL Query

```sql
-- Write your MySQL query statement below
SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;
```

#### Query Explanation:
- **COUNT(DISTINCT subject_id)**: This function counts the unique `subject_id` values associated with each teacher.
- **GROUP BY teacher_id**: This groups the rows by `teacher_id`, so that the count is calculated for each teacher individually.

#### Result Format
The result will return a table with the following columns:
- `teacher_id`: The unique identifier for each teacher.
- `cnt`: The number of unique subjects taught by the teacher.

#### Example

| teacher_id | cnt |
|------------|-----|
| 1          | 3   |
| 2          | 2   |
| 3          | 4   |

This indicates that Teacher 1 teaches 3 unique subjects, Teacher 2 teaches 2 unique subjects, and Teacher 3 teaches 4 unique subjects.

#### Conclusion
This solution helps us efficiently calculate and return the number of unique subjects each teacher is responsible for, making it easier to analyze teaching distribution across the university.