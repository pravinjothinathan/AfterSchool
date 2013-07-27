import java.util.ArrayList;

public class Solution {
	
	public static class Merge{

		private int[] numbers;
		private int[] helper;

		private int number;

		public void sort(int[] values) {
			this.numbers = values;
			number = values.length;
			this.helper = new int[number];
			mergesort(0, number - 1);
		}
		
		

		private void mergesort(int low, int high) {
			// Check if low is smaller then high, if not then the array is sorted
			if (low < high) {
				// Get the index of the element which is in the middle
				int middle = low + (high - low) / 2;
				// Sort the left side of the array
				mergesort(low, middle);
				// Sort the right side of the array
				mergesort(middle + 1, high);
				// Combine them both
				merge(low, middle, high);
			}
		}

		private void merge(int low, int middle, int high) {

			// Copy both parts into the helper array
			for (int i = low; i <= high; i++) {
				helper[i] = numbers[i];
			}

			int i = low;
			int j = middle + 1;
			int k = low;
			// Copy the smallest values from either the left or the right side back
			// to the original array
			while (i <= middle && j <= high) {
				if (helper[i] <= helper[j]) {
					numbers[k] = helper[i];
					i++;
				} else {
					numbers[k] = helper[j];
					j++;
				}
				k++;
			}
			// Copy the rest of the left side of the array into the target array
			while (i <= middle) {
				numbers[k] = helper[i];
				k++;
				i++;
			}

		}
	}

	public static void main(String[] args) {
//		int[] numbers = {7,21,3,42,3,7};
//		Merge sorter = new Merge();
//		sorter.sort(numbers);
//
//		int min = 100001;
//		for (int i = 1; i < numbers.length; i++) {
//			int absDiff = diff(numbers[i-1],numbers[i]); 
//			if(absDiff<min){
//				min = absDiff;
//			}
//		}
//		
//		System.out.println(min);
//		System.out.println(solution(8675, 8689));;
//		int[] A = {0,1,3,1,2,2};
//		int[] B = {1,2,2,3,0,1};
//		int[] C = {2,3,4,5,7,5};
//		int[] D ={-1,1,3,6};
//		System.out.println(solution(A, B, C, D));
////		System.out.println(Math.log(8675));
		
		
		int[]A ={4,3,2,1};
		int[]B= {1,2,3,4};
		solution(A,B);
	}
	
	public static int solution(int[]A, int[] B){
        int diskItr =0;
        int diskDia = B[diskItr];
        
        for(int i =A.length-1;i>-1;i--){
            System.out.println(A[i]+":"+diskDia);
            if(diskDia<=A[i]){
            	
                if(diskItr<B.length)
                {
                	diskItr++;
                	diskDia = B[diskItr];
                }
                else
                    break;
                
            }
        }
        
        return diskItr;
	}
	
	public static int solution(int[] A, int[] B, int[] C, int[] D) {
        // write your code here...
		int finDist =-1;
		int[][] transitonMatrix = new int[D.length][D.length];
		for (int i = 0; i < A.length; i++) {
			if(transitonMatrix[A[i]][B[i]]==0){
				transitonMatrix[A[i]][B[i]] = C[i];
				transitonMatrix[B[i]][A[i]] = C[i];
			}else if(transitonMatrix[A[i]][B[i]]>C[i]){
				transitonMatrix[A[i]][B[i]] = C[i];
				transitonMatrix[B[i]][A[i]] = C[i];
			}
		}
		
//		for (int i = 0; i < transitonMatrix.length; i++) {
//			for (int j = 0; j < transitonMatrix.length; j++) {
//				System.out.print(transitonMatrix[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		int[] dist = new int[D.length]; 
		ArrayList<Integer> stack = new ArrayList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		stack.add(0);
		while(stack.size()!=0){
			int n = stack.remove(0);
//			System.out.println(n+"->");
			visited.add(n);
			for(int i=0;i<transitonMatrix.length;i++){
				if(!visited.contains(i)){
					if(transitonMatrix[n][i]>0){
						//there is an out going edge
						if(dist[i]!=0)
							dist[i] = min(dist[i],dist[n]+transitonMatrix[n][i]);
						else
							dist[i] = dist[n] + transitonMatrix[n][i];
						stack.add(i);
					}
				}
			}
			
			
		}
		
		for (int i = 0; i < dist.length; i++) {
//			System.out.println(dist[i]+":"+D[i]);
			if(dist[i]<=D[i])
			{
				finDist = dist[i];
			}
		}
		
		
		
		return finDist;
    }
	
//	public static int solution(int A, int B) {
//		int count = 0;
//		char[] charArrA = String.format("%d", A).toCharArray();
//		char[] charArrB = String.format("%d",B).toCharArray();
//		count = calcualteCount(charArrA,charArrB);
//		return count;
//	}

	private static int min(int i, int j) {
		if(i<=j)
			return i;
		else 
			return j;
	}

	private static int calcualteCount(char[] charArrA, char[] charArrB) {
		int equalsLenth=0;
		double avgCount =0;
		for (int i = 0; i < charArrB.length; i++) {
			if(charArrA[i]==charArrB[i]){
				System.out.println(charArrA[i]+":"+(int)charArrA[i]);
				avgCount += (char)charArrA[i] - 48;
				equalsLenth++;
			}
			else
				break;
			
		}
		System.out.println(avgCount+":"+equalsLenth);
//		calcCombinations(charArrA,charArrB,avgCommon,digits);
		return 0;
	}
	
	private static void print(){
		for (int i = 1; i < 100; i++) {
		}
	}
//	public static int solution(int A, int B) {
//		int count =0;
//		double avg = getAvg(A);
//		double increase = 1.0 /len;
//		for (int i = A; i < B; i++) {
//			System.out.println(avg);
//			if(i%10==0){
//				System.out.println(i);
//				avg = getAvg(i);
//				System.out.println("avg->"+avg);
//				increase = 1.0 /len;
//			}
//		
//			avg = avg + increase;
//			
//			
//			if(avg>7.0 && (i+1)%10!=0){
//				count++;
//			}
//				
//		}
//		return count;
//	}
//	
//	static int len = 0;
//
//	private static double getAvg(int A) {
//		int n=0;
//		int itr=0;
//		int a = A; 
//		while(a>0){
//			n+=a%10;
//			System.out.println(a);
//			a = a/10;
//			itr++;
//		}
//		len = itr;
//		return (double)n/itr;
//	}
	
//	private static int diff(int i, int j) {
//		return Math.abs(i-j);
//	}
//
//	public void printNumbers(int [] numbers){
//		for (int i : numbers) {
//			System.out.println(i);
//		}
//	}
	
	  
}
