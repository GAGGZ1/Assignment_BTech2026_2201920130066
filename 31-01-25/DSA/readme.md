
---

# README

## 1. [446. Arithmetic Slices II - Subsequence](https://leetcode.com/problems/arithmetic-slices-ii-subsequence/)
**Difficulty**: Hard

### Problem:
Given an integer array `nums`, return the number of all the arithmetic subsequences of `nums`. A sequence is arithmetic if it has at least three elements and the difference between any two consecutive elements is the same.

### Approach:
- Use dynamic programming with hash maps to keep track of the count of subsequences that end at each index for a given difference.
- For each pair `(i, j)`, calculate the difference `diff` and update the count of subsequences ending at index `i` for that `diff`.
- The key idea is to use the counts from previous indices (stored in the hash map) to efficiently update the current index.

### Solution:
```java
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        List<HashMap<Long, Integer>> mp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mp.add(new HashMap<>());
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int count_at_j = mp.get(j).getOrDefault(diff, 0);
                result += count_at_j;
                mp.get(i).put(diff, mp.get(i).getOrDefault(diff, 0) + count_at_j + 1);
            }
        }
        return result;
    }
}
```

---

## 2. [2554. Maximum Number of Integers to Choose From a Range I](https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/)
**Difficulty**: Medium

### Problem:
You are given an integer array `banned` and two integers `n` and `maxSum`. You are choosing integers from the range `[1, n]` such that:
- The integers are not in the `banned` array.
- The sum of the integers does not exceed `maxSum`.

Return the maximum number of integers you can choose following these rules.

### Approach:
- Use a `HashSet` to store the banned integers for O(1) lookups.
- Iterate through the range `[1, n]`, summing up the numbers not in the `banned` array and ensuring the sum does not exceed `maxSum`.

### Solution:
```java
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && sum + i <= maxSum) {
                count++;
                sum += i;
            }
        }
        return count;
    }
}
```

---

## 3. [1833. Maximum Ice Cream Bars](https://leetcode.com/problems/maximum-ice-cream-bars/)
**Difficulty**: Medium

### Problem:
A boy wants to buy as many ice cream bars as possible with a given amount of coins. Each bar has a price, and he can buy them in any order. Return the maximum number of ice cream bars he can buy without exceeding his coin limit.

### Approach:
- Use a greedy algorithm: sort the costs in ascending order and buy ice cream bars starting from the cheapest. Stop when the remaining coins are insufficient to buy the next bar.

### Solution:
```java
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                coins -= costs[i];
                count++;
            }
        }
        return count;
    }
}
```

---
