# README for Stock Trading Problems

## Problem 1: Best Time to Buy and Sell Stock
### Problem Statement
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day. Your goal is to maximize your profit by choosing a single day to buy one stock and a different day in the future to sell that stock. If no profit can be achieved, return 0.

### Solution
#### Java Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
```

#### Approach
1. Initialize `minPrice` to the largest possible value and `maxProfit` to 0.
2. Iterate through the array:
   - Update `minPrice` to the current price if it is lower than `minPrice`.
   - Calculate the profit by subtracting `minPrice` from the current price and update `maxProfit` if this profit is higher.
3. Return `maxProfit`.

---

## Problem 2: Best Time to Buy and Sell Stock II
### Problem Statement
You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i-th` day. You can buy and sell the stock multiple times but can only hold at most one share of the stock at any time. You can also buy and sell on the same day. Find and return the maximum profit you can achieve.

### Solution
#### Java Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
```

#### Approach
1. Initialize `profit` to 0.
2. Iterate through the array starting from the second day:
   - If the price on the current day is higher than the previous day, calculate the profit and add it to the total.
3. Return the total `profit`.

---

## Problem 3: Best Time to Buy and Sell Stock III
### Problem Statement
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day. Find the maximum profit you can achieve with at most two transactions. You cannot engage in multiple transactions simultaneously (i.e., you must sell before buying again).

### Solution
#### Java Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;

        for (int price : prices) {
            c1 = Math.min(c1, price);
            p1 = Math.max(p1, price - c1);
            c2 = Math.min(c2, price - p1);
            p2 = Math.max(p2, price - c2);
        }

        return p2;
    }
}
```

#### Approach
1. Initialize `c1` and `c2` as the minimum costs for the first and second transactions, respectively.
2. Initialize `p1` and `p2` as the maximum profits for the first and second transactions, respectively.
3. Iterate through the prices:
   - Update `c1` with the minimum cost for the first transaction.
   - Update `p1` with the maximum profit for the first transaction.
   - Update `c2` with the effective cost of the second transaction after deducting `p1`.
   - Update `p2` with the maximum profit for the second transaction.
4. Return `p2` as the maximum profit with at most two transactions.

---

## Notes
- These problems focus on dynamic programming and greedy approaches to optimize stock trading strategies.
- Ensure edge cases like empty or single-element arrays are handled appropriately in the implementations.

