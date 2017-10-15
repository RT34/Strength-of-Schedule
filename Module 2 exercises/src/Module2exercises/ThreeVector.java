package Module2exercises;

public class ThreeVector {
	double x, y, z;
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double magnitude()	{
		return Math.sqrt(x * x + y * y + z * z);
	}
	public ThreeVector unitVector() {
		double mag = magnitude(); //Prevents multiple calls of magnitude
		if (mag!= 0) //Prevents divide by zero in case of null vector
			return new ThreeVector(x/mag, y/mag, z/mag);
		else 
			return new ThreeVector(0,0,0); //Not sure if correct behaviour, nullvector has no direction
		//Later question in complex (show c1/zero) calls this behaviour choice into question, but in general it is best
		//to avoid division by zero.
	}
	public String toString() {
		return String.valueOf(x) + "i + " + String.valueOf(y) + "j + " + String.valueOf(z) + "k";
	}
	public static double scalarProduct(ThreeVector v1, ThreeVector v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}
	public double notStaticScalarProduct(ThreeVector v1, ThreeVector v2) {
		return scalarProduct(v1, v2);
	}
	public static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
		return new ThreeVector(v1.y*v2.z - v2.y * v1.z,v1.x * v2.z - v1.z*v2.x,v1.x * v2.y - v1.y * v2.x);
	}
	public ThreeVector notStaticVectorProduct(ThreeVector v1, ThreeVector v2) {
		return vectorProduct(v1, v2);
	}
	public static ThreeVector add(ThreeVector v1, ThreeVector v2) {
		return new ThreeVector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
	}
	public ThreeVector nonStaticAdd(ThreeVector v1, ThreeVector v2) {
		return add(v1, v2);
	}
	public static double angle(ThreeVector v1, ThreeVector v2) {
		if (v1.magnitude() != 0 && v2.magnitude() != 0) //Prevents division by zero
			return Math.acos(ThreeVector.scalarProduct(v1, v2)/(v1.magnitude() * v2.magnitude()));
		else return 0; //Not sure if correct behaviour, null vector has no direction to have an angle relative to
		//Later question in complex (show c1/zero) calls this behaviour choice into question, but in general it is best
		//to avoid division by zero.
	}
	public double notStaticAngle(ThreeVector v1, ThreeVector v2) {
		return angle(v1, v2);
	}
}
