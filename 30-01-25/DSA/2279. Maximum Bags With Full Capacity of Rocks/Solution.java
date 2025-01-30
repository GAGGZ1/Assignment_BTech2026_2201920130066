import java.util.*;
class Solution {
  public int maximumBags(int[] c, int[] r, int ad) {
      int n=c.length;
      int []arr=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=Math.abs(c[i]-r[i]);
      }
      Arrays.sort(arr);
      for(int i=0;i<n;i++){
          if(ad>0 && ad>=arr[i]){//ad=5 arr=4
              
              ad=ad-arr[i];arr[i]=0;
              
          }
      }
      int count=0;
      for(int i=0;i<n;i++){
          if(arr[i]==0){
              count++;
          }
      }
      return count;
  }
}