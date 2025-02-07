# README: 620. Not Boring Movies

### Problem Statement:
We need to retrieve movies from the `Cinema` table with the following conditions:
- The movie's `id` is an odd number.
- The movie's `description` is not "boring".

Additionally, the results should be ordered by the movie's `rating` in descending order.

### SQL Schema:

**Table: Cinema**

| Column Name    | Type     |
|----------------|----------|
| id             | int      |
| movie          | varchar  |
| description    | varchar  |
| rating         | float    |

- `id` is the primary key, with unique values.
- `rating` is a float value rounded to two decimal places, in the range [0, 10].

### Query:
```sql
SELECT *
FROM Cinema
WHERE id % 2 != 0 AND description != 'boring'
ORDER BY rating DESC;
```

### Explanation:
- The query selects all columns from the `Cinema` table.
- The `WHERE` clause filters rows where the `id` is odd (`id % 2 != 0`) and the `description` is not equal to "boring".
- The `ORDER BY` clause sorts the results by `rating` in descending order.

### Result:
The result table will include movies with odd-numbered IDs and descriptions other than "boring", sorted by their ratings from highest to lowest.