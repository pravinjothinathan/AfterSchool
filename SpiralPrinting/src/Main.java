import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

	public static ArrayList<String> readFile(String fileLoc){
		ArrayList<String> points = new ArrayList<String>();
		File file = new File(fileLoc);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line ="";
			while((line=br.readLine())!=null){
				points.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return points;
	}

	private static void printListStrings(ArrayList<String> spiralStrings) {
		for (int i = 0; i < spiralStrings.size(); i++) {
			System.out.print(spiralStrings.get(i));
			if(i!=spiralStrings.size()-1)
				System.out.print(" ");
		}
		System.out.println();
	}


	private static int getMinimum(int rowDim, int colDim) {
		if(rowDim<=colDim)
			return rowDim;
		return colDim;
	}

	private static void PrintLevel(int startPos, String[][] vals, int rowDim, int colDim, ArrayList<String> indices, ArrayList<String> spiralStrings) {
		int rowIndex = startPos;
		int colIndex = startPos;
		int noRows = rowDim - 2 * startPos;
		int noCols = colDim - 2 * startPos;
		
		colIndex = moveRight(vals, indices, spiralStrings, rowIndex, colIndex,
				noCols);

		rowIndex = moveDown(vals, indices, spiralStrings, rowIndex, colIndex,
				noRows);

		colIndex = moveLeft(vals, indices, spiralStrings, rowIndex, colIndex,
				noCols);
		
		rowIndex = moveUp(vals, indices, spiralStrings, rowIndex, colIndex,
				noRows);
	}

	private static int moveUp(String[][] vals, ArrayList<String> indices,
			ArrayList<String> spiralStrings, int rowIndex, int colIndex,
			int noRows) {
		for (int i = 0; i < noRows - 2; i++) {
			rowIndex--;
			printElementIfIndexNotPresent(vals, rowIndex, colIndex, indices,spiralStrings);
		}
		return rowIndex;
	}

	private static int moveLeft(String[][] vals, ArrayList<String> indices,
			ArrayList<String> spiralStrings, int rowIndex, int colIndex,
			int noCols) {
		for (int i = 0; i < noCols; i++) {
			printElementIfIndexNotPresent(vals, rowIndex, colIndex, indices,spiralStrings);
			colIndex--;
		}
		colIndex++;
		return colIndex;
	}

	private static int moveDown(String[][] vals, ArrayList<String> indices,
			ArrayList<String> spiralStrings, int rowIndex, int colIndex,
			int noRows) {
		for (int i = 0; i < noRows - 2; i++) {
			rowIndex++;
			printElementIfIndexNotPresent(vals, rowIndex, colIndex, indices,spiralStrings);
		}
		if(noRows!=1)
			rowIndex++;
		return rowIndex;
	}

	private static int moveRight(String[][] vals, ArrayList<String> indices,
			ArrayList<String> spiralStrings, int rowIndex, int colIndex,
			int noCols) {
		for (int i = 0; i < noCols; i++) {
			printElementIfIndexNotPresent(vals, rowIndex, colIndex, indices,spiralStrings);
			colIndex++;
		}
		colIndex--;
		return colIndex;
	}

	private static void printElementIfIndexNotPresent(String[][] vals,
			int rowIndex, int colIndex, ArrayList<String> indices, ArrayList<String> spiralStrings) {
		String temp;
		temp = rowIndex + ":" + colIndex;
		if(!indices.contains(temp)){
			spiralStrings.add(vals[rowIndex][colIndex]);
			indices.add(temp);
		}
	}


	public static void main(String[] args) {

		ArrayList<String> inputs = readFile(args[0]);
		ArrayList<String> indices = new ArrayList<String>();
		ArrayList<String> spiralStrings = new ArrayList<String>();
		for (String input : inputs) {
			String[] inputSplits = input.split(";");

			int rowDim = Integer.parseInt(inputSplits[0]);
			int colDim = Integer.parseInt(inputSplits[1]);

			String[][] vals = new String[rowDim][colDim];
			 
			String[] tempVals = inputSplits[2].split(" ");
			
			printSpiralGivenInput(indices, spiralStrings, rowDim, colDim, vals,
					tempVals);
		}
	}

	private static void printSpiralGivenInput(ArrayList<String> indices,
			ArrayList<String> spiralStrings, int rowDim, int colDim,
			String[][] vals, String[] tempVals) {
		indices.clear();
		spiralStrings.clear();

		initializeMatrixValues(rowDim, colDim, vals, tempVals);

		int minNo = getMinimum(rowDim,colDim);
		int levels =0;
		while(minNo > 0)
		{
			PrintLevel(levels++,vals,rowDim,colDim,indices,spiralStrings);
			minNo = minNo /2;
		}
		printListStrings(spiralStrings);
	}

	private static void initializeMatrixValues(int rowDim, int colDim,
			String[][] vals, String[] tempVals) {
		int iterator =0;
		for (int i = 0; i < rowDim; i++) {
			for (int j = 0; j < colDim; j++) {
				vals[i][j] = tempVals[iterator++];
			}
		}
	}

}	