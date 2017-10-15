package Module2exercises;

public class FallingParticle {
	final double m, d; //Should not change within the scope of the class (as presented in the question) after initialisation
	final static double g = 9.80665; //Should be constant on earth, and this is assumed given that none is given in the question, and thus should never be changeable.
									//This value is found on Wikipedia, and is accessible statically for ease of examination
	double t = 0, z = 0, v = 0, h = 0; //particle is assumed to be at rest at base of container at start of simulation
	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
	}
	public void setH(double h) { //Setters return nothing by convention, though sometimes return this. Ihave gone with the former.
		this.h = h;
	}
	public double getZ() {
		return z;
	}
	public void setV(double v) {
		this.v = v;
	}
	public double getV() {
		return v;
	}
	public double getT() {
		return t;
	}
	public FallingParticle doTimeStep(double deltaT) { //returns this to allow for easy snapshots of the fallingparticle or similar inspection, although unnecessary for the task, might help for debug I guess? Also just good practice
		double a = (d * v * v /m) - g;
		v += a * deltaT;
		z += v * deltaT;
		t += deltaT;
		return this;
	}
	public FallingParticle drop(double deltaT) { //returns this for the reasons stated above
		z = h;
		while (z >= 0.0)  //not z != zero as there is no guarantee it ever would exactly, and direct double comparison is often inaccurate
			doTimeStep(deltaT);
		return this;
	}
}
