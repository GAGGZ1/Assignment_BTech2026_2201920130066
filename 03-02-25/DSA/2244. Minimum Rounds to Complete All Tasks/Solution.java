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
