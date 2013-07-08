
public class RevBinaryNos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length !=0){
			int initialNo = 0;
			try{
				initialNo = Integer.parseInt(args[0]);
				if(initialNo>=1 && initialNo<=1000000000){
					String binaryStrInitialNo = Integer.toBinaryString(initialNo);
					StringBuffer stringBufToReverse = new StringBuffer(binaryStrInitialNo);
					StringBuffer reversedStringBuf = stringBufToReverse.reverse();
					int reversedNo = Integer.parseInt(reversedStringBuf.toString(), 2);
					System.out.println(reversedNo);
				}else{
					System.out.println("Enter a Number between 1 and 1000000000");
				}
			}catch(Exception ex){
				System.out.println("Not an Number. Enter a number between 1 and 1000000000");

			}
		}else{
			System.out.println("Expects an N, 1 ² N ² 1000000000 as a commadline argument");
		}

	}

}
