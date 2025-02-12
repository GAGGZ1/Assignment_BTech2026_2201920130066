
# Customer Who Visited but Did Not Make Any Transactions

## Problem Description
This problem aims to find customers who visited a mall but did not make any transactions. You are given two tables: `Visits` and `Transactions`. The task is to return the IDs of customers who visited the mall without making any transactions and the number of times they made these types of visits.

## Tables

### Visits
| Column Name   | Type  |
|---------------|-------|
| visit_id      | int   |
| customer_id   | int   |

- `visit_id` is a unique identifier for each visit.
- The table contains data about customers who visited the mall.

### Transactions
| Column Name     | Type  |
|-----------------|-------|
| transaction_id  | int   |
| visit_id        | int   |
| amount          | int   |

- `transaction_id` is a unique identifier for each transaction.
- This table contains data about the transactions made during each visit.

## Goal
Find the customers who visited but did not make any transactions. You need to output the customer ID and the number of visits they made without transactions.

## Solution Query
```sql
SELECT v.customer_id, COUNT(v.customer_id) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
```

## Explanation
- We perform a `LEFT JOIN` between `Visits` and `Transactions` on the `visit_id` column.
- We filter the rows where there was no transaction (`t.transaction_id IS NULL`).
- Finally, we count how many times each customer visited the mall without making a transaction.

## Example

### Input
#### Visits Table:
| visit_id | customer_id |
|----------|-------------|
| 1        | 23          |
| 2        | 9           |
| 4        | 30          |
| 5        | 54          |
| 6        | 96          |
| 7        | 54          |
| 8        | 54          |

#### Transactions Table:
| transaction_id | visit_id | amount |
|----------------|----------|--------|
| 2              | 5        | 310    |
| 3              | 5        | 300    |
| 9              | 5        | 200    |
| 12             | 1        | 910    |
| 13             | 2        | 970    |

### Output
| customer_id | count_no_trans |
|-------------|----------------|
| 54          | 2              |
| 30          | 1              |
| 96          | 1              |

