
---

## **SQL File: 584_Find_Customer_Referee.sql**

### **Problem Statement**
The goal of this SQL query is to find and list the names of customers who do **not** have a referee with an ID of 2, or whose referee is **not** specified (i.e., the `referee_id` is `NULL`).

### **SQL Query**

```sql
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL;
```

### **Explanation**

- **SELECT name**:  
  This part of the query selects the `name` column from the `Customer` table, which represents the customer's name.
  
- **FROM Customer**:  
  This specifies the source table from which the data is being selected, in this case, the `Customer` table.

- **WHERE referee_id != 2 OR referee_id IS NULL**:  
  This condition filters the rows where the `referee_id` is either not equal to 2 or is `NULL`. The `referee_id != 2` condition excludes customers who have a referee with an ID of 2, and the `referee_id IS NULL` condition includes customers who do not have any referee assigned.

### **Expected Output**
The query will return the names of all customers whose `referee_id` is either not 2 or is missing (i.e., `NULL`).

---
