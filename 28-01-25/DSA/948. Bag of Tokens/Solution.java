import java.util.*;
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