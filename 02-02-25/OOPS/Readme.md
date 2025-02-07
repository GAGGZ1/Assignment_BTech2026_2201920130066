# Ship Looting System

## Introduction
Ahoy matey! You are the leader of a small pirate crew, and your mission is to identify ships that are worth looting. This simple OOP-based system helps determine whether a ship is full of gold or just crew members.

## Problem Statement
Since crew members add weight to a ship, you need a method to check whether the ship's draft (total weight) minus the crew's weight is still high enough to indicate the presence of treasure. If the ship's adjusted draft is more than 20, it's worth looting!

## Implementation

### Ship Class
```java
public class Ship {
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
```
- **draft**: The total estimated weight of the ship.
- **crew**: The number of people on board.
- **isWorthIt()**: Determines if the ship is worth looting based on the condition `(draft - (1.5 * crew)) > 20`.

### Solution Class (Testing)
```java
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
```
- **emptyShipShouldNotWorthToAboard()**: Tests an empty ship (draft 0, crew 0), which should not be worth looting.
- **shipWithLotOfBootyWorthToAboard()**: Tests a ship with draft 40 and crew 5, which should be worth looting.

## Example Output
```
false - Ship with draft 0 and crew 0 should not be worth it.
true - Ship with draft 40 and crew 5 should be worth it.
```

## How to Run
1. Compile the Java file using:
   ```sh
   javac Ship.java Solution.java
   ```
2. Run the program using:
   ```sh
   java Solution
   ```

## Conclusion
This simple OOP-based system helps pirates determine whether a ship is worth looting. Happy looting, and may you find GOOOLD!