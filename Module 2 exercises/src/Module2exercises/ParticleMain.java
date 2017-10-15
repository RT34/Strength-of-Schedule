package Module2exercises;


public class ParticleMain {
	public static void main(String[] args) {
		double dt[] = {0.5, 0.1, 0.01, 0.001, 0.0001};
		
		for (int iii = 0; iii < dt.length; iii++)
		{
			FallingParticle test = new FallingParticle(5.2, 3.6); //created in loop so all parameters are reset foreach new dt
			test.drop(dt[iii]);
			System.out.println("For dt = " + dt[iii] + ", it took " + test.getT() + " seconds to fall, and reached a speed of " + test.getV() + ".");
		}
		
		
	}

}
