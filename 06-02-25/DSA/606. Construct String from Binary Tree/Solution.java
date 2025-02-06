// Definition for a binary tree node
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
