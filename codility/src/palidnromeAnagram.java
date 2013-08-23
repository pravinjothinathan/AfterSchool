
public class palidnromeAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("dooernedeevrvn"));
		System.out.println(solution("aabcba"));
	}
	
	public static int solution(String S) {
		if(isPalindorme(S))
			return 1;
		else
			return 0;
    }
	
	public static boolean isPalindorme (String s) {
	    char[] c = s.toCharArray();
	    int b = 0;
	    for (int i = 0; i < c.length; i++) b ^= 1 << (c[i] - 'a');
	    return (b & (b - 1)) == 0;
	}

}
