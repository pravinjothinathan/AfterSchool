package TestHighlight;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import Highlighter.Parser;
import Highlighter.Ranker;

public class TestRanker {

	@Test
	public void testGetMaxRankingWindow() {
		
		ArrayList<String> stack = new ArrayList<String>();
		
		stack.add("4,0:5,1:");
		stack.add("5,1:");
		stack.add("10,1:");
		
		Parser parser = new Parser();		
		HashMap<String,Integer> tokens = parser.getQueryMap("search string");

		Ranker ranker = new Ranker();
		String windowStr = ranker.getMaxRankingWindow(stack, tokens);
		
		Assert.assertNotNull(windowStr);
		Assert.assertEquals("4,0:5,1:", windowStr);
	}

}
