package Highlighter;
/*
 * 
 * This is Class for storing meta information of the match words
 * 
 * WordId [int]-> Id of the match word as in tokens
 * Position [int]-> Position of the word in Doc
 * charPosition [int] -> cumilative position of the word in the doc
 * length -> length of the corresponding word
 * 
 * */

public class Word {
	
	
	public Word(Integer id, int posItr, int charPosItr, int len) {
		wordId = id;
		position = posItr;
		charPosition = charPosItr;
		length = len;
	}
	
	public void Print(){
		System.out.println(wordId+":"+position+":"+charPosition);
	}
	
	int wordId;
	int position;
	int charPosition;
	int length;

}
