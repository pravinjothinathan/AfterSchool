import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;


public class disks2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] A ={1,5,2,1,4,0};
//		solution(A);
		System.out.println(number_of_disc_intersections(A));
	}
	
	 public static int number_of_disc_intersections ( int[] A ) {
		    int overlaps = 0;
		    if (A.length<2) return 0;
		    PriorityQueue<Integer> leftEdges = new PriorityQueue<Integer>();
		    PriorityQueue<Long> rightEdges = new PriorityQueue<Long>();
		    for (int i=0; i<A.length; i++){
		    	System.out.println("inLeft->"+leftEdges);
		    	System.out.println("inRight->"+rightEdges);
		      leftEdges.add(i-A[i]);
		      rightEdges.add((long)i+(long)(A[i]));
		    }
		    System.out.println(leftEdges);
		    System.out.println(rightEdges);
		    
		    
		    int otherCirclesAtThisEdgeNum = 0;
		    
		    while ( !rightEdges.isEmpty()) {
		      try {
		    	  System.out.println(leftEdges.element());
		    	  System.out.println(rightEdges.peek());
		    	  System.out.println("overlap->"+overlaps);
		    	  System.out.println("otherCirclesAtThisEdgeNum->"+otherCirclesAtThisEdgeNum);
		        if (leftEdges.element() <= rightEdges.peek() ) {
		          overlaps += otherCirclesAtThisEdgeNum++;
		          if (overlaps > 10000000) return -1;
		          leftEdges.poll();
		          System.out.println("left poll");
		        } else {
		          otherCirclesAtThisEdgeNum--;
		          rightEdges.poll();
		          System.out.println("right poll");
		        }
		      }catch (NoSuchElementException e){
		        break;
		      }
		    }
		    return overlaps;
		  }
	
	public static int solution(int[] A){
		int count = 0;
		
		ArrayList<Integer> startList = new ArrayList<Integer>();
		ArrayList<Integer> endList = new ArrayList<Integer>();
		
		for (int i = 0; i < A.length; i++) {
			startList.add(i - A[i]);
			endList.add(i+A[i]);
		}
		
		System.out.println(startList);
		System.out.println(endList);
		
		return count;
	}

}
