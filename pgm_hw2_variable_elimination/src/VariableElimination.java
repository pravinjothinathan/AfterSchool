import java.util.Arrays;
import java.util.List;

public class VariableElimination {

	GraphicalModel model;

	public VariableElimination(GraphicalModel inmodel) {
		model = inmodel;
	}

	public double CalculateMarginals() {

		int vars = model.noofVariables;
		for (int j = 0; j < vars -1; j++) {
			//System.out.println("list of variables ->"+model.lstVariables);
			//System.out.println("list of functions ->"+model.lstfunctions);
			//for (Function f : model.lstfunctions) {
				//System.out.println(f.variables);
			//}
			String minDegreeElement = FindMinDegreeElement(model.lstfunctions,
					model.noofVariables,model.lstVariables);
			
			List<Function> functions = model
					.getFunctionswithVariable(minDegreeElement);
			
			Function newFunc = getProductofFunctions(functions);
			

			newFunc.Print();

			Function ff = newFunc.Summation(minDegreeElement,
					model.variableDomainSize);

			ff.Print();

			model.updateModel(minDegreeElement, ff);

		}
		System.out.println("Models->");
		for (Function f : model.lstfunctions) {
			f.Print();
		}
		System.out.println("Final Functions->");
		Function finalFunc = getProductofFunctions(model.lstfunctions);
		finalFunc.Print();
		Helper h = new Helper();
		double sum = h.CalculateSum(finalFunc.functions);
		
		return sum;
//			return 0;
	}

	private Function getProductofFunctions(List<Function> functions) {
		Function newFunc = functions.get(0);
		//newFunc.Print();
		for (int i = 1; i < functions.size(); i++) {
			//functions.get(i).Print();
			newFunc = newFunc.Product(functions.get(i));
			//newFunc.Print();
		}
		return newFunc;
	}

	private String FindMinDegreeElement(List<Function> lstfunctions,
			int noofVariables, List<Integer> lstVariables) {
		int min = 1000;
		String minElement = "";
		int[] degree = new int[noofVariables];

		for (int i = 0; i < noofVariables; i++) {
			int var = lstVariables.get(i);
			for (Function function : lstfunctions) {
				String[] variablesinFunction = function.variables.split(";");
				List<String> lstofVarinFunc = Arrays.asList(variablesinFunction);
				if(lstofVarinFunc.contains(String.format("%d", var)))
				{
					degree[i]++;
				}
				//if (function.variables.contains(String.format("%d;", var))) {
					//degree[i]++;
				//}
			}
			if (degree[i] < min) {
				min = degree[i];
				minElement = String.format("%d", var);
			}
		}
		for (int i = 0; i < degree.length; i++) {
			System.out.println(lstVariables.get(i) + "->" + degree[i]);
		}

		System.out.println("min->" + min + "minElement->" + minElement);
		return minElement;
	}
}
