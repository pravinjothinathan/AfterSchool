package Highlighter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Windows {
	/*
	 * 
	 * args[0]-> ArrayList<Word> returned by Parser.parseDocforWords
	 * args[1]-> Window Size
	 * 
	 * returns -> ArrayList<Strings> possible windows that fit WindowSize
	 * 
	 * algorithm -> Starting from the first word in the list rest of the words 
	 * are iterated till it crosses the window limit once reached the algorithm 
	 * is started from the next word in the list
	 * O(nm) n-being no of matched words
	 * 		 m-words that accomodate in the window
	 * */
	public ArrayList<String> indetifyWindows(ArrayList<Word> pos, int windowSize) {
		ArrayList<String> stack = new ArrayList<String>();
		String temp ="";
		boolean windowComplete = false;
		for (int i = 0; i < pos.size(); i++) {
			Word windowStart = pos.get(i);
			temp = String.format("%d,%d:",windowStart.position,windowStart.wordId);
			for (int j = i+1; j < pos.size(); j++) {
				Word windowEnd = pos.get(j);
				if(windowEnd.charPosition - windowStart.charPosition < windowSize){
					//System.out.println("end"+windowEnd.charPosition+"start"+windowStart.charPosition);
					temp += String.format("%d,%d:",windowEnd.position,windowEnd.wordId);
					if(j==pos.size()-1){
						//System.out.println(temp);
						windowComplete = true;
					}
				}
				else{
					stack.add(temp);
					temp ="";
					break;
				}
			}
			if(temp!="")
				stack.add(temp);
			if(windowComplete == true){
				break;
			}
		}
		return stack;
	}

	/*
	 * args[0] -> [String] paragraph to search
	 * args[1] -> [String] windowStr thats the highest rated window
	 * args[2] -> [int] window Size
	 * 
	 * returns -> String that corresponds to the window
	 * 
	 * Algorithm -> The whole paragraph is parsed
	 * 	the search texts starting and end locations are got from window Str
	 *  the iterator adds a string to the left side first and then to the right 
	 *  till the window lmit is reached
	 *  
	 *  o(n) - tokens in the paragraph*/
	public String getWindowfromText(String paragraphToSearch, String windowStr,
			int windowSize) {
		StringTokenizer st = new StringTokenizer(paragraphToSearch);
		ArrayList<String> doc = new ArrayList<String>();
		
		String[] windowWords = windowStr.split(":");
		//window start 
		int startLoc = Integer.parseInt(windowWords[0].split(",")[0]);
		//window End
		int endLoc = Integer.parseInt(windowWords[windowWords.length-1].split(",")[0]);

		int wordItr =0;
		String finalString ="";
		while(st.hasMoreTokens()){
			String temp = st.nextToken(); 
			doc.add(temp);
			if(wordItr>=startLoc&&wordItr<=endLoc){
				finalString += temp + " ";
			}		
			wordItr++;
		}
		
		int leftItr=1;
		int rightItr=1;
		
		for(int i =0;;i++){
			String temp ="";
			if(i%2==0){
				if(startLoc-leftItr>0){
					temp = doc.get(startLoc-leftItr);
					leftItr++;
				}
			}else{
				if(endLoc+rightItr<doc.size()){
					temp = doc.get(endLoc+rightItr);
					rightItr++;
				}
			}
			if(finalString.length()+temp.length()<windowSize){
				if(i%2==0){
					if(temp!="")
					finalString = temp + " " + finalString;
				}else{
					if(temp!="")
					finalString = finalString + " " + temp;
				}
			}else{
				break;
			}
		}
		
		return finalString;
	}

	
}
