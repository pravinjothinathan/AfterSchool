import java.util.ArrayList;
import java.util.Arrays;
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
	
	public Function(Function old){
		variables = old.variables;
		Helper h = new Helper();
		functions = h.DeepCopyList(old.functions);
		domainCombo = h.DeepCopyList(old.domainCombo);
	}
	
	
	public void Print() {
		System.out.println("Variables->"+variables);
		System.out.println("functions->"+functions);
		System.out.println("domainval->"+domainCombo);
	}


	public Function Product(Function f2, HashMap<Integer, Integer> variableDomainSize) {
		Function newFunc = null;
		String newVariables = GetNewFunctionVariables(variables,f2.variables,variableDomainSize);
		
		Helper h = new Helper();
		List<String> newDomainCombo = h.getDomainPlaceHolders(newVariables, variableDomainSize);
		//System.out.println(newDomainCombo);
		//System.out.println(variables);
		
		List<Double> newFunctions = new ArrayList<Double>();
		for (String string : newDomainCombo) {
			
			String s1 = fillFunction(newVariables,string);
			System.out.println("f1 combo :"+s1);
			int s1Index = domainCombo.indexOf(s1);
			
			String s2 = f2.fillFunction(newVariables,string);
			System.out.println("f2 combo :"+s2);
			int s2Index = f2.domainCombo.indexOf(s2);
			
			newFunctions.add(functions.get(s1Index)*f2.functions.get(s2Index));
		}
		
		newFunc = new Function(newVariables,newFunctions,newDomainCombo);
		
		return newFunc;
	}


	private String getFilledProductPattern(String newFuncInstatiation, String newFuncVariables, String func1Variables,
			String func2variables) {
		List<String> lstFunc1Variables = Arrays.asList(func1Variables.split(";"));
		List<String> lstNewFuncVariables = Arrays.asList(newFuncVariables.split(";"));
		char[] charString = newFuncInstatiation.toCharArray();
		//splitting func2 variables
		String[] strarrVariables2 = func2variables.split(";");
		String pattern ="";
		
		for (String string2 : strarrVariables2) {
			//if f1 variable is present in f2 variable
			if(lstFunc1Variables.contains(string2)){
				pattern += "_";
			}else{
				int index = lstNewFuncVariables.indexOf(string2);
				pattern += charString[index];
			}
		}
		return pattern;
	}

	private String fillFunction(String newVariables, String string) {
		String fillString ="";
		String[] splitcurFuncVariables = variables.split(";");
		List<String> newFunctions = Arrays.asList(newVariables.split(";"));
		char[] charstring = string.toCharArray();
		for (String curVariable : splitcurFuncVariables) {
			int index = newFunctions.indexOf(curVariable);
			fillString += charstring[index];
		}
		return fillString;
	}


	private String GetNewFunctionVariables(String variables2, String variables3, HashMap<Integer, Integer> variableDomainSize) {
		List<String> variables = new ArrayList<String>();
		String[] varsin2 = variables2.split(";");
		variables.addAll(Arrays.asList(varsin2));
		String[] varsin3 = variables3.split(";");
		for (String string : varsin3) {
			if(variables.contains(string)){
				//do nothing
			}
			else{
				variables.add(string);
			}
		}
		
		//System.out.println("variables");
		Helper h = new Helper();
		String newVariables = h.ConvertListVariablestoStringVariables(variables);
		
		return newVariables;
	}


	public Function Summate(int variableToSumIn,
			HashMap<Integer, Integer> variableDomainSize) {
			String variableToSum = String.format("%d", variableToSumIn);
			String newVariables = variables.replace(variableToSum + ";", "");
			List<String> newDomain = null;
			List<Double> newFunction = new ArrayList<Double>();
			Helper h = new Helper();
			if(!newVariables.equals("")){
				newDomain = h.getDomainPlaceHolders(newVariables, variableDomainSize);
				
				for (String string : newDomain) {
					double temp = 0;
					String pattern = getFilledPattern(string,newVariables,variables);
					for (int i = 0; i < domainCombo.size(); i++) {
						if(h.testPattern(pattern, domainCombo.get(i))){
							temp += functions.get(i);
						}
					}
					newFunction.add(temp);
				}
			}else{
				newVariables= "";
				newFunction.add(h.SumofArrayofDouble(functions));
			}
			Function retFunc = new Function(newVariables,newFunction,newDomain);
		return retFunc;
	}


	private String getFilledPattern(String string, String newVariables,
			String variables2) {
			List<String> lstNewVariables = Arrays.asList(newVariables.split(";"));
			char[] charString = string.toCharArray();
			String[] strarrVariables2 = variables2.split(";");
			String pattern ="";
			for (String string2 : strarrVariables2) {
				if(lstNewVariables.contains(string2)){
					int index = lstNewVariables.indexOf(string2);
					pattern += charString[index];
				}
				else{
					pattern += "_";
				}
			}
		return pattern;
	}
}
