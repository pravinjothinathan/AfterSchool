import java.util.ArrayList;


public class PassTriangle1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> inputs = new ArrayList<String>();
//		inputs.add("5");
//		inputs.add("9 6");
//		inputs.add("4 6 8");
//		inputs.add("0 7 1 5");
		
		int size = inputs.size();
		
		int[][] arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			String[] temp = inputs.get(i).split(" ");
//			System.out.println(temp);
			for (int j = 0; j < i+1; j++) {
//				System.out.println(temp[j]);
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
//		printArray(arr,size);
		
		for (int i = size; i >0; i--) {
			for (int j = 0; j < i - 1 ; j++) {
//				System.out.println(j);
				int max = findMax(arr[i-1][j],arr[i-1][j+1]);
				arr[i-2][j] += max;
			}
		}
		
		System.out.println(arr[0][0]);
//		printArray(arr,size);

	}


	private static int findMax(int i, int j) {
		if(i<=j)
			return j;
		else
			return i;
	}


	private static void printArray(int[][] arr, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	

}
