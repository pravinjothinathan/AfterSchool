import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helper {

	public List<String> getDomainPlaceHolders(String string,
			HashMap<Integer, Integer> variableDomainSize) {
		//System.out.println(string);
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

	
	public boolean testPattern(String pattern, String string2) {
		pattern = pattern.replace("_", "[0-9]");
		return string2.matches(pattern);
	}

	public String ConvertListVariablestoStringVariables(List<String> variables) {
		String temp ="";
		for (String string : variables) {
			temp  = temp + string + ";";
		}
		return temp;
	}

	public int getIndexofMinElement(int[] degree) {
		int minVal = 1000000;
		int minIndex =-1;
		for (int i = 0; i < degree.length; i++) {
			if(degree[i]<minVal){
				minVal = degree[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public <T> List<T> DeepCopyList(List<T> list) {
		List<T> temp = new ArrayList<T>();
		for (T t : list) {
			temp.add(t);
		}
		return temp;
	}

	public void PrintListFunction(List<Function> lstfunctions) {
		System.out.print("Functions->");
		for (Function function : lstfunctions) {
			System.out.print(function.variables+"|");
		}
	}

	public double SumofArrayofDouble(List<Double> vals) {
		double sum = 0;
		for (Double val : vals) {
			sum+=val;
		}
		return sum;
		
	}

}
