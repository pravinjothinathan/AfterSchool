import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class VariableElimination {
	public double PeformVaraibleElimination(GraphicalModel model){
		Helper h = new Helper();
		while(model.noofVariables>0){
			h.PrintListFunction(model.lstfunctions);
			//step1
			//find the function with lowest degree
			int SmallestDegreeElement = GetSamllestDegreeElement(model.lstfunctions,model.lstVariables);
			System.out.println("Smallest Degree Element ->"+SmallestDegreeElement);
			//step2
			//Product of all the functions that contribute to the min DegreeElement
			Function newFunction = ProductofFunctionsContaining(SmallestDegreeElement,model.lstfunctions,model.variableDomainSize);
			System.out.println("After Product ->");
			newFunction.Print();
			//step2
			//summate over the Smallest Degree Element to Remove it
			newFunction = newFunction.Summate(SmallestDegreeElement, model.variableDomainSize);
			System.out.println("After Summation ->");
			newFunction.Print();
			
			//testing
		//	double result = h.SumofArrayofDouble(newFunction.functions);
			//System.out.println("final Result"+result);
		
			//step4
			//create a new model by adding the new function and removing the old one
			model.updateModel(SmallestDegreeElement,newFunction);
		}
		return 0;
	}

	private Function ProductofFunctionsContaining(int smallestDegreeElement, List<Function> lstfunctions, HashMap<Integer, Integer> variableDomainSize) {
		Function newFunction = null;
		String smallestDegVar = String.format("%d", smallestDegreeElement);
		for (Function function : lstfunctions) {
			List<String> varsinFunctions = Arrays.asList(function.variables.split(";"));
			if(varsinFunctions.contains(smallestDegVar)){
//				System.out.println("Function to be multiplied ->");
//				function.Print();
				if(newFunction==null){
					newFunction = new Function(function);
				}else{
					newFunction = newFunction.Product(function, variableDomainSize);
					//System.out.println("After Multiplication ->");
					//newFunction.Print();
				}
				//newFunction.Print();
			}
		}
		return newFunction;
	}

	private int GetSamllestDegreeElement(List<Function> lstfunctions,
			List<Integer> lstVariables) {
		int[] degree = new int[lstVariables.size()];
				
		 for (int i = 0; i < lstVariables.size(); i++) {
			String curVariable = String.format("%d", lstVariables.get(i));
			for (Function function : lstfunctions) {
				List<String> varsinFunctions = Arrays.asList(function.variables.split(";"));
				if(varsinFunctions.contains(curVariable)){
					if(degree[i]==0){
						degree[i] = varsinFunctions.size();
					}else{
						degree[i] *= varsinFunctions.size();
					}
					
				}
			}
//			System.out.println(i + "deg" + degree[i]);
		}
		
		Helper h = new Helper();
		int minIndex = h.getIndexofMinElement(degree);
		 
		return lstVariables.get(minIndex);
	}
	
}
