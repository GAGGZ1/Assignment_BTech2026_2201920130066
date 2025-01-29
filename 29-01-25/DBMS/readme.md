
---

# Problem 1148: Article Views I

## Problem Description

We are given a table `Views` with the following schema:

### Table: Views

| Column Name | Type | Description |
|-------------|------|-------------|
| article_id  | int  | The ID of the article |
| author_id   | int  | The ID of the author of the article |
| viewer_id   | int  | The ID of the viewer who viewed the article |
| view_date   | date | The date the article was viewed |

- There is no primary key for this table, and it may contain duplicate rows.
- Each row represents an event where a viewer viewed an article (written by an author) on a specific date.
- If `author_id` and `viewer_id` are equal, it means the author has viewed their own article.

### Problem Statement

We need to find all authors who have viewed at least one of their own articles. The result should return the `author_id` (as `id`) and be sorted by `id` in ascending order.

### Solution

We can solve this by selecting distinct `author_id` values from the `Views` table where the `author_id` is equal to the `viewer_id`, meaning the author has viewed their own article.

### SQL Query

```sql
SELECT DISTINCT author_id AS id 
FROM views 
WHERE author_id = viewer_id 
ORDER BY author_id ASC;
```

### Explanation

- We select distinct `author_id` from the `views` table.
- The condition `author_id = viewer_id` ensures we only get authors who have viewed their own articles.
- The results are sorted by `author_id` in ascending order to match the required output format.

---
