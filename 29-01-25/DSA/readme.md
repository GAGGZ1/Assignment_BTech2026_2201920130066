# Break a Palindrome

## Problem
Given a palindromic string of lowercase English letters, replace exactly one character to make the resulting string not a palindrome and ensure it is the lexicographically smallest possible.

If no such replacement is possible, return an empty string.

## Approach
1. If the string length is 1, return an empty string as it cannot be modified.
2. Convert the string to a character array for easy manipulation.
3. Traverse the first half of the string:
   - If a character is not 'a', change it to 'a' and return the modified string.
4. If no change has been made, replace the last character with 'b' to make it non-palindromic.
5. Return the modified string.

## Solution
```java
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
```

