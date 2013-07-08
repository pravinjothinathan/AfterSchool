import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {
	
	private class Place{
		int id;
		String addr;
		String city;
		double lattidude;
		double longitude;
		
		public Place(int Id, String Addr, String City, double Lattitude, double Longitude){
			id = Id;
			addr = Addr;
			city = City;
			lattidude = Lattitude;
			longitude = Longitude;
		}
		
		public double calculateDistance(Place place2){
			double dist = Math.pow(lattidude - place2.lattidude, 2.0) + Math.pow(longitude - place2.longitude, 2.0);
			return dist;
		}
		
		public void Print(){
			System.out.println(id+" "+lattidude+" "+longitude);
		}
	}
	
	public static ArrayList<String> readFile(String fileLoc){
		ArrayList<String> lines = new ArrayList<String>();
		File file = new File(fileLoc);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line ="";
			while((line=br.readLine())!=null){
				lines.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lines;
	}
	
	public static Place parsePlace(String line){
		String delims = "[|,()]";
		String[] tokens = line.split(delims);
		for (int i = 0; i < tokens.length; i++) {
//			System.out.println(tokens[i].trim());
		}
		Main ce = new Main();
		return ce.new Place(Integer.parseInt(tokens[0].trim()), tokens[1].trim(), tokens[2].trim(), Double.parseDouble(tokens[3].trim()), Double.parseDouble(tokens[4].trim()));
	}
	
	public static ArrayList<Place> convertArraytoPlaces(ArrayList<String> lines){
		ArrayList<Place> tempPlaces = new ArrayList<Main.Place>();
		for (String string : lines) {
			tempPlaces.add(parsePlace(string));
		}
		return tempPlaces;
	}
	
	public static double[][] calcDistanceMatrix(ArrayList<Main.Place> places){
		int placesSize = places.size();
		double[][] tempDistance = new double[placesSize][placesSize];
		for (int i = 0; i < placesSize; i++) {
			for (int j = i; j < tempDistance.length; j++) {
				double temp = places.get(i).calculateDistance(places.get(j));
				tempDistance[i][j] = temp;
				tempDistance[j][i] = temp;
			}
		}
		return tempDistance;
	}
	
	public static double calculatePathDistance(double[][] distanceMatrix, ArrayList<Integer> stack){
		double totDistance = 0;
		for (int i = 0; i < stack.size() -1; i++) {
			totDistance += distanceMatrix[stack.get(i) - 1][stack.get(i + 1) - 1];
		}
		return totDistance;
	}
	
	static double minimum = 1000;
	static String Value ="";
	
	public static synchronized void bruteForceDistance(ArrayList<Main.Place> places,double[][] distanceMatrix,ArrayList<Integer> stack){
		if(places.size()==stack.size()){
			double curDist =  calculatePathDistance(distanceMatrix, stack);
			if(minimum>curDist){
				minimum = curDist;
				Value = stack.toString();
				//System.out.println(stack.toString());
				//System.out.println(curDist);
			}
		}else{
			for (Place place : places) {
				if(!stack.contains(place.id)){
					stack.add(place.id);
					bruteForceDistance(places, distanceMatrix, stack);
					stack.remove(new Integer(place.id));
				}
			}
			
		}
	}
	
	//public static dynamicProgrammingDistance()

	public static void main(String[] args) {
		ArrayList<String> places = readFile(args[0]);
		ArrayList<Place> lstPlaces = convertArraytoPlaces(places);
		double[][] distanceMatrix = calcDistanceMatrix(lstPlaces);
//		ArrayList<Integer> stack = new ArrayList<Integer>();
		//adding the starting point
//		stack.add(1);
//		bruteForceDistance(lstPlaces, distanceMatrix, stack);
//		Value = Value.replace("[", "");
//		Value = Value.replace("]", "");
//		String[] vals = Value.split(", ");
//		for (String string : vals) {
//			System.out.println(string);
//		}
//		System.out.println("BF minimum"+minimum);
		dynamicProgrammingDistance(lstPlaces,distanceMatrix);
	}

	private static void dynamicProgrammingDistance(ArrayList<Place> lstPlaces,
			double[][] distanceMatrix) {
		int size = lstPlaces.size() -1;
		double[][] pathDistance = new double[size][size];
		String[][] minPathTraversed = new String[size][size];
		String[][] pathtoTraverse = new String[size][size];
		//Init path to Traverse
		String temp ="";
		for (int i = 1; i < size +1; i++) {
			temp += i + ":";
		}
//		System.out.println(temp);
		
		for (int i = 0; i < size; i++) {
				pathtoTraverse[0][i] = temp;
		}
		
//		for (int i = 0; i < size +1; i++) {
//			for (int j = 0; j < size +1; j++) {
//				System.out.print(distanceMatrix[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		//Init the starting point
		for (int i = 1; i < size +1; i++) {
			pathDistance[0][i-1] = distanceMatrix[0][i];
			minPathTraversed[0][i-1] = "0:"+i;
			String strToReplace = i + ":";
			pathtoTraverse[0][i-1] = pathtoTraverse[0][i-1].replace(strToReplace, "");
//			System.out.println(pathDistance[0][i-1]+"path->"+minPathTraversed[0][i-1]+"toTrav->"+pathtoTraverse[0][i-1]);
		}
		
		//int min =100000;
		for (int i = 1; i < size; i++) {
//			System.out.println("Iteration"+i);
			for (int j = 0; j < size; j++) {
//				System.out.println(pathtoTraverse[i-1][j]);
				String[] placesTraversed = minPathTraversed[i-1][j].split(":");
				int prevPtIndex = Integer.parseInt(placesTraversed[placesTraversed.length-1]);
				String[] placestoTraverse = pathtoTraverse[i-1][j].split(":");
				double pathTraversedDistance =  pathDistance[i-1][j];
				double min =100000;
				String tempStr = "";
				for(String str : placestoTraverse){
					int nextPtIndex = Integer.parseInt(str);
					double dist = lstPlaces.get(prevPtIndex).calculateDistance(lstPlaces.get(nextPtIndex));
					if(min > dist+pathTraversedDistance){
						min = dist + pathTraversedDistance;
						tempStr = str;
					}
//					System.out.println(prevPtIndex + ":" + nextPtIndex + dist + pathTraversedDistance + min);
				}
				//update parameter for the next iteration
				pathDistance[i][j] = min;
				minPathTraversed[i][j] = minPathTraversed[i-1][j] + ":" +tempStr;
				String strToReplace = tempStr + ":";
				pathtoTraverse[i][j] = pathtoTraverse[i-1][j].replace(strToReplace, "");
//				System.out.println(tempStr+"->"+minPathTraversed[i][j]+"-"+pathtoTraverse[i][j]+"="+pathDistance[i][j]);
			}
		}
		String path ="";
		double min = 10000;
		for (int i = 0; i < size; i++) {
			if(min>pathDistance[size-1][i]){
				min = pathDistance[size-1][i];
				path = minPathTraversed[size-1][i] ;
			}
		}
		
		String[] points = path.split(":");
		for (String string : points) {
			System.out.println(Integer.parseInt(string)+1);
		}
				
	}

	

}
