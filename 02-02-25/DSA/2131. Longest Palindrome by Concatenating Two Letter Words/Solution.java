import java.util.*;
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
