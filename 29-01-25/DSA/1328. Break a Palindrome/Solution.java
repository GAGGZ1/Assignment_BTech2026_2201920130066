class Solution {
  public String breakPalindrome(String palindrome) {
      int n = palindrome.length();
      if (n == 1)
          return "";

      char[] pal = palindrome.toCharArray();

      for (int i = 0; i < n / 2; i++) {
          if (pal[i] != 'a') {
              pal[i] = 'a';
              return new String(pal);
          }
      }

      pal[n - 1] = 'b';
      return new String(pal);
  }
}
