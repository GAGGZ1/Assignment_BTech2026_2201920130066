

# Problem Solutions

## 1. Count Nice Pairs in an Array

### Problem Description:
Given an array `nums`, you need to count the number of pairs `(i, j)` where `nums[i] - reverse(nums[i]) == nums[j] - reverse(nums[j])`. The function returns the count of such nice pairs modulo `1000000007`.

### Approach:
- For each element in `nums`, compute the difference `nums[i] - reverse(nums[i])`.
- Store the occurrences of each difference in a hash map.
- Count the pairs using the values from the map, and sum them up.

### Solution:
```java
import java.util.*;

class Solution {
    final int M = 1000000007;

    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return rev;
    }

    public int countNicePairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - reverse(nums[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = (int) ((result + mp.getOrDefault(nums[i], 0)) % M);
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        return result;
    }
}
```

---

## 2. Lexicographical Numbers

### Problem Description:
Given an integer `n`, return all the numbers from `1` to `n` in lexicographical order.

### Approach:
- Start from `1` and recursively construct numbers by appending digits `0-9` to the current number.
- Ensure that the number does not exceed `n`.

### Solution:
```java
import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int startNum = 1; startNum <= 9; startNum++) {
            solve(startNum, n, res);
        }
        return res;
    }

    public void solve(int curr, int n, List<Integer> res) {
        if (curr > n) {
            return;
        }
        res.add(curr);
        for (int append = 0; append <= 9; append++) {
            int newNum = curr * 10 + append;
            if (newNum > n) {
                return;
            }
            solve(newNum, n, res);
        }
    }
}
```

---

## 3. Construct String from Binary Tree

### Problem Description:
Given a binary tree, construct a string consisting of parentheses and integers to represent the tree structure. Each node's value will be represented, and the structure should display the left and right child nodes when they exist.

### Approach:
- Traverse the binary tree and recursively construct the string representation.
- Handle the cases for missing children properly to ensure correct formatting.

### Solution:
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = Integer.toString(root.val);
        String l = tree2str(root.left);
        String r = tree2str(root.right);

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.right == null) {
            return result + "(" + l + ")";
        }

        if (root.left == null) {
            return result + "()" + "(" + r + ")";
        }

        return result + "(" + l + ")" + "(" + r + ")";
    }

    // Helper method to test the function
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
                            new TreeNode(2, new TreeNode(4), null), 
                            new TreeNode(3));

        Solution solution = new Solution();
        System.out.println(solution.tree2str(root)); // Output: "1(2(4))(3)"
    }
}
```
