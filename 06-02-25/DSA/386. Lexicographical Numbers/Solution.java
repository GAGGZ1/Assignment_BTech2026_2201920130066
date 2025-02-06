import java.util.*;
class Solution {
  public List<Integer> lexicalOrder(int n) {
      List<Integer> res=new ArrayList<>();
      for(int startNum=1;startNum<=9;startNum++){
          solve(startNum,n,res);
      }
      return res;
  }
  public void solve(int curr,int n,List<Integer>res){
      if(curr>n){
          return ;
      }
      res.add(curr);
      for(int append=0;append<=9;append++){
          int newNum=curr*10+append;
          if(newNum>n){
              return;
          }
          solve(newNum,n,res);
      }
  }
}