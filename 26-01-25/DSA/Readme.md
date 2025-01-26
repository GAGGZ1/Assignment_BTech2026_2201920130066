
---

## Coding Platforms Used
- All problems are sourced from **LeetCode**, a widely-used competitive programming platform for practicing coding problems.

---



## Problem Statements

### Problem 1: Target Sum
- **Problem Statement**:  
  You are given an integer array `nums` and an integer `target`. You want to build an expression out of `nums` by adding one of the symbols `+` and `-` before each integer in `nums` and then concatenating all the integers.  
  For example, if `nums = [2, 1]`, you can add a `+` before 2 and a `-` before 1 and concatenate them to build the expression "+2-1".  
  Return the number of different expressions that you can build, which evaluates to `target`.

- **Solution**:  
  - **Approach**:  
    - Use **Dynamic Programming (DP)** to solve this problem. Consider each number as two choices, either adding or subtracting it.
    - Maintain a DP array where `dp[i]` stores the number of ways to achieve a sum `i`.
    - Iterate through the list and update the DP table to account for both `+` and `-` operations on each element.

---

### Problem 2: Palindrome Number
- **Problem Statement**:  
  Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise. A number is a palindrome if it reads the same backward as forward.

- **Solution**:  
  - **Approach**:  
    - If the number `x` is negative, return `false` immediately.
    - Reverse the second half of the number and check if it equals the first half. For even-length numbers, this works directly; for odd-length numbers, we ignore the middle digit.

---

### Problem 3: Integer Break
- **Problem Statement**:  
  Given an integer `n`, break it into the sum of `k` positive integers, where `k >= 2`, and maximize the product of those integers.  
  Return the maximum product you can get.

- **Solution**:  
  - **Approach**:  
    - Use **Dynamic Programming** to break the integer `n` into a sum of integers. For each possible split of `n`, maximize the product of the resulting integers.
    - Iterate through possible splits and update the product accordingly.

---