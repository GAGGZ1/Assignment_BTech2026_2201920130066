# README

## Project Overview

This project contains solutions to three algorithmic problems, demonstrating various approaches to solve challenges in string manipulation, dynamic programming, and greedy algorithms.

---

### 1. Break a Palindrome

#### Problem
Given a palindromic string of lowercase English letters, replace exactly one character to make the resulting string not a palindrome and ensure it is the lexicographically smallest possible.

If no such replacement is possible, return an empty string.

#### Approach
1. If the string length is 1, return an empty string as it cannot be modified.
2. Convert the string to a character array for easy manipulation.
3. Traverse the first half of the string:
   - If a character is not 'a', change it to 'a' and return the modified string.
4. If no change has been made, replace the last character with 'b' to make it non-palindromic.
5. Return the modified string.

#### Solution
```java
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1)
            return "";

        char[] pal = palindrome.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (pal[i] != 'a') {
                pal[i] = 'a';
                return new String(pal);
            }
        }

        pal[n - 1] = 'b';
        return new String(pal);
    }
}
```

---

### 2. Minimum Difficulty of a Job Schedule

#### Problem
You are given an integer array `jobDifficulty` and an integer `d`. The difficulty of the ith job is `jobDifficulty[i]`. You want to schedule a list of jobs in `d` days such that at least one task is completed every day. The difficulty of a job schedule is the sum of difficulties of each day. The difficulty of a day is the maximum difficulty of the jobs done that day.

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs, return -1.

#### Approach
- First, check if there are fewer jobs than days, in which case return -1.
- Use dynamic programming (DP) to solve the problem by partitioning jobs into days while ensuring the difficulty is minimized.
- At each step, try to split the jobs and find the maximum difficulty for that day, and minimize the overall difficulty by considering different splits.

#### Solution
```java
class Solution {
    private int[][] dp;

    public int minDifficulty(int[] jd, int d) {
        if (jd.length < d) {
            return -1;
        }
        dp = new int[jd.length][d + 1]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(jd, jd.length, d, 0);
    }

    private int solve(int[] jd, int n, int d, int i) {
        if (d == 1) {
            int max = jd[i];
            for (int j = i; j < n; j++) {
                max = Math.max(jd[j], max);
            }
            return max;
        }

        if (dp[i][d] != -1) {
            return dp[i][d];
        }

        int max = jd[i];
        int fres = Integer.MAX_VALUE;

        for (int j = i; j <= n - d; j++) {
            max = Math.max(max, jd[j]);
            int res = max + solve(jd, n, d - 1, j + 1);
            fres = Math.min(res, fres);
        }

        return dp[i][d] = fres;
    }
}
```

---

### 3. Broken Calculator

#### Problem
There is a broken calculator that has the integer `startValue` on its display initially. In one operation, you can:

- Multiply the number on display by 2, or
- Subtract 1 from the number on display.

Given two integers `startValue` and `target`, return the minimum number of operations needed to display `target` on the calculator.

#### Approach
- If the target is greater than the start value, reduce the target by either dividing by 2 (if it's even) or adding 1 (if it's odd) until the target is less than or equal to the start value.
- Then, the remaining difference between `startValue` and `target` can be made up by subtraction operations.

#### Solution
```java
class Solution {
    public int brokenCalc(int s, int t) {
        int count = 0;
        while (t > s) {
            if (t % 2 == 0) {
                t /= 2;
            } else {
                t += 1;
            }
            count++;
        }
        return count + (s - t); // Add the remaining difference
    }
}
```

---

## Conclusion

This repository showcases efficient solutions to problems involving strings, dynamic programming, and greedy algorithms. Each problem is tackled with a detailed explanation of the approach, followed by the Java code implementation.