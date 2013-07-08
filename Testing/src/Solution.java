import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;


public class Solution {
	
	private static class Racer{
		int id;
		int startTime;
		int endTime;
		
		public Racer(int inId,int st,int et){
			this.id = inId;
			this.startTime = st;
			this.endTime = et;
		}
		
		public void print(){
			System.out.println(id + ":" + startTime + ":" + endTime);
		}
	}
	
	private static class Bucket{
		int StartTime;
		int EndTime;
		ArrayList<Integer> racersInBucket;
		
		public Bucket(int startTime, int endTime, int id){
			racersInBucket  = new ArrayList<Integer>();
			racersInBucket.add(id);
			StartTime = startTime;
			EndTime = endTime;
		}
		
		public boolean fallsinBucket(Racer racer){
			if(StartTime < racer.startTime){
				if(racer.endTime < EndTime){
					racersInBucket.add(racer.id);
					return true;
				}
			}
			return false;
		}
		
		public void print(){
			System.out.println(StartTime + ":" + EndTime + ":" + racersInBucket);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> inputs = new ArrayList<String>();
		
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int n = Integer.parseInt(line);
//        while ((line = br.readLine()) != null) {
//        	inputs.add(line);
//        }
        
       
        inputs.add("2 100 200");
        inputs.add("3 110 190");
        inputs.add("4 105 145");
        inputs.add("1 90 150");
        inputs.add("5 102 198");
        
        HashMap<Integer, Solution.Racer> racers = new HashMap<Integer, Solution.Racer>();
        Solution s = new Solution();
        for(String str : inputs){
        	String[] temp = str.split(" ");
        	Solution.Racer tempRacer = new Solution.Racer(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        	racers.put(Integer.parseInt(temp[0]), tempRacer);
        	tempRacer.print();
        	
        }
        
        //HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Bucket> buckets = new ArrayList<Solution.Bucket>();
        
        for(Integer racer : racers.keySet()){
        	Racer cur = racers.get(racer);
        	Iterator<Bucket> buckItr = buckets.iterator();
        	boolean flag =true;
        	while(buckItr.hasNext()){
        		Bucket curBuck = buckItr.next();
        		if(curBuck.fallsinBucket(cur)){
        			flag = false;
        		}
        	}
        	if(flag == true){
        		buckets.add(new Bucket(cur.startTime,cur.endTime,cur.id));
        	}
        	
        }
        
        ArrayList<Bucket> newBucks = new ArrayList<Bucket>();
        ArrayList<Integer> list = buckets.get(1).racersInBucket;
        for (int i = 1; i < list.size(); i++) {
        	Racer cur = racers.get(list.get(i));
        	cur.print();
        	Iterator<Bucket> buckItr = newBucks.iterator();
        	boolean flag =true;
        	while(buckItr.hasNext()){
        		Bucket curBuck = buckItr.next();
        		if(curBuck.fallsinBucket(cur)){
        			flag = false;
        		}
        	}
        	if(flag == true){
        		newBucks.add(new Bucket(cur.startTime,cur.endTime,cur.id));
        	}
		}
        
        for(Bucket buck : newBucks){
        	buck.print();
        }
        //for
        // ...
    }


	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		ArrayList<String> input = new ArrayList<String>();
////		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        String line = null;
////        try {
////			while ((line = br.readLine()) != null) {
////				input.add(line);
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		1
////		input.add("@--");
////		input.add("---");
////		input.add("---");
////		2
//		input.add("@-v");
//		input.add("---");
//		input.add("---");
//		input.add("---");
////		3
////		input.add("@-V-");
////		input.add("----");
////		input.add("--<-");
//////		4
////		input.add("@-V");
////		input.add("---");
////		input.add("-^<");
////		5
////		input.add("@-V");
////		input.add("->-");
////		input.add("-^<");
////		6
////		input.add("@-V");
////		input.add("->V");
////		input.add("-^<");
////		
//        //size of the room
//        int height =0,width =0;
//        if(input.size()>0){
//        	height = input.size();
//        	width = input.get(0).toCharArray().length;
//        }
//        
//        char[][] inputMatrix = convertToCharArray(input,height,width);
//        String startLocation = getPos(inputMatrix,'@', width, width);
//        
////        System.out.println(height + ":" + width);
////        printCharArray(inputMatrix,height,width);
////        System.out.println(startLocation);
//        
//        String[] current = startLocation.split(":");
//        
//     
//        int curHeight  = Integer.parseInt(current[0]);
//        int curWidth = Integer.parseInt(current[1]);
//        
//        ArrayList<String> loopPosTrace = new ArrayList<String>();
//        
//        int max = 0;
//        int val =0;
////        //moveright - 0
//        if(curWidth+1 <width){
//        	val = findPathLenth(inputMatrix, height, width, curHeight, curWidth+1, 0 ,loopPosTrace);
//        	if(val>max)
//        		max= val;
//        }
////		//moveleft - 1
//        loopPosTrace.clear();
//        if(curWidth-1 >-1){
//        	val = findPathLenth(inputMatrix, height, width, curHeight, curWidth-1, 1 ,loopPosTrace);
//        	if(val>max)
//        		max= val;
//        }
//        
//        loopPosTrace.clear();
////		//moveup - 2
//        if(curHeight-1 > -1){
//        	val = findPathLenth(inputMatrix, height, width, curHeight-1, curWidth, 2 ,loopPosTrace);
//        	if(val>max)
//        		max= val;
//        }
//        
//        loopPosTrace.clear();
////		//movedown - 3
//        if(curHeight+1 <height ){
//        	val = findPathLenth(inputMatrix, height, width, curHeight+1, curWidth, 3 ,loopPosTrace);
//        	if(val>max)
//        		max= val;
//        }
//
//        System.out.println(max);
//        //int pathLength = findPathLenth(inputMatrix,height,width,curHeight,curWidth,dir);
//        
//        
//	}
//
//	private static int findPathLenth(char[][] inputMatrix,
//			 int height, int width,int curHeight, int curWidth,int dir, ArrayList<String> loopPosTrace) {
//		
////		System.out.println(curHeight+":"+curWidth);
//			int path =0;
//			int retVal=0;
//			//stopping condition
//			if(curHeight>=height || curHeight <0 || curWidth >= width || curWidth <0)
//				return 1;
//			
//			String temp = curHeight + ":" + curWidth;
//			if(loopPosTrace.contains(temp))
//				return -1;
//			
//			if(inputMatrix[curHeight][curWidth]=='-' || inputMatrix[curHeight][curWidth]=='@')
//			{
//				//maintain direction
//				if(dir==0)
//					retVal = findPathLenth(inputMatrix, height, width, curHeight, curWidth + 1, 0,loopPosTrace);
//				else if (dir == 1)
//					retVal = findPathLenth(inputMatrix, height, width, curHeight, curWidth - 1, 1,loopPosTrace);
//				else if (dir == 2)
//					retVal = findPathLenth(inputMatrix, height, width, curHeight - 1, curWidth, 2,loopPosTrace);
//				else if (dir == 3)
//					retVal = findPathLenth(inputMatrix, height, width, curHeight + 1, curWidth, 3,loopPosTrace);
//				
//			}else if (inputMatrix[curHeight][curWidth]=='>'){
//				//go right
//				loopPosTrace.add(curHeight + ":" + curWidth);
//				retVal = findPathLenth(inputMatrix, height, width, curHeight, curWidth + 1, 0,loopPosTrace);
//				
//			}else if (inputMatrix[curHeight][curWidth]=='<'){
//				//go left
//				loopPosTrace.add(curHeight + ":" + curWidth);
//				retVal = findPathLenth(inputMatrix, height, width, curHeight, curWidth - 1, 1,loopPosTrace);
//				
//			}else if (inputMatrix[curHeight][curWidth]=='^'){
//				//go up
//				loopPosTrace.add(curHeight + ":" + curWidth);
//				retVal = findPathLenth(inputMatrix, height, width, curHeight - 1, curWidth, 2,loopPosTrace);
//				
//			}else if (inputMatrix[curHeight][curWidth]=='V'){
//				//go down
//				loopPosTrace.add(curHeight + ":" + curWidth);
//				retVal = findPathLenth(inputMatrix, height, width, curHeight + 1, curWidth, 3,loopPosTrace);
//				
//			}
//			
//		if(retVal != -1)
//			path += retVal;
//		else
//			return -1;
//						
//		return path + 1;
//	}
//
//	private static String getPos(char[][] inputMatrix, char chartofind,int height,int width) {
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				if(inputMatrix[i][j]==chartofind){
//					return i+":"+j;
//				}
//			}
//		}
//
//		return null;
//	}
//
//	private static void printCharArray(char[][] inputMatrix,int height,int width) {
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				System.out.print(inputMatrix[i][j]);
//			}
//			System.out.println();
//		}
//	}
//
//	private static char[][] convertToCharArray(ArrayList<String> input, int height, int width) {
//		char[][] inputMatrix = new char[height][width];
//		int iItr =0;
//		int jItr =0;
//		for(String str : input){
//			jItr =0;
//			for(char c : str.toCharArray()){
//				inputMatrix[iItr][jItr] = c;
//				jItr++;
//			}
//			iItr++;
//		}
//		return inputMatrix;
//	}

}
