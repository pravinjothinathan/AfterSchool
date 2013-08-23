import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


public class Test2Twitter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A ={ 5,4,0,3,1,6,2};
		solution(A);
		
	}
	
	public static int solution(int[] A){
		int returnVal =0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> vals = new Stack<Integer>();
		for (int i : A) {
			vals.clear();
			vals.add(i);
			while(A[i] >=0 && A[i]<A.length && !map.containsKey(A[i])){
				if(!vals.contains(A[i])){
					vals.add(A[i]);	
					i = A[i];
				}else{
					for (Integer integer : vals) {
						map.put(integer, vals.size());
					}
					
					System.out.println("count during creation ="+map.get(vals.get(0)));
					break;
				}
			}
			System.out.println(map.values());
		}
		
		return returnVal;
	}

}
