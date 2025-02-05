class Solution {
  public int nthUglyNumber(int n) {
      int[] t = new int[n + 1];
      t[1] = 1; // 1st Ugly number

      int i2 = 1, i3 = 1, i5 = 1;

      for (int i = 2; i <= n; i++) {
          int i2th_ugly = t[i2] * 2;
          int i3rd_ugly = t[i3] * 3;
          int i5th_ugly = t[i5] * 5;

          // Find the minimum manually
          int minUgly = i2th_ugly;
          if (i3rd_ugly < minUgly) {
              minUgly = i3rd_ugly;
          }
          if (i5th_ugly < minUgly) {
              minUgly = i5th_ugly;
          }

          t[i] = minUgly;

          if (t[i] == i2th_ugly) {
              i2++;
          }
          if (t[i] == i3rd_ugly) {
              i3++;
          }
          if (t[i] == i5th_ugly) {
              i5++;
          }
      }
      return t[n];
  }
}
