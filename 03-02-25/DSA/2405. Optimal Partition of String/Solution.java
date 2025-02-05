import java.util.*;
class Solution {
  public int partitionString(String s) {
      int[]lastseen=new int[26];
      Arrays.fill(lastseen,-1);

      int count=0;

      int currstr=0;
      for(int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          if(lastseen[ch-'a']>=currstr){
              count++;
              currstr=i;
          }
          lastseen[ch-'a']=i;
      }return count+1;
  }
  
}