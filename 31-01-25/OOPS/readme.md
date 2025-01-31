# Java Method Overriding 2 (Super Keyword)

## Problem Statement
When a method in a subclass overrides a method in the superclass, it is still possible to call the overridden method using the `super` keyword. If you write `super.func()` to call the function `func()`, it will invoke the method defined in the superclass.

### Objective
Modify the given Java code to ensure that the output matches the expected result.

## Expected Output
```
Hello I am a motorcycle, I am a cycle with an engine.
My ancestor is a cycle who is a vehicle with pedals.
```

## Given Code
```java
import java.util.*;
import java.io.*;

class BiCycle{
	String define_me(){
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle{
	String define_me(){
		return "a cycle with an engine.";
	}
	
	MotorCycle(){
		System.out.println("Hello I am a motorcycle, I am "+ define_me());
        
		String temp=super.define_me(); //Fix this line

		System.out.println("My ancestor is a cycle who is "+ temp );
	}
	
}
class Solution{
	public static void main(String []args){
		MotorCycle M=new MotorCycle();
	}
}
```

## Explanation
1. The `MotorCycle` class overrides the `define_me()` method of the `BiCycle` class.
2. Inside the `MotorCycle` constructor, `define_me()` is called to print the subclass definition.
3. The `super.define_me()` method is used to invoke the overridden method from `BiCycle`, ensuring the correct ancestor description is printed.

## Key Concepts
- **Method Overriding**: When a subclass provides a specific implementation of a method already defined in its superclass.
- **Super Keyword**: Used to call the superclass method from the subclass.

## How to Run
1. Copy the provided Java code into a file (e.g., `Solution.java`).
2. Compile the program using:
   ```sh
   javac Solution.java
   ```
3. Run the program using:
   ```sh
   java Solution
   ```