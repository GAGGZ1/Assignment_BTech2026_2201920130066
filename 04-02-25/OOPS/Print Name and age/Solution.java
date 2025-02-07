import java.util.*;
import java.io.*;

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;

    }

    public void setage(int age) {
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
        person.setage(age);

        System.out.print("The name of the person is " + person.getName() + " and the age is " + person.getAge() + ".");
    }
}
