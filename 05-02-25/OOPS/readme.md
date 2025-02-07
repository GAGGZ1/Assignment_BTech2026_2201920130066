# README: Area of a Rectangle

### Problem Statement:
Design a class named `Rectangle` with two data members:
- `length` (L)
- `breadth` (B)

The class should contain a member function `getArea()` that computes the area of the rectangle and returns the value to the caller.

### Formula:
- **Area of a rectangle** = `length × breadth`

### Data Members:
1. `length`: Length of the rectangle.
2. `breadth`: Breadth of the rectangle.

### Member Function:
- `getArea()`: This function calculates the area of the rectangle and returns the computed value.

### Constraints:
- `0 <= L, B <= 100`

### Sample Input/Output:
- **Input 1**:
  - Length: 4, Breadth: 20
- **Output 1**:
  - Area: 80

- **Input 2**:
  - Length: 2, Breadth: 10
- **Output 2**:
  - Area: 20

### Solution Code:
```java
class Rectangle {
    int length;
    int breadth;

    public int getArea() {
        int area = length * breadth;
        return area;
    }
}
```

### Explanation:
1. The `Rectangle` class has two data members: `length` and `breadth`.
2. The `getArea()` method calculates and returns the area using the formula `length × breadth`.
3. The area is computed directly from the values stored in the data members.

### Complexity:
- **Time Complexity**: O(1) – The area is computed in constant time.
- **Space Complexity**: O(1) – The class uses a fixed amount of space for its data members.