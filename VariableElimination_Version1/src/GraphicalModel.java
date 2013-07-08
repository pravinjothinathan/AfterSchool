import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class GraphicalModel {

	String modelType;
	int noofVariables;
	List<Integer> lstVariables;
	HashMap<Integer, Integer> variableDomainSize;
	List<Function> lstfunctions;
	public boolean status;
	
	public void Print(){
		System.out.println("Model Type");
		System.out.println(modelType);
		System.out.println("No of Variables");
		System.out.println(noofVariables);
		System.out.println("List of Variables");
		System.out.println(lstVariables);
		
	}

	public GraphicalModel(String file) {

		List<String> data = ReadFile(file);
		ParseFile(data);
	}

	@SuppressWarnings("resource")
	private List<String> ReadFile(String file) {
		FileInputStream fis;
		List<String> words = new ArrayList<String>();
		try {
			fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			String line = "";
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				String[] temp = line.split("\\s+");
				for (String temp1 : temp) {
					if (!temp1.equals(""))
						words.add(temp1);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}

	private void ParseFile(List<String> data) {
		Helper h = new Helper();
		// model
		modelType = data.remove(0);
		//Print("Model->" + modelType);
		// # of variables
		noofVariables = Integer.parseInt(data.remove(0));
		//Print("#Variables->" + noofVariables);
		// assigning domain sizes
		variableDomainSize = new HashMap<Integer, Integer>();
		lstVariables = new ArrayList<Integer>();
		for (int i = 0; i < noofVariables; i++) {
			lstVariables.add(i);
			variableDomainSize.put(i, Integer.parseInt(data.remove(0)));
		}
		//Print("DomainSize->" + variableDomainSize);
		int noofFunctions = Integer.parseInt(data.remove(0));
//		Print("#Functions->" + noofFunctions);
		List<String> functions = new ArrayList<String>();
		for (int i = 0; i < noofFunctions; i++) {
			String temp = "";
			int tempnoVariablesinFunction = Integer.parseInt(data.remove(0));
			for (int j = 0; j < tempnoVariablesinFunction; j++) {
				temp = temp + data.remove(0) + ";";
			}
			functions.add(temp);
			// System.out.println(temp);
		}
//		Print("Functions->" + functions);
		//functionValues = new HashMap<String, List<Double>>();
		lstfunctions = new ArrayList<Function>();
		for (int i = 0; i < noofFunctions; i++) {
			int tempfunctionSize = Integer.parseInt(data.remove(0));
			List<Double> tempfunctionVals = new ArrayList<Double>();
			for (int j = 0; j < tempfunctionSize; j++) {
				Double d = Double.parseDouble(data.remove(0));
				//if(d>1e+07)
					//tempfunctionVals.add(1e+07);
			//	else
					tempfunctionVals.add(d);
			}
			List<String> domainPlaceHolders = h.getDomainPlaceHolders(
					functions.get(i), variableDomainSize);
			//functionValues.put(functions.get(i), tempfunctionVals);
			lstfunctions.add(new Function(functions.get(i), tempfunctionVals,
					domainPlaceHolders));
		}
		//System.out.println(functionValues);
	}

		
	public void updateModel(int smallestDegreeElement, Function newFunction) {
		noofVariables--;
		lstVariables.remove((Object)smallestDegreeElement);
		variableDomainSize.remove(smallestDegreeElement);
		String smallestDegVar = String.format("%d", smallestDegreeElement);
		ListIterator<Function> listIterator = lstfunctions.listIterator();
		while(listIterator.hasNext()){
			Function function = listIterator.next(); 
			List<String> varsinFunctions = Arrays.asList(function.variables.split(";"));
			if(varsinFunctions.contains(smallestDegVar)){
				listIterator.remove();
			}
		}
		lstfunctions.add(newFunction);
	}

}
