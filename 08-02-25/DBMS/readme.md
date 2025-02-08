
---

# Triangle Judgement  

## Problem Statement  
The `Triangle` table contains three integer columns: `x`, `y`, and `z`, representing the lengths of three line segments. The task is to determine whether these segments can form a valid triangle.  

## Solution  
A triangle is valid if it satisfies the **triangle inequality theorem**:  
- \( x + y > z \)  
- \( y + z > x \)  
- \( x + z > y \)  

The following SQL query evaluates each set of line segments and returns `"Yes"` if they form a valid triangle, otherwise `"No"`:  

```sql
SELECT *,
IF(x + y > z AND y + z > x AND x + z > y, "Yes", "No") AS triangle
FROM Triangle;
```

## Example  

### **Input (Triangle Table)**  
| x  | y  | z  |  
|----|----|----|  
| 13 | 15 | 30 |  
| 10 | 20 | 15 |  

### **Output**  
| x  | y  | z  | triangle |  
|----|----|----|----------|  
| 13 | 15 | 30 | No       |  
| 10 | 20 | 15 | Yes      |  

## Notes  
- The primary key for this table is `(x, y, z)`.  
- The output order can be arbitrary.  

