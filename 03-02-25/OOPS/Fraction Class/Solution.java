import java.math.*;
import java.util.Scanner;

class Fraction {

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public void print() {
		System.out.println(this.numerator + "/" + this.denominator);
	}

	void simplify() {
		int gcd = 1;
		for (int i = 1; i <= Math.min(numerator, denominator); i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i;
			}
		}
		numerator = numerator / gcd;
		denominator = denominator / gcd;
	}

	void add(Fraction f2) {
		int lcm = denominator * f2.denominator;
		int x = lcm / denominator;
		int y = lcm / f2.denominator;

		int num = x * numerator + (y * f2.numerator);

		numerator = num;
		denominator = lcm;
		simplify();
	}

	void multiply(Fraction f2) {
		numerator = numerator * f2.numerator;
		denominator = denominator * f2.denominator;

		simplify();
	}

}

class Solution {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int den1 = sc.nextInt();

		Fraction f = new Fraction(num1, den1);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int type = sc.nextInt();
			int num2 = sc.nextInt();
			int den2 = sc.nextInt();
			if (type == 1) {

				Fraction f2 = new Fraction(num2, den2);
				f.add(f2);
				f.print();
			} else if (type == 2)

			{

				Fraction f2 = new Fraction(num2, den2);
				f.multiply(f2);
				f.print();
			}
		}
	}
}
