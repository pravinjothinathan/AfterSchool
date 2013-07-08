package TestHighlight;


import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import Highlighter.Parser;

public class TestParser {

	@Test
	public void testParseDocforWords() {
		Parser parser = new Parser();
		
		HashMap<String,Integer> tokens = parser.getQueryMap("search string");
		
		String text = "this is a sample text to check whether the test finds the search string";
		//checking not null
		Assert.assertNotNull(parser.parseDocforWords(text, tokens));
		
		//checking null
		text = "";
		Assert.assertNull(parser.parseDocforWords(text, tokens));
		
		
	}

	@Test
	public void testGetQueryMap() {
		Parser parser = new Parser();
		
		Assert.assertNotNull(parser.getQueryMap("search string"));
		
		Assert.assertNull(parser.getQueryMap(""));
	}

}
