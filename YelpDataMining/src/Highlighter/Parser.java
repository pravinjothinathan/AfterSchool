package Highlighter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Parser {
	/*
	 * arg[0]  -> paragraphToSearch [String] - text to be searched
	 * args[1] -> HashMap<String,Integers> - tokens that are returned 
	 * by getQueryMap
	 * 
	 * returns -> ArrayList<Word> matching strings are put in a word
	 * and returned
	 * 
	 * Algorithm-> Does a complete pass and checks for the match in args[1]
	 * if a match is found its pushed into the List with some meta data O(n)*/
	public ArrayList<Word> parseDocforWords(String paragraphToSearch,
			HashMap<String, Integer> tokens) {
		if(tokens==null)
			return null;
		
		ArrayList<Word> pos = new ArrayList<Word>();	
		StringTokenizer st1 = new StringTokenizer(paragraphToSearch);

		if(st1.countTokens()<1)
			return null;
		
		int posItr = 0;
		int charPosItr =0;
		while(st1.hasMoreTokens()){
			String temp = st1.nextToken();
			if(tokens.containsKey(temp)){
//				System.out.println(temp);
				Word tempWord = new Word(tokens.get(temp),posItr,charPosItr,temp.length());
				pos.add(tempWord);
			}
			posItr++;
			charPosItr += temp.length();
		}
		
		return pos;
	}
	/*
	 *  arg[0] -> Search Phrase that is to be searched [String]
	 *  
	 *  returns -> HashMap<String,Integer> which is a tokenized 
	 *  version of search words that points to the Id of the search phrase*/
	
	public HashMap<String, Integer> getQueryMap(String searchPhrases) {
		
		StringTokenizer st = new StringTokenizer(searchPhrases);
		if(st.countTokens()<1)
			return null;
		
		HashMap<String,Integer> tokens = new HashMap<String,Integer>();
		int tokenItr = 0;
		while(st.hasMoreTokens()){
			tokens.put(st.nextToken(),tokenItr++);
		}
		return tokens;
	}

}
