# README: Problem Approach and Solution

### Problem 1: Minimum Rounds to Complete All Tasks

**Approach:**
- Count the frequency of each task using a HashMap.
- If any task appears less than 2 times, return -1 as it's not possible to complete the task in rounds.
- For tasks that appear 2 or more times:
  - Divide the frequency by 3 to calculate the minimum rounds.
  - If the frequency is not a multiple of 3, add 1 extra round.
  
**Solution:**
```java
import java.util.*;
class Solution {
  public int minimumRounds(int[] tasks) {
      int n = tasks.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
          map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
      }
      
      int count = 0;
      for (int freq : map.values()) {
          if (freq < 2) {
              return -1;  
          }
          
          count += freq / 3;
          if (freq % 3 != 0) {
              count++;
          }
      }
      
      return count;
  }
}
```

---

### Problem 2: Optimal Partition of String

**Approach:**
- Track the last seen position of each character in the string.
- If a character repeats, start a new partition.
- Count the partitions required for the string.

**Solution:**
```java
import java.util.*;
class Solution {
  public int partitionString(String s) {
      int[] lastseen = new int[26];
      Arrays.fill(lastseen, -1);

      int count = 0;
      int currstr = 0;
      for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          if (lastseen[ch - 'a'] >= currstr) {
              count++;
              currstr = i;
          }
          lastseen[ch - 'a'] = i;
      }
      return count + 1;
  }
}
```

---

### Problem 3: Largest Divisible Subset

**Approach:**
- Sort the array to make sure elements are checked in increasing order.
- Use dynamic programming (DP) to track the longest divisible subset.
- Maintain a `prev` array to help backtrack and reconstruct the subset.

**Solution:**
```java
import java.util.*;
class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
      int n = nums.length;
      if (n == 0)
          return new ArrayList<>();

      Arrays.sort(nums);
      int[] dp = new int[n];
      int[] prev = new int[n];
      Arrays.fill(dp, 1);
      Arrays.fill(prev, -1);

      int maxSize = 1;
      int maxIndex = 0;

      for (int i = 1; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                  dp[i] = dp[j] + 1;
                  prev[i] = j;
              }
          }
          if (dp[i] > maxSize) {
              maxSize = dp[i];
              maxIndex = i;
          }
      }

      List<Integer> result = new ArrayList<>();
      while (maxIndex != -1) {
          result.add(nums[maxIndex]);
          maxIndex = prev[maxIndex];
      }

      Collections.reverse(result);
      return result;
  }
}
```