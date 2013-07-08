
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdef";
		String str2 = "defXYZ";
		
	
		
//		int score = calculateOverlapScore(str1,str2);
	}

	private static int calculateOverlapScore(String str1, String str2) {
		int max = 0;
		if(str1.contains(str2)){
			
		}else if(str2.contains(str1)){
			
		}else{
			//str1 ends match str2 start
			for (int i = 0; i < str1.length(); i++) {
				if(str2.startsWith(str1.substring(i))){
					break;
				}
			}
			//str2 ends match str1 start
			for (int i = 0; i < str2.length(); i++) {
				if(str1.startsWith(str2.substring(i))){
					break;
				}
			}
		}
			
		return 0;
	}

}
