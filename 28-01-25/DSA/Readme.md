
---

# Problem Solutions

## 1. **881. Boats to Save People**

### Problem Description
You are given an array `people` where each element represents the weight of a person, and a `limit` representing the maximum weight a boat can carry. Each boat can carry at most two people at a time, as long as their combined weight is less than or equal to `limit`.

The task is to return the minimum number of boats required to carry all the people.

### Approach
1. **Sort the Array**: Begin by sorting the array `people` to efficiently pair the lightest and heaviest individuals together.
2. **Two Pointers Technique**: Use two pointers: one starting at the lightest person (`i = 0`) and the other at the heaviest person (`j = n-1`).
3. **Pairing Logic**:
   - If the sum of the weights of the two people at pointers `i` and `j` is within the limit, both can share a boat. Move both pointers inward.
   - Otherwise, send the heaviest person alone by moving the `j` pointer inward.
4. **Counting Boats**: Each time either of the conditions is satisfied, increment the boat counter.

### Solution
```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int n = people.length;
        int j = n - 1;
        int boats = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            boats++;
        }
        return boats;
    }
}
```

---

## 2. **948. Bag of Tokens**

### Problem Description
You start with an initial power of `power`, an initial score of `0`, and a bag of tokens given as an integer array `tokens`. Your goal is to maximize the total score by strategically playing these tokens. You can either play a token face-up (lose power, gain score) or face-down (lose score, gain power).

The task is to return the maximum possible score after playing the tokens.

### Approach
1. **Sort Tokens**: First, sort the tokens in increasing order to easily determine which token to play face-up or face-down.
2. **Two Pointers**: Use two pointers, `i` and `j`, where `i` starts at the beginning (smallest tokens) and `j` starts at the end (largest tokens).
3. **Play Tokens**:
   - Face-up: If the current power is enough to play the token at `i`, play it face-up, increase score, and decrease power.
   - Face-down: If the current score is at least 1, play the token at `j` face-down to increase power.
4. **Maximize Score**: Continue this process until no more tokens can be played.

### Solution
```java
class Solution {
    public int bagOfTokensScore(int[] t, int p) {
        int n = t.length;
        int maxS = 0;
        Arrays.sort(t);
        int i = 0;
        int j = n - 1;
        int s = 0;
        while (i <= j) {
            if (p >= t[i]) {
                p -= t[i];
                s++;
                i++;
                maxS = Math.max(s, maxS);
            } else if (s >= 1) {
                p += t[j];
                s--;
                j--;
            } else {
                return maxS;
            }
        }
        return maxS;
    }
}
```

---

## 3. **309. Best Time to Buy and Sell Stock with Cooldown**

### Problem Description
You are given an array `prices` where `prices[i]` is the price of a given stock on the ith day. You need to find the maximum profit you can achieve by completing multiple transactions, with the restriction that you cannot buy a stock on the next day after selling it (cooldown for one day).

The task is to return the maximum profit achievable with the given restrictions.

### Approach
1. **Dynamic Programming with Memoization**: Use a recursive function with memoization to store the results of subproblems.
2. **State Transitions**:
   - If we are allowed to buy, either buy the stock on day `i` or skip.
   - If we are not allowed to buy (because we sold the stock), either sell the stock on day `i` or move to the next day (cooldown).
3. **Base Case**: If all days are processed, return a profit of 0.
4. **Maximize Profit**: Use recursion to calculate the maximum profit by choosing the optimal transaction at each step.

### Solution
```java
class Solution {
    private HashMap<String, Integer> dp;

    public int maxProfit(int[] prices) {
        dp = new HashMap<>();
        return dfs(prices, 0, true); // Start with the first day, and we are allowed to buy
    }

    private int dfs(int[] prices, int i, boolean buying) {
        // Base case: If we have processed all prices, return 0 profit
        if (i >= prices.length) {
            return 0;
        }

        // Check if this state has already been computed
        String key = i + "," + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Cooldown case: Just move to the next day without doing anything
        int cooldown = dfs(prices, i + 1, buying);

        int result;
        if (buying) {
            // Option to buy: We buy on day i, and the next step will be to sell
            int buy = dfs(prices, i + 1, false) - prices[i];
            result = Math.max(buy, cooldown); // Maximize between buying or cooling down
        } else {
            // Option to sell: We sell on day i and skip the next day for cooldown
            int sell = dfs(prices, i + 2, true) + prices[i];
            result = Math.max(sell, cooldown); // Maximize between selling or cooling down
        }

        // Save the result for the current state
        dp.put(key, result);
        return result;
    }
}
```

---

### Summary
This README provides the problem descriptions, approach, and Java solutions for three distinct problems involving arrays, dynamic programming, and greedy algorithms. The solutions maximize efficiency using techniques like sorting, recursion with memoization, and two-pointer strategies.