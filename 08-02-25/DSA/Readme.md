
# Readme: LeetCode Problems and Solutions

## 1. Problem: Maximize Happiness of Selected Children (LeetCode 3075)
### Problem Statement:
Given an array `happiness` of length `n` and an integer `k`, select `k` children such that the sum of their happiness values is maximized. When a child is selected, the happiness of all unselected children decreases by 1 (but cannot go negative).

### Approach:
- Use a **max-heap (priority queue)** to always pick the child with the highest happiness value.
- Initialize a `count` to track the number of selections made.
- For each selection, subtract `count` from the selected happiness value to account for decrements and add it to the result.
- Repeat this process `k` times.

### Solution:
```java
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int hap : happiness) {
            pq.offer(hap);
        }
        
        for (int i = 0; i < k; i++) {
            int hap = pq.poll();
            result += Math.max(hap - count, 0);
            count++;
        }
        
        return result;
    }
}
```

---

## 2. Problem: Remove Colored Pieces (LeetCode 2038)
### Problem Statement:
Alice and Bob play a game where they remove pieces from a string `colors` consisting of 'A' and 'B'. Alice can only remove 'A' surrounded by 'A', and Bob can only remove 'B' surrounded by 'B'. The game continues until no more moves are possible, and the player who cannot move loses.

### Approach:
- Traverse the string and count the number of removable 'A' pieces for Alice and 'B' pieces for Bob.
- Alice wins if she has more removable pieces than Bob.

### Solution:
```java
public class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0, bob = 0;
        
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }
        
        return alice > bob;
    }
}
```

---

## 3. Problem: Champagne Tower (LeetCode 799)
### Problem Statement:
Given `poured` cups of champagne, determine how much champagne is in the glass at row `i` and column `j` of a pyramid structure.

### Approach:
- Use **Dynamic Programming (DP)** to track champagne flow.
- Create a 2D DP table where `dp[i][j]` represents the amount of champagne in glass `(i, j)`.
- Each glass can overflow its excess champagne equally to the two glasses below it.
- Use recursion with memoization to optimize calculations.

### Solution:
```java
class Solution {
    public double champagneTower(int poured, int i, int j) {
        double dp[][] = new double[101][101];
        for (double[] d : dp) {
            Arrays.fill(d, -1);
        }
        return Math.min(1.0, solve(poured, i, j, dp));
    }
    
    public double solve(int poured, int i, int j, double[][] dp) {
        if (i < 0 || j < 0 || i < j) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return poured;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        double left = (solve(poured, i - 1, j - 1, dp) - 1) / 2;
        double right = (solve(poured, i - 1, j, dp) - 1) / 2;
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        
        return dp[i][j] = left + right;
    }
}
```

---

### Summary:
- **Maximize Happiness**: Use a max-heap to always pick the highest value.
- **Remove Colored Pieces**: Count possible moves for Alice and Bob.
- **Champagne Tower**: Use recursion with memoization for efficient calculation.

These problems demonstrate **greedy algorithms, game theory, and dynamic programming** approaches commonly used in competitive programming.

