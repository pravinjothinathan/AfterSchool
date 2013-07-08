
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//"/Users/pravinjothinathan/Dropbox/Semester5/Stat/hw2-problems-1/grid3X3.uai"
		GraphicalModel model1 = new GraphicalModel("/Users/pravinjothinathan/Dropbox/Semester5/Stat/hw2-problems-1/grid3X3.uai");
		System.out.println(model1.status);
		
		VariableElimination ve = new VariableElimination(model1);
		double val = ve.CalculateMarginals();
		System.out.println("Marginal->" + val);
		System.out.println("Marginal log10->" + Math.log10(val));
		System.out.println("Marginal log->" + Math.log(val));
						
	}

}
