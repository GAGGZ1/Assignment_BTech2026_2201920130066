

# README

## Problem: Fraction Class (Hard)

### Description:
Implement a `Fraction` class with the following properties and functions.

### Properties:
1. **Numerator**: The numerator of the fraction.
2. **Denominator**: The denominator of the fraction.

### Functions:
1. **Parametrized Constructor**:
   - Initializes the fraction with a numerator and denominator.

2. **add**:
   - Adds the current fraction with another fraction, updating the current fraction.

3. **multiply**:
   - Multiplies the current fraction with another fraction, updating the current fraction.

4. **simplify**:
   - Simplifies the fraction by dividing both the numerator and denominator by their greatest common divisor (GCD).

5. **print**:
   - Prints the fraction in the format `numerator/denominator`.

### Example Usage:

```java
Fraction f1 = new Fraction(67, 14);
f1.add(new Fraction(2, 7));   // Adds f1 with 2/7
f1.multiply(new Fraction(3, 5));   // Multiplies f1 with 3/5
f1.print();   // Prints the simplified fraction
```

### Input/Output Format:

**Sample Input 1:**
```
67 14
1
2 7 78
```

**Sample Output 1:**
```
67/156
```

**Sample Input 2:**
```
47 71
3
1 91 78
2 67 75
1 36 74
```

**Sample Output 2:**
```
779/426
52193/31950
2506241/1182150
```

### Explanation:

- **Sample Input 1**: Initially, the fraction is `67/14`. After applying the multiplication operation with `7/78`, the fraction becomes `67/156`.
- **Sample Input 2**: The program performs a series of addition and multiplication operations on the fraction, updating and simplifying the result after each operation.

---

### Solution:

```java
import java.math.*;
import java.util.Scanner;

class Fraction {

    private int numerator;
    private int denominator;

    // Constructor to initialize the fraction
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Print the fraction in numerator/denominator format
    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }

    // Simplify the fraction by dividing by GCD
    void simplify() {
        int gcd = 1;
        for (int i = 1; i <= Math.min(numerator, denominator); i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    // Add another fraction to this fraction
    void add(Fraction f2) {
        int lcm = denominator * f2.denominator;
        int x = lcm / denominator;
        int y = lcm / f2.denominator;

        int num = x * numerator + (y * f2.numerator);

        numerator = num;
        denominator = lcm;
        simplify();
    }

    // Multiply this fraction with another fraction
    void multiply(Fraction f2) {
        numerator = numerator * f2.numerator;
        denominator = denominator * f2.denominator;
        simplify();
    }

}

class Solution {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int den1 = sc.nextInt();

        // Create the initial fraction
        Fraction f = new Fraction(num1, den1);
        int q = sc.nextInt();

        // Process the queries
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int num2 = sc.nextInt();
            int den2 = sc.nextInt();

            // Perform operations based on the query type
            if (type == 1) {  // Addition
                Fraction f2 = new Fraction(num2, den2);
                f.add(f2);
                f.print();
            } else if (type == 2) {  // Multiplication
                Fraction f2 = new Fraction(num2, den2);
                f.multiply(f2);
                f.print();
            }
        }
    }
}
```

### How It Works:

- The `Fraction` class is initialized with a numerator and denominator.
- The `add()` and `multiply()` methods update the current fraction by performing the respective operations.
- The `simplify()` method ensures the fraction is in its simplest form.
- The `print()` method displays the fraction in the `numerator/denominator` format.
