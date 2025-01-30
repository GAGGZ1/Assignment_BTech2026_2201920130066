
---

# Java Method Overriding

## Problem Description

In Java, when a subclass inherits from a superclass, it can override the methods of the superclass to provide its own specific implementation. This allows the subclass to modify or extend the behavior of the inherited methods.

### Task:
- The problem provides a `Sports` class with a method `getName()` and a method `getNumberOfTeamMembers()`.
- The objective is to override the `getName()` method in the `Soccer` class to return a specific string "Soccer Class".
- Additionally, override the `getNumberOfTeamMembers()` method in the `Soccer` class to print the number of players for a Soccer team.

### Rules:
1. Use the `@Override` annotation when overriding methods.
2. The parameter(s) and return type of the overridden method must match those of the inherited method.

### Output:

When the code is executed, the following output should be produced:

```
Generic Sports
Each team has n players in Generic Sports
Soccer Class
Each team has 11 players in Soccer Class
```

## Solution

```java
import java.util.*;

class Sports {
    String getName(){
        return "Generic Sports";
    }

    void getNumberOfTeamMembers(){
        System.out.println("Each team has n players in " + getName());
    }
}

class Soccer extends Sports {
    @Override
    String getName() {
        return "Soccer Class";
    }

    @Override
    void getNumberOfTeamMembers() {
        System.out.println("Each team has 11 players in " + getName());
    }
}

public class Solution {
    public static void main(String[] args) {
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }
}
```

## Explanation:

- The `Sports` class defines two methods: `getName()` and `getNumberOfTeamMembers()`.
- The `Soccer` class inherits from `Sports` and overrides both methods.
- The overridden `getName()` method returns "Soccer Class" instead of "Generic Sports".
- The overridden `getNumberOfTeamMembers()` method prints the number of players in a soccer team (11) instead of the generic "n players".

## How to Run:

1. Save the code in a file named `Solution.java`.
2. Compile the Java file:
   ```
   javac Solution.java
   ```
3. Run the program:
   ```
   java Solution
   ```

---

