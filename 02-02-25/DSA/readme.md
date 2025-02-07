
# README

## Problem 1: Stone Game II (Leetcode 1140)

### Approach:
- Use dynamic programming (DP) to simulate the game between Alice and Bob.
- Alternate between Alice and Bob's moves, maximizing or minimizing the number of stones taken, respectively.

### Solution:
```java
class Solution {
  private int n;
  private int[][][] dp;

  private int solveForAlice(int[] piles, int person, int i, int M) {
      if (i >= n) {
          return 0;
      }

      if (dp[person][i][M] != -1) {
          return dp[person][i][M];
      }

      int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      int stones = 0;

      for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
          stones += piles[i + x - 1];

          if (person == 1) {
              result = Math.max(result, stones + solveForAlice(piles, 0, i + x, Math.max(M, x)));
          } else {
              result = Math.min(result, solveForAlice(piles, 1, i + x, Math.max(M, x)));
          }
      }

      return dp[person][i][M] = result;
  }

  public int stoneGameII(int[] piles) {
      n = piles.length;
      dp = new int[2][n + 1][n + 1];

      for (int[][] layer : dp) {
          for (int[] row : layer) {
              Arrays.fill(row, -1);
          }
      }

      return solveForAlice(piles, 1, 0, 1);
  }
}
```

---

## Problem 2: Longest Palindrome by Concatenating Two Letter Words (Leetcode 2131)

### Approach:
- Use a HashMap to count occurrences of words.
- Handle cases where the word and its reverse can form a palindrome or the word itself can form a palindrome at the center.

### Solution:
```java
class Solution {
  public int longestPalindrome(String[] words) {
      Map<String, Integer> map = new HashMap<>();
      for (String word : words) {
          map.put(word, map.getOrDefault(word, 0) + 1);
      }
      boolean centerUsed = false; 
      int result = 0;
      for (String word : words) {
          String rev = new StringBuilder(word).reverse().toString();
          
          if (!rev.equals(word)) { // Case: "ab" "ba"
              if (map.getOrDefault(word, 0) > 0 && map.getOrDefault(rev, 0) > 0) {
                  map.put(word, map.get(word) - 1);
                  map.put(rev, map.get(rev) - 1);
                  result += 4;
              }
          } else { // Case: "cc" "cc"
              if (map.get(word) >= 2) {
                  map.put(word, map.get(word) - 2);
                  result += 4;
              } else if (map.get(word) == 1 && !centerUsed) {
                  map.put(word, map.get(word) - 1);
                  result += 2;
                  centerUsed = true; // Center word used
              }
          }
      }
      
      return result;
  }
}
```

---

## Problem 3: Flip String to Monotone Increasing (Leetcode 926)

### Approach:
- Use dynamic programming (DP) to calculate the minimum flips required to make the string monotone increasing.
- Track the flips based on the previous character value.

### Solution:
```java
class Solution {
  private int n;
  private int[][] dp;

  private int solve(String s, int currIndex, int prevVal) {
      if (currIndex >= n) {
          return 0;
      }

      if (dp[currIndex][prevVal] != -1) {
          return dp[currIndex][prevVal];
      }

      int flip = Integer.MAX_VALUE;
      int noFlip = Integer.MAX_VALUE;

      if (s.charAt(currIndex) == '0') {
          if (prevVal == 1) {
              flip = 1 + solve(s, currIndex + 1, 1);
          } else {
              flip = 1 + solve(s, currIndex + 1, 1);
              noFlip = solve(s, currIndex + 1, 0);
          }
      } else { // s.charAt(currIndex) == '1'
          if (prevVal == 1) {
              noFlip = solve(s, currIndex + 1, 1);
          } else {
              flip = 1 + solve(s, currIndex + 1, 0);
              noFlip = solve(s, currIndex + 1, 1);
          }
      }

      return dp[currIndex][prevVal] = Math.min(flip, noFlip);
  }

  public int minFlipsMonoIncr(String s) {
      n = s.length();
      dp = new int[n + 1][2];
      for (int[] row : dp) {
          Arrays.fill(row, -1);
      }
      return solve(s, 0, 0);
  }
}
```
