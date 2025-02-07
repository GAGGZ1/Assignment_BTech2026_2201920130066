# README for Problem Solutions

### 1. **649. Dota2 Senate**
**Approach**:
- The problem is modeled as a simulation where senators from two factions (Radiant and Dire) ban each other in a turn-based fashion.
- Two queues are used to manage the senators from both factions.
- We loop until one of the factions runs out of senators. In each cycle, the senator who comes first bans the opponent, and the banned senator is removed from the cycle.
  
**Solution**:
```java
import java.util.*;

class Solution {
  public String predictPartyVictory(String senate) {
      Queue<Integer> radiant = new LinkedList<>();
      Queue<Integer> dire = new LinkedList<>();
      int n = senate.length();

      // Assign each senator's index to their respective queue
      for (int i = 0; i < n; i++) {
          if (senate.charAt(i) == 'R') {
              radiant.add(i);
          } else {
              dire.add(i);
          }
      }

      // Process banning
      while (!radiant.isEmpty() && !dire.isEmpty()) {
          int rIndex = radiant.poll();
          int dIndex = dire.poll();

          // The senator who comes first in the cycle gets to ban the opponent
          if (rIndex < dIndex) {
              radiant.add(rIndex + n);
          } else {
              dire.add(dIndex + n);
          }
      }

      return radiant.isEmpty() ? "Dire" : "Radiant";
  }
}
```

---

### 2. **714. Best Time to Buy and Sell Stock with Transaction Fee**
**Approach**:
- This problem is solved using dynamic programming with a DFS approach.
- We maintain a recursive function to calculate the maximum profit with a cooldown period for both buying and selling.
- A hashmap (`dp`) is used to store the results of previously computed states to avoid recalculating.

**Solution**:
```java
import java.util.HashMap;

class Solution {
  private HashMap<String, Integer> dp;
  private int fee;

  public int maxProfit(int[] prices, int fee) {
      this.dp = new HashMap<>();
      this.fee = fee;
      return dfs(prices, 0, true);
  }

  private int dfs(int[] prices, int i, boolean buying) {
      if (i >= prices.length) {
          return 0;
      }
      String key = i + "," + buying;
      if (dp.containsKey(key)) {
          return dp.get(key);
      }
      int cooldown = dfs(prices, i + 1, buying);

      int result;
      if (buying) {
          int buy = dfs(prices, i + 1, false) - prices[i];
          result = Math.max(buy, cooldown);
      } else {
          int sell = dfs(prices, i + 1, true) + prices[i] - fee;
          result = Math.max(sell, cooldown);
      }
      dp.put(key, result);
      return result;
  }
}
```

---

### 3. **790. Domino and Tromino Tiling**
**Approach**:
- This problem is solved using dynamic programming with memoization.
- We use an array `dp` to store intermediate results for each length `n`, representing the number of ways to tile a 2xN board.
- The formula used is based on the recurrence relation considering the placement of 1x2 tiles or 2x2 tiles.
  
**Solution**:
```java
class Solution {
  int[] dp = new int[1001];
  int m = 1000000007;

  public Solution() {
      for (int i = 0; i < dp.length; i++) {
          dp[i] = -1;
      }
  }

  public int numTilings(int n) {
      return solve(n);
  }

  public int solve(int n) {
      if (n == 1 || n == 2) {
          return n;
      }
      if (n == 3) {
          return 5;
      }
      if (dp[n] != -1) {
          return dp[n];
      }
      return dp[n] = (2 * solve(n - 1) % m + solve(n - 3) % m) % m;
  }
}
```

---