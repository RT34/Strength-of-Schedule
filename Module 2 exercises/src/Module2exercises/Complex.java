package Module2exercises;

public class Complex {
	double dReal, dImag;
	public Complex (double real, double imag) {
		dReal = real;
		dImag = imag;
	}
	static Complex ONE = new Complex(1,0);
	static Complex ZERO = new Complex(0,0);
	static Complex I = new Complex (0,0);
	double real () {
		return dReal;
	}
	double imag() {
		return dImag;
	}
	double modulus() {
		return Math.sqrt(dReal * dReal + dImag + dImag);
	}
	double angle () {
		if (dReal>0) //adjusting for quadrants
			return Math.atan(dImag/dReal);
		else if (dReal <0 && dImag >=0)
			return Math.atan(dImag/dReal) + Math.PI;
		else if (dReal < 0 && dImag <0)
			return Math.atan(dImag/dReal) - Math.PI;
		else if (dReal == 0 && dImag > 0)
			return Math.PI/2;
		else if (dReal == 0 && dImag < 0)
			return -Math.PI/2;
		else
			return 0; //only applies for both parts 0, unclear behaviour but something must be returned
	}
	public Complex conjugate() {
		return new Complex(dReal, -dImag);
	}
	public Complex normalised() {
		double mod = modulus();
		if (mod != 0) //Prevents division  by zero, slightly faster than checking for this == ZERO
			return new Complex(dReal/mod, dImag/mod);
		else
			return this; //Unclear behaviour, returns number as is
	}
	public boolean equals (Complex c) {
		return (this.dReal == c.dReal && this.dImag == c.dImag);
	}
	public String toString() {
		return dReal + " + " + dImag + "i";
	}
	public Complex setFromModulusAngle(double mag, double ang) {
		dReal = mag * Math.cos(ang);
		dImag = mag * Math.sin(ang);
		return this;
	}
	public static Complex add(Complex c1, Complex c2)	{
		return new Complex(c1.dReal + c2.dReal, c1.dImag + c2.dImag);
	}
	public static Complex subtract(Complex c1, Complex c2) {
		return new Complex(c1.dReal - c2.dReal, c1.dImag - c2.dImag);
	}
	public static Complex multiply (Complex c1, Complex c2) {
		return new Complex(c1.dReal * c2.dReal -c1.dImag * c2.dImag, c1.dReal * c2.dImag + c1.dImag * c2.dReal);
	}
	public static Complex divide(Complex c1, Complex c2) {
		c1 = Complex.multiply(c1, c2.conjugate());
		c2 = Complex.multiply(c2, c2.conjugate());
		return new Complex(c1.dReal/c2.dReal,c1.dImag/c2.dReal); //This allows possibiliy to divide by zero, but I don't know
		//how to do exceptions in Java, and the question doesn't mention this issue while requesting division by ZERO, so have
		//left as is. I hope this is the correct decision, have avoided zero division elsewhere.
	}
	
}
