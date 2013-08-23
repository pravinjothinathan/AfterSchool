
public class Palindrome {

	public boolean isPalindrome(int number) {
		int no = number;
		int newno =0;
		while(no>0){
			newno = newno * 10 + no % 10;
			no /= 10;
		}
		return (newno == number) ? true : false;
	}

}
