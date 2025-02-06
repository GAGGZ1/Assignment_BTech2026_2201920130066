
# Problem Solutions

## 1. **Count of Matches in Tournament** (Leetcode #1688)
### Approach:
- The problem involves calculating the number of matches played in a tournament with `n` teams. 
- If the number of teams is even, each team is paired with another, and half the teams advance.
- If the number of teams is odd, one team advances automatically, and the remaining teams are paired.
- The total matches played are `n - 1` because every match eliminates one team until only one remains.

### Solution:
```java
class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}
```

---

## 2. **Largest Odd Number in String** (Leetcode #1903)
### Approach:
- The task is to find the largest odd number in the given string representation of a large integer.
- A valid odd number ends with an odd digit (1, 3, 5, 7, or 9). 
- Traverse the string from the end and check if the character is an odd digit. If so, return the substring up to that character.

### Solution:
```java
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if ((ch - '0') % 2 == 1) { // Check if the digit is odd
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
```

---

## 3. **Largest 3-Same-Digit Number in String** (Leetcode #2264)
### Approach:
- The problem requires finding the largest 3-digit substring in the string `num` where all digits are the same.
- A substring is valid if it consists of exactly three identical digits.
- Loop through the string, check each 3-character substring, and compare it to find the largest one.

### Solution:
```java
class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                if (maxGood.isEmpty() || sub.compareTo(maxGood) > 0) {
                    maxGood = sub;
                }
            }
        }
        return maxGood;
    }
}
```

--- 
