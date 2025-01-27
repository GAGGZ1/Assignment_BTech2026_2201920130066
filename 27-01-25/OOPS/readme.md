

---

### README

# Arithmetic and Adder Classes Implementation

This project demonstrates the implementation of inheritance in Java by defining two classes: `Arithmetic` and `Adder`.

## Problem Description

The goal is to:
1. Create a class `Arithmetic` with:
   - A method `add(int n1, int n2)` that takes two integers as parameters and returns their sum.
2. Create a class `Adder` that:
   - Inherits from the `Arithmetic` class without adding any new methods or fields.

You do not need to handle input or output directly. A locked stub in the main method will:
- Create an `Adder` object.
- Call the `add` method with integer arguments.
- Print the superclass name of `Adder` and the results of multiple calls to `add`.

---

## Solution Overview

### Classes and Methods

1. **`Arithmetic` Class**:
   - Contains the `add(int n1, int n2)` method to return the sum of two integers.

2. **`Adder` Class**:
   - Inherits from the `Arithmetic` class.
   - Reuses the `add` method from its superclass without redefining or modifying it.

3. **`Solution` Class**:
   - Includes the `main` method where:
     - An instance of `Adder` is created.
     - The name of the superclass (`Arithmetic`) is retrieved using reflection.
     - The `add` method is called multiple times, and the results are displayed.

---

## Code

```java
import java.io.*;
import java.util.*;

// Base class
class Arithmetic {
    // Method to add two integers
    int add(int n1, int n2) {
        return n1 + n2;
    }
}

// Subclass
class Adder extends Arithmetic {
    // No additional methods or properties required
}

// Main class
public class Solution {
    public static void main(String[] args) {
        // Create an Adder object
        Adder adder = new Adder();
        
        // Print the name of the superclass
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());
        
        // Call the add method and print results
        System.out.print(adder.add(10, 32) + " " + adder.add(10, 3) + " " + adder.add(10, 10));
    }
}
```

---

## Sample Output

When the program runs, it outputs:

```
My superclass is: Arithmetic
42 13 20
```

### Explanation:
1. **Line 1**: Displays the name of the superclass (`Arithmetic`).
2. **Line 2**: Prints the results of calling the `add` method with:
   - \( 10 + 32 = 42 \)
   - \( 10 + 3 = 13 \)
   - \( 10 + 10 = 20 \)

---

## Key Concepts

1. **Inheritance**:
   - The `Adder` class inherits the `add` method from the `Arithmetic` class, demonstrating code reuse.

2. **Superclass Identification**:
   - The reflection method `getClass().getSuperclass().getName()` is used to determine the name of the superclass.

3. **Encapsulation**:
   - The `add` method encapsulates the addition logic, making it reusable.

---

## How to Run

1. Copy the code into a file named `Solution.java`.
2. Compile the file:
   ```bash
   javac Solution.java
   ```
3. Run the compiled file:
   ```bash
   java Solution
   ```

This implementation adheres to the problem requirements and demonstrates the use of inheritance effectively.