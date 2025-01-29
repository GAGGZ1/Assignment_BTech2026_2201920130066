class Solution {
  public int brokenCalc(int s, int t) {
      int count = 0;
      while (t > s) {
          if (t % 2 == 0) {
              t /= 2;
          } else {
              t += 1;
          }
          count++;
      }
      return count + (s - t); // Add the remaining difference
  }
}
