package TestHighlight;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import Highlighter.Highlighter;
import Highlighter.Parser;

public class TestHighlighter {

	@Test
	public void test() {

		Highlighter hilighter = new Highlighter();
		
		Parser parser = new Parser();
		
		HashMap<String,Integer> tokens= parser.getQueryMap("search string");
		
		String windowtext = "this is a test search";
		
		Assert.assertNotNull(hilighter.getHighlightedText(windowtext, tokens));
		
		Assert.assertEquals("this is a test <beginHighlight> search <endHighlight>", hilighter.getHighlightedText(windowtext, tokens).trim());
		
		windowtext = "search this is a test search";
		
		Assert.assertNotNull(hilighter.getHighlightedText(windowtext, tokens));
		
		Assert.assertEquals("<beginHighlight> search <endHighlight> this is a test <beginHighlight> search <endHighlight>", hilighter.getHighlightedText(windowtext, tokens).trim());
		
		Assert.assertNotNull(hilighter.getHighlightedText(windowtext, null));
		
		Assert.assertNotNull(hilighter.getHighlightedText("", tokens));
		
	}

}
