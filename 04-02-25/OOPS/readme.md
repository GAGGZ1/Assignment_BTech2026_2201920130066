# README: Print Name and Age

### Problem Statement:
Create a class named `Person` with two private variables:
- `name` (String)
- `age` (int)

These variables should not be accessible outside the class. Implement two methods:
1. `setValue`: Sets the value of `name` and `age`.
2. `getValue`: Prints the values of `name` and `age` in the specified format.

### Functions:
- `setName(String name)`: Sets the name of the person.
- `setAge(int age)`: Sets the age of the person.
- `getName()`: Returns the name of the person.
- `getAge()`: Returns the age of the person.

### Input/Output Format:
- **Input 1**: 
  - Name: `Afzal`
  - Age: `67`
- **Output 1**:
  - `The name of the person is Afzal and the age is 67.`

- **Input 2**:
  - Name: `Ali`
  - Age: `30`
- **Output 2**:
  - `The name of the person is Ali and the age is 30.`

### Solution Code:
```java
import java.util.*;
import java.io.*;

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Solution {
    public static void main(String args[]) {
        Person person = new Person();
        Scanner Sc = new Scanner(System.in);
        
        String name = Sc.next();
        person.setName(name);
        
        int age = Sc.nextInt();
        person.setAge(age);

        System.out.print("The name of the person is " + person.getName() + " and the age is " + person.getAge() + ".");
    }
}
```

### Explanation:
1. A `Person` class is created with private variables `name` and `age`.
2. Methods `setName` and `setAge` are used to set the values for these variables.
3. The `getName` and `getAge` methods return the values of `name` and `age` respectively.
4. The `main` method takes input for the name and age, sets these values using the `set` methods, and prints them in the specified format using the `get` methods.