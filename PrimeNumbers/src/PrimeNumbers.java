import java.util.ArrayList;
import java.util.Arrays;


public class PrimeNumbers {

	public ArrayList<Integer> getPrimeNumbersLessthanN(int i) {
		ArrayList<Integer> primeNos = new ArrayList<Integer>();
		boolean flags[] = new boolean[i];
		Arrays.fill(flags, true);
		for (int j = 2; j < i; j++) {
			if(flags[j]==true){
				boolean isPrime = true;
				for (int k = 0; k < primeNos.size(); k++) {
					if(primeNos.get(k)<Math.sqrt(j))
						break;
					if(j%primeNos.get(k)==0){
						isPrime = false;
						break;
					}
				}
				if(isPrime==true){
					primeNos.add(j);
					//set flag for all the multiples to false
					for (int k = j; k < i; k +=j) {
						flags[k] = false;
					}
				}
			}
		}
		return primeNos;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Integer> getNPrimeNumbers(int n) {
		double piN = n * Math.log(n) + n * Math.log(Math.log(n));
		
		return new ArrayList(getPrimeNumbersLessthanN((int)piN).subList(0, n));
	}

}
