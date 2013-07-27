package numberpicker

/**
 * The number picker game.
 * <ul>
 *   <li>The game starts with a list of numbers that is completely visible to both players.</li>
 *   <li>Always assume you play first.</li>
 *   <li>When their turn comes, each player can choose a number from either end of the list.</li>
 *   <li>When there are no numbers left on the board, you sum all the numbers you've collected.</li>
 *   <li>The player with the greater sum wins.</li>
 *   <li>Assume both players have the best possible algorithm - your algorithm.</li>
 * </ul>
 * <p>You must find if the player who starts, i.e. you will win the game.</p>
 * <p>Oh, and this list can be really huge.</p>
 * <p>There are only acceptance tests. Feel free to add more unit tests</p>
 * @author rahulsomasunderam
 * @since 1/27/13 9:16 AM
 */
class NumberPicker {

	/**
	 * This describes the result of a game.
	 */
	static enum Result {
		Win, Lose, Draw
	}

	/**
	 * Summarizes a list into a single value.
	 * @param input the list of numbers
	 * @return
	 */
	def input;
	/*
	 * Reduced the memoization load by using a single array
	 * by adding parameters for the start and end Index
	 * to the findMax function
	 */
	
	def findMax = {
		startIndex,endIndex,input ->
		if (input.size() == 0)
			return 0
		else if (startIndex == endIndex)
			return input[startIndex]
		else{
			int size = input.size()
			int leftHead = input[startIndex]
			int rightHead = input[endIndex]
			Math.max(leftHead - findMax.call(startIndex+1, endIndex, input), rightHead - findMax.call(startIndex,endIndex-1,input))
		}
	}.memoize();





	/**
	 * Given a list of numbers, tells who can win the game.
	 * @param input the list of numbers
	 * @return The result of the game
	 */
	public Result findWinner(List<Integer> input) {
		int firstPlayerValue = findMax(0, input.size() -1,input);
		if (firstPlayerValue > 0) {
			Result.Win
		} else if (firstPlayerValue < 0) {
			Result.Lose
		} else {
			Result.Draw
		}
	}


	// Initial Code
	//  int count;
	//  private int valueOfListImpl(List<Integer> input) {
	//	count++;
	//    if (input.size()==0) {
	//      // If the list is empty, you get 0 points
	//      return 0
	//    } else if (input.size()==1) {
	//      // If the list has one element, you get the points from that element
	//      return input[0]
	//    } else {
	//      // If the list is larger, compute it's value.
	//      /*
	//       * Left head is the first element of the list
	//       * Right head is the last element of the list
	//       * Left tail is whatever is left of the list when you remove the left head.
	//       * Right tail is whatever is left of the list when you remove the right head.
	//       */
	//
	//	  int size = input.size()
	//      int leftHead = input[0]
	//      List<Integer> leftTail = input[1..size-1]
	//      int rightHead = input[size -1]
	//      List<Integer> rightTail = input[0..size-2]
	//
	////      int headVal = leftHead - valueOfList(leftTail)
	////      int tailVal = rightHead - valueOfList(rightTail)
	//
	//      Math.max(leftHead - valueOfList(leftTail), rightHead - valueOfList(rightTail))
	//    }
	//  }

	//
	//  private final valueOfListClosure = { List<Integer> input ->
	//    return this.valueOfListImpl(input)
	//  }
	//
	//  private final valueOfList =  valueOfListClosure.memoize()

}
