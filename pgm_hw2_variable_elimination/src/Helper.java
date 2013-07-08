import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Helper {

	public List<String> getDomainPlaceHolders(String string,
			HashMap<Integer, Integer> variableDomainSize) {
		System.out.println(string);
		List<String> tempPlaceHolders = new ArrayList<String>();
		String[] variables = string.split(";");
		if (variables.length > 0) {
			tempPlaceHolders = generateDomainValues(variableDomainSize
					.get(Integer.parseInt(variables[0])));
		}
		for (int i = 1; i < variables.length; i++) {
			int tempDomainSize = variableDomainSize.get(Integer
					.parseInt(variables[i]));
			List<String> newPlaceHolders = generateDomainValues(tempDomainSize);
			tempPlaceHolders = Product(tempPlaceHolders, newPlaceHolders);
		}
		return tempPlaceHolders;
	}

	private List<String> Product(List<String> tempPlaceHolders,
			List<String> newPlaceHolders) {
		List<String> vals = new ArrayList<String>();
		for (String string1 : tempPlaceHolders) {
			for (String string2 : newPlaceHolders) {
				String temp = string1 + string2;
				vals.add(temp);
			}
		}
		return vals;
	}

	private List<String> generateDomainValues(int parseInt) {
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < parseInt; i++) {
			temp.add(String.format("%d", i));
		}
		return temp;
	}

	public String getPattern(String variables, String newFuncVariables,
			String string2) {
		//System.out.println(variables);
		//System.out.println(newFuncVariables);
		//System.out.println(string2);
		String temp = "";
		String[] vars = variables.split(";");
		String[] newfuncVars = newFuncVariables.split(";");
		List<String> lstnewFunc = Arrays.asList(newfuncVars);
		//newFuncVariables = newFuncVariables.replace(";", "");
		char[] values = string2.toCharArray();
		List<String> visited = new ArrayList<String>();
		for (String string : vars) {
			if (lstnewFunc.contains(string) && !visited.contains(string)) {
				int index = lstnewFunc.indexOf(string);
				temp = temp + values[index];
				visited.add(string);
			} else {
				temp = temp + "_";
			}
		}
		return temp;
	}

	public boolean testPattern(String pattern, String string2) {
		pattern = pattern.replace("_", "[0-9]");
		return string2.matches(pattern);
	}

	public String getFunctionVariablesWithoutDuplicates(String newFuncVariables) {
		String temp = "";
		String[] variables = newFuncVariables.split(";");
		List<String> visited = new ArrayList<String>();
		for (String string : variables) {
			if (!visited.contains(string)) {
				temp = temp + string + ";";
				visited.add(string);
				System.out.println("temp->"+temp);
			}
		}
		return temp;
	}

	public double CalculateSum(List<Double> functions) {
		double d = 0;
		for (Double tempDouble : functions) {
			d += tempDouble;
		}
		return d;
	}

}
