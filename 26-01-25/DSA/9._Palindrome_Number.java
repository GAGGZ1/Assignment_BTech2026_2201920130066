class Solution {
  public boolean isPalindrome(int x) {
      int rev = 0;
      int n2 = x;
      while (x > 0) {
          int num = x % 10;
          rev = rev * 10 + num;
          x = x / 10;
      }
      if (rev == n2) {
          return true;
      } else {
          return false;
      }
  }
}