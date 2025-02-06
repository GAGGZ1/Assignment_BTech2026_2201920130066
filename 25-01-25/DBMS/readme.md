# Product Sales Analysis I

## Problem Statement
Given two tables, `Sales` and `Product`, write an SQL query to retrieve the `product_name`, `year`, and `price` for each sale recorded in the `Sales` table.

## Table Schema
### Sales Table
| Column Name | Type  |
|-------------|-------|
| sale_id     | int   |
| product_id  | int   |
| year        | int   |
| quantity    | int   |
| price       | int   |

- `(sale_id, year)` is the primary key.
- `product_id` is a foreign key referencing the `Product` table.

### Product Table
| Column Name  | Type    |
|-------------|---------|
| product_id   | int     |
| product_name | varchar |

- `product_id` is the primary key.

## SQL Query
```sql
SELECT p.product_name, s.year, s.price
FROM Sales s
INNER JOIN Product p ON p.product_id = s.product_id;
```

## Example
### Input
#### Sales Table:
| sale_id | product_id | year | quantity | price |
|---------|------------|------|----------|-------|
| 1       | 100        | 2008 | 10       | 5000  |
| 2       | 100        | 2009 | 12       | 5000  |
| 7       | 200        | 2011 | 15       | 9000  |

#### Product Table:
| product_id | product_name |
|------------|--------------|
| 100        | Nokia        |
| 200        | Apple        |
| 300        | Samsung      |

### Output
| product_name | year  | price |
|--------------|-------|-------|
| Nokia        | 2008  | 5000  |
| Nokia        | 2009  | 5000  |
| Apple        | 2011  | 9000  |

## Explanation
- Nokia was sold for 5000 in 2008 and 2009.
- Apple was sold for 9000 in 2011.

This query ensures the correct retrieval of product details from both tables using an `INNER JOIN`.

