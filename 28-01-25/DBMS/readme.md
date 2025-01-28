
---

# 595. Big Countries

## Problem Description
The problem is to find the names, populations, and areas of countries that meet specific criteria:

- A country is considered big if it satisfies one of the following conditions:
  1. It has an area of at least three million square kilometers (3,000,000 km²).
  2. It has a population of at least twenty-five million (25,000,000).

### Table: World

| Column Name  | Type    |
|--------------|---------|
| name         | varchar |
| continent    | varchar |
| area         | int     |
| population   | int     |
| gdp          | bigint  |

- `name` is the primary key for the table.
- Each row contains information about the country’s name, continent, area, population, and GDP.

## Solution

To retrieve the required information (name, population, and area) of countries that are considered "big," we can use the following SQL query:

```sql
SELECT name, population, area
FROM World
WHERE area >= 3000000 OR population >= 25000000;
```

### Explanation:
- This query filters countries with an area greater than or equal to 3 million km² or a population greater than or equal to 25 million.
- The result will return the names, populations, and areas of all countries that meet either condition.

--- 
