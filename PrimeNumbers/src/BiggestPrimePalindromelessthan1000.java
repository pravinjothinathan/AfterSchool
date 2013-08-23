import java.util.ArrayList;


public class BiggestPrimePalindromelessthan1000 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeNumbers pm = new PrimeNumbers();
		ArrayList<Integer> primeNos = pm.getPrimeNumbersLessthanN(1000);
		Palindrome pal = new Palindrome();
		for (int i = primeNos.size(); i > 0; i--) {
			if(pal.isPalindrome(primeNos.get(i-1))){
				System.out.println(primeNos.get(i-1));
				break;
			}
		}
		
	}

}
