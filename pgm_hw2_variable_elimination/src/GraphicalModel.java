import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphicalModel {

	String modelType;
	int noofVariables;
	List<Integer> lstVariables;
	HashMap<Integer, Integer> variableDomainSize;
	int noofFunctions;
	List<Function> lstfunctions;
	public boolean status;

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
		noofFunctions = Integer.parseInt(data.remove(0));
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

//	private void Print(Object model) {
//		System.out.println(model);
//	}

	public List<Function> getFunctionswithVariable(String minDegreeElement) {
		List<Function> tempFunctions = new ArrayList<Function>();
		for (Function f : lstfunctions) {
			if (f.variables.contains(minDegreeElement)) {
				// int index = lstfunctions.indexOf(f);
				System.out.println(f.variables);
				tempFunctions.add(f);
			}
		}
		return tempFunctions;
	}

	public synchronized void updateModel(String minDegreeElement, Function ff) {

		noofVariables = noofVariables - 1;
		variableDomainSize.remove(Integer.parseInt(minDegreeElement));
		int removedfuncs = 0;
		List<Function> toremove = new ArrayList<Function>();
		for (Function funcs : lstfunctions) {
			if (funcs.variables.contains(minDegreeElement)) {
				toremove.add(funcs);
				//lstfunctions.remove(funcs);
				removedfuncs++;
			}
		}
		
		for (Function function : toremove) {
			lstfunctions.remove(function);
		}
		
		lstfunctions.add(ff);
		
		lstVariables.remove((Object)Integer.parseInt(minDegreeElement));
		noofFunctions = noofFunctions - removedfuncs;
	}

}
