import java.util.ArrayList;


public class sumof1000primes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeNumbers pm = new PrimeNumbers();
		ArrayList<Integer> primeNos = pm.getNPrimeNumbers(1000);
		int sum =0;
		for (Integer integer : primeNos) {
			sum += integer;
		}
		System.out.println(sum);
	}

}
