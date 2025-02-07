

## Polynomial Class

### Problem Statement

Implement a polynomial class with the following properties and functions.

### Properties:
1. An integer array `A[]` where each index represents the degree, and `A[i]` represents the coefficient of that degree.
2. An integer holding the total size of the array `A[]`.

### Functions:
1. **Default constructor** – Initializes a polynomial with zero coefficients.
2. **Copy constructor** – Creates a copy of an existing polynomial.
3. **setCoefficient** – Sets the coefficient for a specific degree. If the degree exceeds the current size, the array is resized accordingly.
4. **Overload "+" operator** – Adds two polynomials and returns the result.
5. **Overload "-" operator** – Subtracts two polynomials and returns the result.
6. **Overload "*" operator** – Multiplies two polynomials and returns the result.
7. **Overload "=" operator** – Assigns one polynomial to another.
8. **print()** – Prints all non-zero terms of the polynomial in the format `<coefficient>x<degree>`. Multiple terms should be separated by spaces.

### Example Usage

#### Sample Input:
```
3
1 3 5
1 2 -4
4
0 1 2 3
4 2 -3 1
1
```

#### Sample Output:
```
4x0 3x1 -3x2 3x3 -4x5
```

### Code Implementation

```java
// Polynomial class implementation

class Polynomial {
    public int[] coef;  
    public int deg;     

    // Constructor to initialize the polynomial
    public Polynomial(int a, int b) {
        coef = new int[b + 1];
        coef[b] = a;
        deg = degree();
    }

    // Copy constructor
    public Polynomial(Polynomial p) {
        coef = new int[p.coef.length];
        for (int i = 0; i < p.coef.length; i++) {
            coef[i] = p.coef[i];
        }
        deg = p.degree();
    }

    // Degree of the polynomial
    public int degree() {
        int d = 0;
        for (int i = 0; i < coef.length; i++)
            if (coef[i] != 0) d = i;
        return d;
    }

    // Add two polynomials
    public Polynomial plus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
        for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
        for (int i = 0; i <= b.deg; i++) c.coef[i] += b.coef[i];
        c.deg = c.degree();
        return c;
    }

    // Subtract two polynomials
    public Polynomial minus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
        for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
        for (int i = 0; i <= b.deg; i++) c.coef[i] -= b.coef[i];
        c.deg = c.degree();
        return c;
    }

    // Multiply two polynomials
    public Polynomial times(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, a.deg + b.deg);
        for (int i = 0; i <= a.deg; i++)
            for (int j = 0; j <= b.deg; j++)
                c.coef[i + j] += (a.coef[i] * b.coef[j]);
        c.deg = c.degree();
        return c;
    }

    // Coefficient of the highest degree term
    public int coeff() {
        return coeff(degree());
    }

    // Coefficient for a specific degree
    public int coeff(int degree) {
        if (degree > this.degree()) throw new RuntimeException("Bad degree");
        return coef[degree];
    }

    // Convert to string representation
    public String toString() {
        if (deg == 0) return "" + coef[0];
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= deg; i++) {
            if (coef[i] == 0) {
                continue;
            } else if (coef[i] > 0) {
                s = s.append((coef[i]));
            } else if (coef[i] < 0) s.append("-" + (-coef[i]));

            if (i == 1) {
                s.append("x1");
            } else if (i > 1) s.append("x" + i);
            s.append(" ");
        }
        return s.toString();
    }
}
```

### Explanation

- This solution defines a `Polynomial` class with methods to add, subtract, multiply, and print polynomials. 
- Polynomials are represented as arrays, where each index corresponds to a degree and holds the respective coefficient.
- The class provides functions for handling operations like addition, subtraction, multiplication, and printing terms.

