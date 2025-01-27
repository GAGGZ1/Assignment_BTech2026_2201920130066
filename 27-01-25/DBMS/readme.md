# README for SQL Query Solution

## Problem Statement
You are tasked with writing an SQL query to find the IDs of products that are both low fat and recyclable. The data is stored in a table named `Products` with the following schema:

### Table Schema: Products
| Column Name | Data Type | Description |
|-------------|-----------|-------------|
| product_id  | int       | Primary key identifying each product uniquely. |
| low_fats    | enum ('Y', 'N') | Indicates whether a product is low fat ('Y') or not ('N'). |
| recyclable  | enum ('Y', 'N') | Indicates whether a product is recyclable ('Y') or not ('N'). |

### Requirements
1. Extract the `product_id` of all products where:
   - `low_fats` is 'Y' (low fat).
   - `recyclable` is 'Y' (recyclable).
2. Return the result in any order.

---

## SQL Query
The SQL query for solving this problem is as follows:

```sql
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';
```

---

## Explanation of the Query
1. **SELECT Clause**: This retrieves the `product_id` column from the `Products` table.
2. **FROM Clause**: Specifies the `Products` table as the data source.
3. **WHERE Clause**: Applies the following conditions:
   - `low_fats = 'Y'`: Filters rows where the product is low fat.
   - `recyclable = 'Y'`: Filters rows where the product is recyclable.
   - The `AND` operator ensures that both conditions are true for a row to be included in the result.

---

## Input Example
Consider the following `Products` table:

| product_id | low_fats | recyclable |
|------------|----------|------------|
| 1          | 'Y'      | 'Y'        |
| 2          | 'N'      | 'Y'        |
| 3          | 'Y'      | 'N'        |
| 4          | 'Y'      | 'Y'        |

---

## Output Example
Based on the input above, the query will return:

| product_id |
|------------|
| 1          |
| 4          |

---

## Notes
- The `ENUM` type values are case-sensitive in some databases. Ensure the case matches (e.g., use 'Y' instead of 'y').
- The query assumes no NULL values in the `low_fats` or `recyclable` columns. Handle NULL values if they exist in the actual dataset.
- Test the query in the specific SQL environment where it will be executed to confirm compatibility.

---

## Conclusion
This query efficiently extracts the IDs of products that meet both conditions, helping to identify items that are environmentally friendly and suitable for health-conscious consumers. The simple structure ensures readability and maintainability.

