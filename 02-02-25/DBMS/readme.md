

# README

## Problem: Rising Temperature (Leetcode 197)

### Description:
Find all dates' IDs with higher temperatures compared to the previous day's temperature in the `Weather` table.

### SQL Schema:

Table: `Weather`

| Column Name   | Type    |
|---------------|---------|
| id            | int     |
| recordDate    | date    |
| temperature   | int     |

- `id` is the unique identifier for each record.
- `recordDate` represents the date of the temperature record.
- `temperature` is the temperature recorded on that date.

### Solution:

```sql
SELECT w1.id
FROM Weather w1
JOIN Weather w2
  ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;
```

### Explanation:
- The query uses a self-join on the `Weather` table to compare the temperature of each day with the previous day.
- `DATEDIFF(w1.recordDate, w2.recordDate) = 1` ensures that we are comparing each date (`w1`) with the previous date (`w2`).
- The `WHERE` clause checks if the temperature of `w1` is greater than that of `w2`.

---