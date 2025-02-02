class Ship {
  private final double draft;
  private final int crew;

  public Ship(double draft, int crew) {
      this.draft = draft;
      this.crew = crew;
  }

  public boolean isWorthIt() {
      return (draft - (1.5 * crew)) > 20;
  }
}

class Solution {
  public void emptyShipShouldNotWorthToAboard() {
      Ship ship = new Ship(0, 0);
      System.out.println(ship.isWorthIt() + " - Ship with draft 0 and crew 0 should not be worth it.");
  }

  public void shipWithLotOfBootyWorthToAboard() {
      Ship ship = new Ship(40, 5);
      System.out.println(ship.isWorthIt() + " - Ship with draft 40 and crew 5 should be worth it.");
  }

  public static void main(String[] args) {
      Solution solution = new Solution();
      solution.emptyShipShouldNotWorthToAboard();
      solution.shipWithLotOfBootyWorthToAboard();
  }
}
