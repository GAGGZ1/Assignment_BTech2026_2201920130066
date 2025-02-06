import java.util.*;
class Solution {
  public String predictPartyVictory(String senate) {
      Queue<Integer> radiant = new LinkedList<>();
      Queue<Integer> dire = new LinkedList<>();
      int n = senate.length();

      // Assign each senator's index to their respective queue
      for (int i = 0; i < n; i++) {
          if (senate.charAt(i) == 'R') {
              radiant.add(i);
          } else {
              dire.add(i);
          }
      }

      // Process banning
      while (!radiant.isEmpty() && !dire.isEmpty()) {
          int rIndex = radiant.poll();
          int dIndex = dire.poll();

          // The senator who comes first in the cycle gets to ban the opponent
          if (rIndex < dIndex) {
              radiant.add(rIndex + n);
          } else {
              dire.add(dIndex + n);
          }
      }

      return radiant.isEmpty() ? "Dire" : "Radiant";
  }
}
