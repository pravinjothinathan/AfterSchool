
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "/Users/pravinjothinathan/Dropbox/Semester5/Stat/hw2-problems-1/BN_7.uai";
		GraphicalModel model = new GraphicalModel(filePath);
		model.Print();
		
		VariableElimination ve = new VariableElimination();
		ve.PeformVaraibleElimination(model);
		System.out.println(model);
		
	
//		Function f1 = model.lstfunctions.get(9);
//		f1.Print();
//		Function f2 = model.lstfunctions.get(10);
//		f2.Print();
//		Function f3 = f1.Product(f2, model.variableDomainSize);
//		f3.Print();
//		Function f4 = f3.Summate(2, model.variableDomainSize);
//		f4.Print();
	}

}
