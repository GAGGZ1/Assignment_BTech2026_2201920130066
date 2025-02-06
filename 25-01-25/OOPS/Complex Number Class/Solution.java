import java.util.* ;
import java.io.*; 
import java.util.Scanner;
class ComplexNumbers {
	
	// Write your code here
	int r,i;
	ComplexNumbers(int r, int i){
		this.r = r;
		this.i = i;
	}
	void add(ComplexNumbers c1){
		r = r + c1.r;
		i = i + c1.i;
	}
	void multiply(ComplexNumbers c1){
		int temp1 = r;
		int temp2 = i;
		r = r * c1.r - i * c1.i;
		i = temp1 * c1.i + temp2 * c1.r;
	}
	void print(){
		if(i<0){
			System.out.print(r+"-i"+(-i));
		}
		else{
			System.out.println(r+" "+"+ i"+i);
		}
	}
	
}
class Solution {
	public static void main(String args[]) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int i1 = sc.nextInt();
		ComplexNumbers c1 = new ComplexNumbers(r1, i1);

		int r2 = sc.nextInt();
		int i2 = sc.nextInt();
		ComplexNumbers c2 = new ComplexNumbers(r2, i2);

		int t = sc.nextInt();
		if(t == 1){
			c1.add(c2);
			c1.print();
		}
		else if(t == 2){
			c1.multiply(c2);
			c1.print();
		}
		else return;
	}
}