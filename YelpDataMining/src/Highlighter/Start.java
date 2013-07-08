package Highlighter;
import java.util.ArrayList;
import java.util.HashMap;


public final class Start {
	
	/*
	 * args[0] -> Review to Search [String]
	 * args[1] -> Search Phrase [String]
	 * args[1] -> Window Size [Integer]
	 * 
	 * Output -> Prints the Most Relevent output
	 * 
	 * */

	public static void main(String[] args) {
		
		String paragraphToSearch = args[0];
		
		String searchPhrases = args[1];
		
		System.out.println(paragraphToSearch);
		
		int windowSize = Integer.parseInt(args[2]);
		
		Parser parser = new Parser();
		HashMap<String,Integer> tokens = parser.getQueryMap(searchPhrases);//parser.getQueryMap(searchPhrases);
		
		if(tokens!=null){
			ArrayList<Word> pos = parser.parseDocforWords(paragraphToSearch, tokens);		
			if(pos.size()>0){
				Windows window = new Windows();
				ArrayList<String> stack = window.indetifyWindows(pos, windowSize);		
				
				Ranker ranker = new Ranker();
				String windowStr = ranker.getMaxRankingWindow(stack,tokens);
				
				String windowtext = window.getWindowfromText(paragraphToSearch,windowStr,windowSize);
				
				Highlighter hilighter = new Highlighter();
				String highlightedText = hilighter.getHighlightedText(windowtext,tokens);
				System.out.println(highlightedText);
			}else{
				System.out.println("No Matching Phrases present");
			}

		}else{
			System.out.println("Search Phrase is Empty");
		}

	}

	
}
