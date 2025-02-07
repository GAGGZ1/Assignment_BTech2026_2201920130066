
---

# Java Iterator Problem

## Problem Description

In this problem, you are given an `ArrayList` containing a sequence of integers, followed by a special string `"###"`, and then a sequence of other strings. Your task is to modify the function `func` so that it only prints the elements after the special string `"###"`. The code must iterate through the list and print all strings that appear after `"###"`.

### Example:

**Input:**
```
2 3
42 10
Hello Java World
```

**Output:**
```
Hello
Java
World
```

## Approach

1. **Iterator Initialization**: Use `Iterator` to iterate through the list.
2. **Skipping Elements**: Continue iterating until we find the special string `"###"`.
3. **Printing Strings After "###"**: Once `"###"` is found, print all subsequent elements (strings).
4. **Use of `instanceof`**: Check if the element is an instance of `String` and matches `"###"`.
5. **Break the Loop**: Stop iterating once `"###"` is encountered.

## Solution

```java
import java.util.*;

public class Main{
   
   static Iterator func(ArrayList mylist){
      Iterator it = mylist.iterator();
      while(it.hasNext()){
         Object element = it.next();
         if(element instanceof String && element.equals("###")) {  // Check if the element is "###"
            break;  // Stop iterating when "###" is found
         }
      }
      return it;  // Return the iterator after the "###" string
   }

   @SuppressWarnings({ "unchecked" })
   public static void main(String []args){
      ArrayList mylist = new ArrayList();
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      for(int i = 0; i < n; i++){
         mylist.add(sc.nextInt());
      }
      
      mylist.add("###");  // Add special separator string "###"
      for(int i = 0; i < m; i++){
         mylist.add(sc.next());
      }
      
      Iterator it = func(mylist);  // Get the iterator after "###"
      while(it.hasNext()){
         Object element = it.next();
         System.out.println((String)element);  // Print the strings after "###"
      }
   }
}
```

## Conclusion

This solution effectively uses the `Iterator` class to navigate through an `ArrayList` and prints all strings appearing after the special string `"###"`. The main focus is on utilizing the `instanceof` operator and understanding how iterators work in Java.

---