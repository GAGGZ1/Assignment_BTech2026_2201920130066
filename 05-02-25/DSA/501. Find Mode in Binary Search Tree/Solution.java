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
