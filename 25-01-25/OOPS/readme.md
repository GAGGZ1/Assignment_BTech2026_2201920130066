# Complex Number Class

## Problem Statement
A `ComplexNumbers` class contains two integer data members: the real part (R) and the imaginary part (I). The class should provide the following functionalities:

1. **Constructor** - Initializes the complex number with given real and imaginary parts.
2. **plus()** - Adds another complex number to the current complex number.
3. **multiply()** - Multiplies another complex number with the current complex number.
4. **print()** - Displays the complex number in the format: `a + ib`.

## Approach
- Use a constructor to initialize the real and imaginary parts.
- Implement `plus()` to add two complex numbers and update the first number.
- Implement `multiply()` to multiply two complex numbers and update the first number.
- Implement `print()` to display the complex number in the correct format.

## Solution (Java Implementation)
```java
import java.util.*;
import java.io.*;
import java.util.Scanner;

class ComplexNumbers {
    int r, i;
    
    ComplexNumbers(int r, int i) {
        this.r = r;
        this.i = i;
    }
    
    void add(ComplexNumbers c1) {
        r = r + c1.r;
        i = i + c1.i;
    }
    
    void multiply(ComplexNumbers c1) {
        int temp1 = r;
        int temp2 = i;
        r = r * c1.r - i * c1.i;
        i = temp1 * c1.i + temp2 * c1.r;
    }
    
    void print() {
        if (i < 0) {
            System.out.print(r + "-i" + (-i));
        } else {
            System.out.println(r + " + i" + i);
        }
    }
}

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int i1 = sc.nextInt();
        ComplexNumbers c1 = new ComplexNumbers(r1, i1);

        int r2 = sc.nextInt();
        int i2 = sc.nextInt();
        ComplexNumbers c2 = new ComplexNumbers(r2, i2);

        int t = sc.nextInt();
        if (t == 1) {
            c1.add(c2);
            c1.print();
        } else if (t == 2) {
            c1.multiply(c2);
            c1.print();
        }
    }
}
```

## Sample Input/Output
**Input 1:**
```
4 5
6 7
1
```
**Output 1:**
```
10 + i12
```

**Input 2:**
```
4 5
6 7
2
```
**Output 2:**
```
-11 + i58
```
