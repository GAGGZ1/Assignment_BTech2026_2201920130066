# README for Problem Solutions

### 1. **1750. Minimum Length of String After Deleting Similar Ends**
**Approach**:
- The problem involves removing similar characters from both ends of the string until no more similar characters are found at the ends.
- Two pointers (`i` and `j`) are used to traverse from the left and right, respectively.
- The solution iterates through the string, checking for identical characters at the ends, and removing them until the pointers converge.
  
**Solution**:
```java
class Solution {
  public int minimumLength(String s) {
      int n = s.length();
      int i = 0;
      int j = n - 1;
      while (i < j && s.charAt(i) == s.charAt(j)) {
          char ch = s.charAt(i);
          while (i < j && s.charAt(i) == ch) {
              i++;
          }
          while (j >= i && s.charAt(j) == ch) {
              j--;
          }
      }
      return j - i + 1;
  }
}
```

---

### 2. **1877. Minimize Maximum Pair Sum in Array**
**Approach**:
- The solution involves sorting the array and then pairing elements from the smallest and largest ends to minimize the maximum pair sum.
- After sorting, we use two pointers (`i` and `j`) to traverse the array from both ends and compute the pair sums, keeping track of the maximum sum.

**Solution**:
```java
import java.util.Arrays;

class Solution {
  public int minPairSum(int[] nums) {
      Arrays.sort(nums);
      int i = 0;
      int j = nums.length - 1;
      int res = 0;
      while (i < j) {
          int sum = nums[i] + nums[j];
          res = Math.max(sum, res);
          i++;
          j--;
      }
      return res;
  }
}
```

---

### 3. **501. Find Mode in Binary Search Tree**
**Approach**:
- The problem is solved using an in-order traversal of the Binary Search Tree (BST).
- The solution keeps track of the current streak of values and updates the result list when the streak exceeds the previous maximum.
- A depth-first search (DFS) is employed to traverse the tree and calculate the mode(s) efficiently.

**Solution**:
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int currNum = 0;
    private int currStreak = 0;
    private int maxStreak = 0;
    private List<Integer> result = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (root.val == currNum) {
            currStreak++;
        } else {
            currNum = root.val;
            currStreak = 1;
        }

        if (currStreak > maxStreak) {
            result.clear();
            maxStreak = currStreak;
        }

        if (currStreak == maxStreak) {
            result.add(root.val);
        }

        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        Solution sol = new Solution();
        int[] modes = sol.findMode(root);

        System.out.println("Mode(s) of the BST: " + Arrays.toString(modes));
    }
}
```

---
