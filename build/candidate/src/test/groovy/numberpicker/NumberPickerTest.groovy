package numberpicker;

import org.junit.Test;
import numberpicker.NumberPicker.Result

/**
 * Tests for NumberPicker
 *
 * @author rahulsomasunderam
 * @since 2/18/13 12:59 PM
 */
class NumberPickerTest {
  def n = new NumberPicker()

  @Test(timeout=1000L)
  void testBasic() {
    assert n.findWinner([]) == Result.Draw
    assert n.findWinner([0]) == Result.Draw
    assert n.findWinner([1]) == Result.Win
    assert n.findWinner([1, 2]) == Result.Win
    assert n.findWinner([1, 1]) == Result.Draw
    assert n.findWinner([1, 2, 1]) == Result.Draw
    assert n.findWinner([1, 3, 1]) == Result.Lose
    assert n.findWinner([1, 3, 1]) == Result.Lose
    assert n.findWinner([1, 3, 7, 2, -4, 3, 2, 9]) == Result.Win
    assert n.findWinner([1, 3, -4, -9, 13, -4, 3, 2, 9]) == Result.Lose
  }

  @Test(timeout=1000L)
  void testSmall() {
    def nums1 = this.class.classLoader.getResourceAsStream('small1.txt').text.split(/\n/).collect {Integer.parseInt(it)}
    assert n.findWinner(nums1) == Result.Lose
    def nums2 = this.class.classLoader.getResourceAsStream('small2.txt').text.split(/\n/).collect {Integer.parseInt(it)}
    assert n.findWinner(nums2) == Result.Lose
  }

}
