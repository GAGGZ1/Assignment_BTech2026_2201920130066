
---

# Java Abstract Class - Book Example

## Problem Description
In Java, an abstract class cannot be instantiated directly. It serves as a base class for other classes to extend. The objective is to create a class that extends an abstract class and implements the required abstract methods.

### Abstract Class: `Book`

```java
abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle() {
        return title;
    }
}
```

- The `Book` class has an abstract method `setTitle` which must be implemented in a subclass.
- The `getTitle` method returns the title of the book.

### Task
You are required to implement the `MyBook` class that extends the abstract `Book` class and provides the implementation for the `setTitle` method.

### Solution

```java
class MyBook extends Book {
    void setTitle(String s) {
        this.title = s;
    }
}
```

### Explanation:
- The `MyBook` class extends the `Book` class and implements the `setTitle` method.
- The `setTitle` method assigns the input string to the `title` attribute.

### Sample Input

```
A tale of two cities
```

### Sample Output

```
The title is: A tale of two cities
```

---
