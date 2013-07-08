package Helper;
import java.util.ArrayList;


public class Helper {
	
	public <T> int getMaxScoreIndexfromArrLst(ArrayList<T> list){
		double max =0;
		int itrIndex =0;
		int maxItrIndex =0;
		for (T t : list) {
			if(max < (Double)t){
				max = (Double)t;
				maxItrIndex = itrIndex;
			}
			itrIndex++;
		}
		
		return maxItrIndex;
	}
	
	public <T> void printArrayList(ArrayList<T> vals){
		for (T t : vals) {
			System.out.println(t);
		}
	}

}
