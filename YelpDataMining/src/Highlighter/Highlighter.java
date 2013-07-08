package Highlighter;
import java.util.HashMap;


public class Highlighter {
	
	/*
	 * args[0] -> [String] text that is to be displayed
	 * args[1] -> HashMap<String, Integer> token map of search phrases
	 * 
	 * returns -> the String that is to be displayed*/
	public String getHighlightedText(String windowtext,
			HashMap<String, Integer> tokens) {

		String highlightedText ="";

		if(tokens!=null){
			String[] words = windowtext.split(" ");
			for (int i = 0; i < words.length; i++) {
				if(tokens.containsKey(words[i]))
				{
					highlightedText += "<beginHighlight> " + words[i] +" ";
					while(i+1<words.length){
						if(tokens.containsKey(words[i+1])){
							highlightedText += words[i+1] +" ";
							i++;
						}else{
							break;
						}
					}
					highlightedText += "<endHighlight> ";
				}else{
					highlightedText += words[i]+ " ";
				}
			}
		}	
		return highlightedText;
	}

}
