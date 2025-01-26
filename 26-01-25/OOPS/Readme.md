Here’s the updated README for your problem based on the description provided:

---

## **Platform**: HackerRank  
**Problem Name**: Java Inheritance 1  

### **Problem Overview**
In this problem, you are tasked with implementing inheritance in Java. You are given an `Animal` class that has a method `walk()`, and you need to create a `Bird` class that extends `Animal` and adds a `sing()` method. You also need to modify the main method to ensure that the program prints the following lines:

```
I am walking
I am flying
I am singing
```

### **Code Explanation**

1. **Inheritance**: The `Bird` class **inherits** the `walk()` method from the `Animal` class.
2. **Method Extension**: The `Bird` class introduces its own method `sing()`, in addition to the inherited `walk()` method and the `fly()` method that is unique to the `Bird` class.
3. **Method Invocation**: In the `main()` method, the `Bird` object will invoke the `walk()`, `fly()`, and `sing()` methods.

### **Code Walkthrough**

```java
class Animal {
    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }
}

public class Solution {
    public static void main(String args[]) {
        Bird bird = new Bird();
        bird.walk();  // Calls inherited walk method from Animal class
        bird.fly();   // Calls fly method from Bird class
        bird.sing();  // Calls sing method from Bird class
    }
}
```

### **Explanation of Each Class and Method**

1. **Animal Class**:
   - The `Animal` class has a method `walk()`, which simply prints `"I am walking"`. This method will be inherited by any class that extends `Animal`.

2. **Bird Class**:
   - The `Bird` class extends `Animal`, inheriting the `walk()` method from `Animal`.
   - The `Bird` class introduces its own `fly()` and `sing()` methods to define behaviors specific to birds.

3. **Solution Class**:
   - The `Solution` class contains the `main` method where a `Bird` object is created.
   - The methods `walk()`, `fly()`, and `sing()` are called on the `Bird` object to demonstrate the functionality.

### **Expected Output**

When the program is executed, it will output:

```
I am walking
I am flying
I am singing
```

This output corresponds to the calls made to `bird.walk()`, `bird.fly()`, and `bird.sing()` in the `main` method.

---

### **OOP Concepts Covered**
- **Inheritance**: The `Bird` class inherits from the `Animal` class.
- **Method Invocation**: Methods `walk()`, `fly()`, and `sing()` are invoked on a `Bird` object.
- **Method Extension**: The `Bird` class introduces its own method `sing()` while also inheriting the `walk()` method from `Animal`.

---
