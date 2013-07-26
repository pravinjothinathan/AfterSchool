package gridsearch

import org.junit.Test

/**
 * Tests for GridSearch.
 *
 * @author rahulsomasunderam
 * @since 2/18/13 5:55 PM
 */
public class GridSearchTest {
  static final int[][] miniSet = [// Start list of lists
      [1, 2, 3],
      [3, 4, 6],
      [4, 6, 7],
  /* end list of lists */] as int[][]

  static final int[][] decaSet = readFile('input10.txt')
  static final int[][] hectoSet = readFile('input100.txt')
  static final int[][] kiloSet = readFile('input1000.txt')

  static int[][] readFile(String fileName) {
    def text = GridSearchTest.class.classLoader.getResourceAsStream(fileName).text
    def lines = text.split('\n')
    lines[1..-1].collect {it.split(' ').collect {Integer.parseInt(it)}}
  }

  static final GridSearch gridSearch = new GridSearch()

  @Test
  void testInit() {
    assert decaSet
    assert hectoSet
    assert kiloSet
  }

  @Test
  void testOne() {
    // This just primes the system
    gridSearch.findInGrid(miniSet, 2000)
  }

  @Test(timeout = 100L)
  void testPositive() {
    assert gridSearch.findInGrid(miniSet, 3)
    assert gridSearch.findInGrid(miniSet, 2)
    assert gridSearch.findInGrid(miniSet, 6)
    assert gridSearch.findInGrid(miniSet, 7)
    assert gridSearch.findInGrid(miniSet, 1)
  }

  @Test(timeout = 100L)
  void testNegative() {
    assert !gridSearch.findInGrid(miniSet, 5)
    assert !gridSearch.findInGrid(miniSet, 0)
    assert !gridSearch.findInGrid(miniSet, 8)
  }

  @Test(timeout = 100L)
  void testDecaPositive() {
    assert gridSearch.findInGrid(decaSet, 83)
    assert gridSearch.findInGrid(decaSet, 79)
    assert gridSearch.findInGrid(decaSet, 55)
    assert gridSearch.findInGrid(decaSet, 67)

  }

  @Test(timeout = 100L)
  void testDecaNegative() {
    assert !gridSearch.findInGrid(decaSet, 72)
    assert !gridSearch.findInGrid(decaSet, 0)
    assert !gridSearch.findInGrid(decaSet, 170)
  }

  @Test(timeout = 150L)
  void testHectoPositive() {
    assert gridSearch.findInGrid(hectoSet, 70)
    assert gridSearch.findInGrid(hectoSet, 5066)
    assert gridSearch.findInGrid(hectoSet, 5191)
    assert gridSearch.findInGrid(hectoSet, 5750)
  }

  @Test(timeout = 150L)
  void testHectoNegative() {
    assert !gridSearch.findInGrid(hectoSet, 5751)
    assert !gridSearch.findInGrid(hectoSet, 69)
    assert !gridSearch.findInGrid(hectoSet, 14487)
    assert !gridSearch.findInGrid(hectoSet, 14600)
  }

  @Test(timeout = 250L)
  void testKiloPositive() {
    assert gridSearch.findInGrid(kiloSet, 566)
    assert gridSearch.findInGrid(kiloSet, 501189)
    assert gridSearch.findInGrid(kiloSet, 510923)
    assert gridSearch.findInGrid(kiloSet, 1497341)
    assert gridSearch.findInGrid(kiloSet, 791906)
  }

  @Test(timeout = 250L)
  void testKiloNegative() {
    assert !gridSearch.findInGrid(kiloSet, 791901)
    assert !gridSearch.findInGrid(kiloSet, 69)
    assert !gridSearch.findInGrid(kiloSet, 1497342)
    assert !gridSearch.findInGrid(kiloSet, 1497340)
  }
}
