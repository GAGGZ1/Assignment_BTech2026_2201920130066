
---

# Instanceof Tutorial

## Problem Description
You are given three classes: `Student`, `Rockstar`, and `Hacker`. 

In the `main` method, you need to populate an `ArrayList` with multiple instances of these classes based on the input. You then need to count how many instances of each class are present in the list and return the count for each class. The count should be displayed in the order of `Student`, `Rockstar`, and `Hacker`.

## Problem Constraints
- Use the `instanceof` operator to check the type of the object and count the number of objects of each class.

## Classes
- **Student**: Represents a student.
- **Rockstar**: Represents a rockstar.
- **Hacker**: Represents a hacker.

## Approach and Solution
1. **Input Parsing**: First, we read an integer `t` which tells how many objects we will be adding to the `ArrayList`. For each of the next `t` inputs, we create objects of the corresponding class (`Student`, `Rockstar`, or `Hacker`).
   
2. **Counting Instances**: We iterate through the `ArrayList` and use the `instanceof` operator to check the class of each object. Based on the class, we increment the respective counter for `Student`, `Rockstar`, or `Hacker`.

3. **Output**: Finally, we print the counts for each class in the order: `Student count`, `Rockstar count`, `Hacker count`.

## Solution Code

```java
import java.util.*;

class Student {}
class Rockstar {}
class Hacker {}

public class InstanceOFTutorial {
    
   static String count(ArrayList mylist) {
      int a = 0, b = 0, c = 0;
      
      // Iterate over the list and check type using instanceof
      for (int i = 0; i < mylist.size(); i++) {
         Object element = mylist.get(i);
         
         if (element instanceof Student)
            a++; // Increment student count
         if (element instanceof Rockstar)
            b++; // Increment rockstar count
         if (element instanceof Hacker)
            c++; // Increment hacker count
      }
      
      // Return the result as a formatted string
      String ret = Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c);
      return ret;
   }

   public static void main(String[] args) {
      ArrayList mylist = new ArrayList();
      Scanner sc = new Scanner(System.in);
      
      // Input number of objects to create
      int t = sc.nextInt();
      
      // Add instances based on input
      for (int i = 0; i < t; i++) {
         String s = sc.next();
         if (s.equals("Student")) mylist.add(new Student());
         if (s.equals("Rockstar")) mylist.add(new Rockstar());
         if (s.equals("Hacker")) mylist.add(new Hacker());
      }
      
      // Output the counts of each type
      System.out.println(count(mylist));
   }
}
```

## Sample Input
```
5
Student
Student
Rockstar
Student
Hacker
```

## Sample Output
```
3 1 1
```

## Explanation
- The input consists of 5 objects: 3 `Student` objects, 1 `Rockstar` object, and 1 `Hacker` object.
- The program uses `instanceof` to check the type of each object and counts the occurrences.
- Finally, it prints `3 1 1` as the number of `Student`, `Rockstar`, and `Hacker` objects, respectively.

## How to Run
1. Compile the Java program:  
   `javac InstanceOFTutorial.java`
   
2. Run the program:  
   `java InstanceOFTutorial`

3. Provide input in the format specified above.

## Notes
- The `instanceof` operator is used to check if an object is an instance of a specific class, and this is used to count the occurrences of each class in the `ArrayList`.

--- 