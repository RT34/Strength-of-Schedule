package Module2exercises;


public class ParticleMain {
	public static void main(String[] args) {
		double dt[] = {0.5, 0.1, 0.01, 0.001, 0.0001};
		for (int iii = 0; iii < dt.length; iii++)
		{
			FallingParticle test = new FallingParticle(5.2, 3.6); //created in loop so all parameters are reset foreach new dt
			test.setH(10.0);
			test.drop(dt[iii]);
			System.out.println("For dt = " + dt[iii] + ", it took " + test.getT() + " seconds to fall, and reached a speed of " + test.getV() + ".");
		}
		System.out.println("As dt decreases, the time to complete fluctuates. This is because of larger, clunkier changes to the v, and thus z, of the " 
				+ "particle, meaning that it comes closer to finishing at exactly z = 0 the shorter the step. This also causes the changes in final velocity, the"
				+ " changes in step meaning that a different velocity is achieved just prior to the jump taking the particle past z = 0.");
	}

}
