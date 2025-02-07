
---

# README

## Problem 1: Maximum Number of Points with Cost (Leetcode 1937)

### Approach:
- Use dynamic programming (DP) to maintain a record of the maximum points that can be accumulated up to each column in the current row.
- For each row, update the DP table by considering both the direct addition and adjustment (subtracting 1) for each column to ensure that the solution maximizes the points.

### Solution:
```java
class Solution {
  public long maxPoints(int[][] points) {
      int n = points.length;
      int m = points[0].length;

      long[] dp = new long[m];
      long res = 0;
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              dp[j] += points[i][j];
          }

          for (int j = 1; j < m; j++) {
              dp[j] = Math.max(dp[j], dp[j - 1] - 1);
          }
          for (int j = m - 2; j >= 0; j--) {
              dp[j] = Math.max(dp[j], dp[j + 1] - 1);
          }
      }
      for (int i = 0; i < m; i++) {
          res = Math.max(res, dp[i]);
      }
      return res;
  }
}
```

---

## Problem 2: Ugly Number II (Leetcode 264)

### Approach:
- Use a dynamic programming approach to find the nth ugly number by continuously multiplying the smallest unprocessed number by 2, 3, or 5.
- Maintain pointers to keep track of which numbers have been used to generate the next ugly number.

### Solution:
```java
class Solution {
  public int nthUglyNumber(int n) {
      int[] t = new int[n + 1];
      t[1] = 1;

      int i2 = 1, i3 = 1, i5 = 1;

      for (int i = 2; i <= n; i++) {
          int i2th_ugly = t[i2] * 2;
          int i3rd_ugly = t[i3] * 3;
          int i5th_ugly = t[i5] * 5;

          int minUgly = i2th_ugly;
          if (i3rd_ugly < minUgly) {
              minUgly = i3rd_ugly;
          }
          if (i5th_ugly < minUgly) {
              minUgly = i5th_ugly;
          }

          t[i] = minUgly;

          if (t[i] == i2th_ugly) {
              i2++;
          }
          if (t[i] == i3rd_ugly) {
              i3++;
          }
          if (t[i] == i5th_ugly) {
              i5++;
          }
      }
      return t[n];
  }
}
```

---

## Problem 3: Maximum Distance in Arrays (Leetcode 624)

### Approach:
- Iterate through the list of arrays, maintaining the minimum and maximum elements for comparison.
- Calculate the maximum possible distance between the minimum and maximum elements of different arrays.

### Solution:
```java
import java.util.*;
class Solution {
  public int maxDistance(List<List<Integer>> a) {
      int maxdiff = Integer.MIN_VALUE;
      int minElement = a.get(0).get(0);
      int maxElement = a.get(0).get(a.get(0).size() - 1);

      for (int i = 1; i < a.size(); i++) {
          int minCurrent = a.get(i).get(0);
          int maxCurrent = a.get(i).get(a.get(i).size() - 1);
          maxdiff = Math.max(maxdiff, Math.abs(minCurrent - maxElement));
          maxdiff = Math.max(maxdiff, Math.abs(maxCurrent - minElement));
          minElement = Math.min(minElement, minCurrent);
          maxElement = Math.max(maxElement, maxCurrent);
      }
      return maxdiff;
  }
}
```

---