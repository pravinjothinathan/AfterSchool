package TestHighlight;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import Highlighter.Parser;
import Highlighter.Windows;
import Highlighter.Word;

public class WindowsTest {

	@Test
	public void testIndetifyWindows() {
		Windows window = new Windows();
		Parser parser = new Parser();
		HashMap<String,Integer> tokens = parser.getQueryMap("search string");
	
 		ArrayList<Word> pos = parser.parseDocforWords("this is a sample search string phrase phrase phrase blah string", tokens);		
 
 		ArrayList<String> stack = window.indetifyWindows(pos, 15);
 		Assert.assertNotNull(stack);
	}

	@Test
	public void testGetWindowfromText() {
		Windows window = new Windows();
		String windowStr = "4,0:5,1:";
		Assert.assertNotNull(window.getWindowfromText("this is a sample search string phrase phrase phrase blah string ", windowStr, 25));
	}

}
