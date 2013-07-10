import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ReverseAndAdd {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
		    BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		        while ((line = in.readLine()) != null) {
		        	System.out.println(findPalindormeRevandAdd(line.toCharArray()));
		    }
	    }catch(Exception ex){
	    	
	    }
		    
	}

	private static char[] findPalindormeRevandAdd(char[] charArray) {
		char[] sum = getRevereAdd(charArray);
		
		return null;
	}

	private static char[] getRevereAdd(char[] charArray) {
		for (int i = 0,j=0; i < charArray.length; i++) {
			
		}
		return null;
	}

//	public static String findPalindormeRevandAdd(int initNumber) {
//		int iterations=0;
//		int number = initNumber;
//		int revNumber = 0;
//		while(true)
//		{
//			String s = String.format("%d", number);
//			StringBuilder sbldr = new StringBuilder(s);
//			revNumber = Integer.parseInt(sbldr.reverse().toString());
//			System.out.println(sbldr.reverse().toString());
//			System.out.println(number);
//			number += revNumber;
//			iterations++;
//			if(checkPalidrome(number)){
//				return iterations+" "+number;
//			}
//			if(iterations==5)
//				break;
//		}
//		return null;
//		
//	}
//
//	private static boolean checkPalidrome(int number) {
//		String temp = String.format("%d", number);
//		StringBuilder tempSB = new StringBuilder(temp);
//		System.out.println(tempSB+":"+tempSB.reverse());
//		if(tempSB.toString().equals(tempSB.reverse().toString()))
//			return true;
//		return false;
//	}

	

}
