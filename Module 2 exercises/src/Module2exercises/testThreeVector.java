package Module2exercises;

public class testThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(3,5,2), v2 = new ThreeVector(2,4,1), v3 = new ThreeVector (0,0,0);
		System.out.println("v1 is " + v1 + ", and its unit vector is " + v1.unitVector() + ".");
		System.out.println("v2 is " + v2 + "and its unit vector is " + v2.unitVector()+ ".");
		System.out.println("v3 is " +v3 + "and its unit vector is " + v3.unitVector() +".");
		System.out.println("v1.v2 is " + ThreeVector.scalarProduct(v1, v2) + ", v1.v3 is " + ThreeVector.scalarProduct(v1, v3) + ".");
		System.out.println("Non-statically, this is " + v1.notStaticScalarProduct(v1, v2) + " and " + v2.notStaticScalarProduct(v1, v3) + " respectively.");
		System.out.println("v1Xv2 is " + ThreeVector.vectorProduct(v1, v2) + ", v1Xv3 is " + ThreeVector.vectorProduct(v1, v3) + ".");
		System.out.println("Non-statically, this is " + v1.notStaticVectorProduct(v1, v2) + " and " + v2.notStaticVectorProduct(v1, v3) + " respectively.");
		System.out.println("The angle between v1 and v2 is " + ThreeVector.angle(v1, v2) + ", whereas the angle between v1 and v3 is " + ThreeVector.angle(v1, v3) + ".");
		System.out.println("Non-statically, this is " + v1.notStaticAngle(v1, v2) + " and " + v2.notStaticAngle(v1, v3) + " respectively.");
		//Note that the result is identical, but an existing threevector has to be used to call the function. As such, these methods should not be static in normal use
		System.out.println("In the case of no toString function, it instead prints the full object (Module2exercises.ThreeVector@ followed by a string of hex that is presumably its address.");
	}

}
