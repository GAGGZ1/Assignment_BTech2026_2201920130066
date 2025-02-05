import java.util.*;
class Solution {

  public int maxDistance(List<List<Integer>> a) {
      int maxdiff = Integer.MIN_VALUE;
      int minElement = a.get(0).get(0);
      int maxElement = a.get(0).get(a.get(0).size() - 1);

      for (int i = 1; i < a.size(); i++) {
          int minCurrent = a.get(i).get(0);
          int maxCurrent = a.get(i).get(a.get(i).size() - 1);
          maxdiff = Math.max(maxdiff, Math.abs(minCurrent - maxElement));
          maxdiff = Math.max(maxdiff, Math.abs(maxCurrent - minElement));
          minElement = Math.min(minElement, minCurrent);
          maxElement = Math.max(maxElement, maxCurrent);
      }
      return maxdiff;
  }
}
