import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] board = new int[4][4];
		board[0][0] = 1;
		ArrayList<String> stack = new ArrayList<String>();
		
		int count =0;
		count = ExplorePath(board,0,0,stack,count);
		System.out.println(count);
	}

//	private static void printListStrings(ArrayList<String> spiralStrings) {
//		for (int i = 0; i < spiralStrings.size(); i++) {
//			System.out.print(spiralStrings.get(i)+";");
//			}
//		System.out.println();
//	}
	
	private static int ExplorePath(int[][] board,int row, int col, ArrayList<String> stack,int count) {
		
		//boundary condition
		if(row<0 || row>3 || col<0 || col >3 )
			return 0;
		
		//return
		//stopping criteria
		if(row==3&&col==3){
//			printListStrings(stack);
			return 1;
		}
		
		String curPos = row + ":" + col;
		
		if(stack.contains(curPos))
			return 0;
		else
		{
			stack.add(curPos);
			//move top
			int c1 = ExplorePath(board, row - 1, col, stack, count);
			//move down
			int c2 = ExplorePath(board, row + 1, col, stack, count);
			//move left
			int c3 = ExplorePath(board, row , col - 1, stack, count);
			//move right
			int c4 = ExplorePath(board, row , col + 1, stack, count);
			
			count = c1 + c2 + c3 + c4;
			stack.remove(curPos);
		}
		
		return count;
		
		
	}

}
