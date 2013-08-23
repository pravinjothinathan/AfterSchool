import java.util.HashSet;


public class closure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A ={2,2,1,0,1};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A){
		int itr =0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i : A) {
			hs.add(i);
		}
		System.out.println(hs);
		while(hs.size()>0){
			if(hs.contains(A[itr])){
				System.out.println("remoeve->"+A[itr]);
				hs.remove(A[itr]);
				if(hs.size()==0)
					break;
			}
			itr++;
		}
		return itr;
	}

}
