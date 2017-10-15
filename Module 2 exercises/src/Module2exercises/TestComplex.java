package Module2exercises;

public class TestComplex {

	public static void main(String[] args) {
		Complex c1 = new Complex(1, 2), c2 = new Complex (-2,-1);
		System.out.println("c1 X c2 is " + Complex.multiply(c1, c2) + ".");
		System.out.println("C1/c2 is "+ Complex.divide(c1, c2) + ".");
		System.out.println("c1 X i is " + Complex.multiply(c1, Complex.I) + ".");
		System.out.println("c1/ZERO is " + Complex.divide(c1, Complex.ZERO) + ".");
		System.out.println("c1 X c1* is " + Complex.multiply(c1, c1.conjugate())+ ".");
		System.out.println("c2 X c2* is " + Complex.multiply(c2,  c2.conjugate()) + ".");
	}

}
