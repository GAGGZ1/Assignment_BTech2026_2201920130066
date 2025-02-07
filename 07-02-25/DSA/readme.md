
---

# Solutions to Coding Problems

This repository contains solutions for three problems, each solved with Java. Below are the problems and their respective approaches and solutions:

## Problem 1: **[2369. Check if There is a Valid Partition For The Array](https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/)**

### Problem Statement:
Given a 0-indexed integer array `nums`, partition the array into one or more contiguous subarrays. A partition is valid if each of the obtained subarrays satisfies one of the following conditions:
- The subarray consists of exactly two equal elements (e.g., [2, 2]).
- The subarray consists of exactly three equal elements (e.g., [4, 4, 4]).
- The subarray consists of exactly three consecutive increasing elements, where the difference between adjacent elements is 1 (e.g., [3, 4, 5]).

Return `true` if the array has at least one valid partition, otherwise return `false`.

### Approach:
We use dynamic programming (DP) to solve this problem. We maintain a DP array `dp[i]` to check if the subarray from index `0` to `i` can be partitioned validly.

### Solution:
```java
class Solution {
    public boolean validPartition(int[] nums) {
        return solve(nums, 0, new Boolean[nums.length]);
    }

    public boolean solve(int[] nums, int i, Boolean[] dp) {
        if (i == nums.length)
            return true;

        if (dp[i] != null)
            return dp[i];

        boolean result = false;

        // Check if the next two elements are the same
        if ((i + 1) < nums.length && (nums[i] == nums[i + 1]))
            result = result || solve(nums, i + 2, dp);

        // Check if the next three elements are the same
        if ((i + 2) < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
            result = result || solve(nums, i + 3, dp);

        // Check if the next three elements form a consecutive sequence
        if ((i + 2) < nums.length && ((nums[i] + 1) == nums[i + 1]) && ((nums[i] + 2) == nums[i + 2]))
            result = result || solve(nums, i + 3, dp);

        return dp[i] = result;
    }
}
```

---

## Problem 2: **[1582. Special Positions in a Binary Matrix](https://leetcode.com/problems/special-positions-in-a-binary-matrix/)**

### Problem Statement:
You are given a `m x n` binary matrix `mat`. A position in the matrix is "special" if it’s the only `1` in its row and the only `1` in its column. Return the number of special positions in the matrix.

### Approach:
- Count the number of `1`s in each row and column.
- Check for each `1` in the matrix if it is the only `1` in its row and column.

### Solution:
```java
class Solution {
  public int numSpecial(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;
      int[] rowCount = new int[m];
      int[] colCount = new int[n];
      
      for (int row = 0; row < m; row++) {
          for (int col = 0; col < n; col++) {
              if (mat[row][col] == 1) {
                  rowCount[row]++;
                  colCount[col]++;
              }
          }
      }
      
      int result = 0;
      for (int row = 0; row < m; row++) {
          for (int col = 0; col < n; col++) {
              if (mat[row][col] == 1) {
                  if (rowCount[row] == 1 && colCount[col] == 1) {
                      result++;
                  }
              }
          }
      }
      
      return result;
  }
}
```

---

## Problem 3: **[867. Transpose Matrix](https://leetcode.com/problems/transpose-matrix/)**

### Problem Statement:
Given a 2D matrix `matrix`, return the transpose of `matrix`. The transpose of a matrix is obtained by swapping the rows and columns.

### Approach:
- Create a new matrix with swapped dimensions (rows become columns and columns become rows).
- Loop through each element and assign it to the transposed position.

### Solution:
```java
class Solution {
  public int[][] transpose(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int[][] transposed = new int[cols][rows]; // Swapping dimensions

      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              transposed[j][i] = matrix[i][j]; // Swapping indices
          }
      }
      return transposed;
  }
}
```

---

## Conclusion:
These are the solutions to the mentioned coding problems. The solutions utilize dynamic programming, simple matrix manipulations, and efficient counting techniques. Feel free to explore them and adapt to your own needs!

---