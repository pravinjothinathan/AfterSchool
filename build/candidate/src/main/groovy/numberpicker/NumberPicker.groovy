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
  private int valueOfListImpl(List<Integer> input) {
    if (/* TODO 1: Detect empty list */ implementBoolean()) {
      // If the list is empty, you get 0 points
      0
    } else if (/* TODO 2: Detect list having only one element */ implementBoolean()) {
      // If the list has one element, you get the points from that element
      /* TODO 3: Return points from the list */ implementInt()
    } else {
      // If the list is larger, compute it's value.
      /*
       * Left head is the first element of the list
       * Right head is the last element of the list
       * Left tail is whatever is left of the list when you remove the left head.
       * Right tail is whatever is left of the list when you remove the right head.
       */
      int leftHead = /* TODO 4: Figure out the left head */ implementInt()
      List<Integer> leftTail = /* TODO 5: Figure out the left tail */ implementList()
      int rightHead = /* TODO 6: Figure out the right head */ implementInt()
      List<Integer> rightTail = /* TODO 7: Figure out the right tail */ implementList()

      int headVal = leftHead - valueOfList(leftTail)
      int tailVal = rightHead - valueOfList(rightTail)

      Math.max(headVal, tailVal)
    }
  }

  /**
   * Given a list of numbers, tells who can win the game.
   * @param input the list of numbers
   * @return The result of the game
   */
  public Result findWinner(List<Integer> input) {
    int firstPlayerValue = /* TODO 8: Find the value of the list to the first player */ implementInt()
    if (/* TODO 9: Find out when the first player wins */ implementBoolean()) {
      Result.Win
    } else if (/* TODO 10: Find out when the first player loses */ implementBoolean()) {
      Result.Lose
    } else {
      Result.Draw
    }
  }


  private final valueOfListClosure = { List<Integer> input ->
    return this.valueOfListImpl(input)
  }

  private final valueOfList = valueOfListClosure.memoize()

  boolean /* TODO 11: This method should have no users. Remove it. */ implementBoolean() {
    throw new RuntimeException("implement this")
  }

  int /* TODO 12: This method should have no users. Remove it. */ implementInt() {
    throw new RuntimeException("implement this")
  }

  List<Integer> /* TODO 13: This method should have no users. Remove it. */ implementList() {
    throw new RuntimeException("implement this")
  }

}
