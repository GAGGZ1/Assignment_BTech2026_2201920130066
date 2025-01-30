# README

## Problem 1: Minimum Time to Make Rope Colorful
**Problem:**  
Alice has n balloons arranged on a rope. You are given a string `colors` representing the color of each balloon, and an array `neededTime` representing the time to remove each balloon. The task is to minimize the time required to make the rope colorful, ensuring no two consecutive balloons have the same color.

**Approach:**  
Iterate over the `colors` array. For each pair of consecutive balloons with the same color, remove the balloon with the lesser removal time and accumulate the time. Update the `prev` index to the current balloon after removal.

**Solution:**
```java
public int minCost(String colors, int[] neededTime) {
    int prev = 0;
    int ans = 0;
    char[] arr = colors.toCharArray();
    for (int i = 1; i < arr.length; i++) {
        if (arr[prev] != arr[i]) {
            prev = i;
        } else {
            if (neededTime[prev] < neededTime[i]) {
                ans += neededTime[prev];
                prev = i;
            } else {
                ans += neededTime[i];
            }
        }
    }
    return ans;
}
```

---

## Problem 2: Maximum Length of a Concatenated String with Unique Characters
**Problem:**  
You are given an array of strings. The goal is to form a string by concatenating a subsequence of the input array such that the string contains only unique characters, and you need to find the maximum length of such a string.

**Approach:**  
Use backtracking to explore all subsequences of the array. For each subsequence, check if it has unique characters and track the maximum length. A hash map is used for memoization to store results for previously computed subsequences.

**Solution:**
```java
public class Solution {
    public boolean hasCommon(String s1, String s2) {
        int[] arr = new int[26];
        for (char ch : s1.toCharArray()) {
            if (arr[ch - 'a'] > 0) return true;
            arr[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            if (arr[ch - 'a'] > 0) return true;
        }
        return false;
    }

    private Map<StringBuilder, Integer> mp = new HashMap<>();

    public int solve(int idx, List<String> arr, StringBuilder temp, int n) {
        if (idx >= n) return temp.length();
        if (mp.containsKey(temp)) return mp.get(temp);
        
        int include = 0, exclude = 0;
        if (hasCommon(arr.get(idx), temp.toString())) {
            exclude = solve(idx + 1, arr, temp, n);
        } else {
            exclude = solve(idx + 1, arr, temp, n);
            StringBuilder newTemp = new StringBuilder(temp);
            include = solve(idx + 1, arr, newTemp.append(arr.get(idx)), n);
        }
        mp.put(temp, Math.max(include, exclude));
        return mp.get(temp);
    }

    public int maxLength(List<String> arr) {
        return solve(0, arr, new StringBuilder(), arr.size());
    }
}
```

---

## Problem 3: Maximum Bags With Full Capacity of Rocks
**Problem:**  
You are given `n` bags, each with a capacity to hold a certain number of rocks and the current number of rocks in each bag. Additionally, you are given the number of extra rocks you can place in the bags. The task is to determine the maximum number of bags that can be filled to their full capacity.

**Approach:**  
Calculate the remaining capacity of each bag. Sort the bags by the remaining capacity and start filling them with the additional rocks. Track how many bags are filled to full capacity.

**Solution:**
```java
public int maximumBags(int[] c, int[] r, int ad) {
    int n = c.length;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = Math.abs(c[i] - r[i]);
    }
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
        if (ad > 0 && ad >= arr[i]) {
            ad -= arr[i];
            arr[i] = 0;
        }
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] == 0) {
            count++;
        }
    }
    return count;
}
```