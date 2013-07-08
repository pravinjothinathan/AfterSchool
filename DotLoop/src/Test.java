import java.util.HashMap;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  a ={ -7, 1, 5, 2, -4, 3, 0};
		System.out.println(Solution("codility"));
	}
	
	public static int Solution(String S){
		
		int biggestMatchSize=0;
		HashMap<String, String> map = new HashMap<String, String>();
		int size = S.length();
		for (int i = 0; i < size ; i++) {
			String temp = S.substring(0,i);
			map.put(temp, temp);
		}
		
		for (int i = size; i > 0; i--) {
			String temp = S.substring(i);
			if(map.containsKey(temp))
				biggestMatchSize = temp.length();
		}
		
		return biggestMatchSize;
	}

}
