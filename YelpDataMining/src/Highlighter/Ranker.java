package Highlighter;

import java.util.ArrayList;
import java.util.HashMap;

import Helper.Helper;


public class Ranker {

	final int wordScore = 2;
	
	/*
	 * args[0] -> ArrayList<String> possible windows
	 * args[1] -> HashMap<String, Integer> Search Phrases in a map
	 * 
	 * retuns -> String the max Ranked Window*/
	public String getMaxRankingWindow(ArrayList<String> stack, HashMap<String, Integer> tokens) {	
		ArrayList<Double> windowRanks = getWindowRankgivenWindows(stack,tokens);
		Helper helper = new Helper();
		int index = helper.getMaxScoreIndexfromArrLst(windowRanks);
		return stack.get(index);
	}

	/*
	 * args[0] -> ArrayList<String> all possible windows
	 * args[1] -> HashMap<String, Integer> HashMap<String, Integer>
	 * 
	 * returns -> ArrayList<Double> score for each window
	 * 
	 * Algorithm -> Each match term is given a score of 2
	 * If there are consecutive words the score is multiplied by 2
	 * Separate terms are added
	 * 
	 * O(nm) n - number of windows
	 *		 m - no of search terms that contribute to the window*/
	private ArrayList<Double> getWindowRankgivenWindows(
			ArrayList<String> stack, HashMap<String, Integer> tokens) {
			ArrayList<Double> score = new ArrayList<Double>();
			for(String str : stack){
				String[] worddIds = str.split(":");
				int totScore = 0;
				for (int i = 0; i < worddIds.length; i++) {
//					System.out.println(worddIds[i]);
					String[] tokensI = worddIds[i].split(",");
					int curScore = 2;
					for (int j = i+1; j < worddIds.length; j++) {
						String[] tokensJ = worddIds[j].split(",");
//						System.out.println(Integer.parseInt(tokensI[1])+1+":"+Integer.parseInt(tokensJ[1]));
						if(Integer.parseInt(tokensI[1])+1==Integer.parseInt(tokensJ[1])){
							curScore *= 2;
							tokensI =tokensJ;
						}
						else{
							break;
						}
					}
					totScore += curScore;
				}
				score.add((double)totScore);
//				System.out.println("totScore"+totScore);
			}
			
		return score;
	}

	
}
