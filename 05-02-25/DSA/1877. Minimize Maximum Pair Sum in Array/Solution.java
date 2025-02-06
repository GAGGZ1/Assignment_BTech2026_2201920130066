import java.util.Arrays;
class Solution {
  public int minPairSum(int[] nums) {
      Arrays.sort(nums);
      int i=0;
      int j=nums.length-1;
      int res=0;
      while(i<j){
          int sum=nums[i]+nums[j];
          res=Math.max(sum,res);
          i++;
          j--;
      }
      return res;

  }
}