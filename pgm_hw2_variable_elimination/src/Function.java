import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Function {

	String variables;
	List<Double> functions;
	List<String> domainCombo;
	
	
	public Function(String var,List<Double> func,List<String> placeHolders){
		variables = var;
		functions = func;
		domainCombo = placeHolders;
	}
	
	public Function Product(Function next){
		String newvariables = variables + next.variables ;
		List<Double> newfunction = ProductofFunctions(next.functions);
		List<String> newdomainCombo = Productofdomaincombo(next.domainCombo);
		return new Function(newvariables,newfunction,newdomainCombo);
	}

	private List<String> Productofdomaincombo(List<String> domainCombo2) {
		List<String> tempDomainCombo = new ArrayList<String>();
		for (String string1 : domainCombo) {
			for (String string2 : domainCombo2) {
				String temp = string1+ string2;
				tempDomainCombo.add(temp);
			}
		}
		return tempDomainCombo;
	}

	private List<Double> ProductofFunctions(List<Double> functions2) {
		List<Double> tempVariables = new ArrayList<Double>();
		for (Double double1 : functions) {
			for (Double double2 : functions2) {
				//double d = double1*double2;
				//if(d>1e+07)
					//tempVariables.add(1e+07);
				//else
					tempVariables.add(double1*double2);
			}
		}
		return tempVariables;
	}
	
	public Function Summation(String variabletoSum,HashMap<Integer,Integer> variableDomainSize)
	{
		//as of now assuming only one variable elimination at a time
		String newFuncVariables = variables.replace(variabletoSum+";", "");
		//System.out.println("new func varibles ->" + newFuncVariables);

		Helper h = new Helper();
		String updatedFunctionVariables = h.getFunctionVariablesWithoutDuplicates(newFuncVariables);
		List<String> newDomainCombo = h.getDomainPlaceHolders(updatedFunctionVariables, variableDomainSize);
		List<Double> newFunctions = new ArrayList<Double>();
//		System.out.println("new domain combo ->" + newDomainCombo);
		
		for (String string : newDomainCombo) {
			String pattern = h.getPattern(variables,updatedFunctionVariables,string);
//			System.out.println(pattern);
			Double tempSum = new Double(0);
			for (String string2 : domainCombo) {
				if(h.testPattern(pattern,string2))
				{
					//System.out.println(string2);
					int index = domainCombo.indexOf(string2);
					tempSum = tempSum + functions.get(index);
				}
			}
			//if(tempSum>1e+07)
				//newFunctions.add(1e+07);
			//else
				newFunctions.add(tempSum);
			//System.out.println("tempSum->"+tempSum);
		}
		
		
		List<String> updatedDomainCombo = h.getDomainPlaceHolders(updatedFunctionVariables, variableDomainSize);
		return new Function(updatedFunctionVariables,newFunctions,updatedDomainCombo);
	}

	public void Print() {
		//System.out.println("Variables->"+variables);
		//System.out.println("functions->"+functions);
		//System.out.println("domainval->"+domainCombo);
	}
}
