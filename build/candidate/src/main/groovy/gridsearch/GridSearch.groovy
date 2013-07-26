package gridsearch

/**
 * Grid Search
 *
 * You've been given a grid of dimensions M x N. This grid is special though. There are some rules for numbers
 * in this grid.
 *
 * <ul>
 *   <li><code>grid[i][j] > grid[i][j-1]</code> for <code>0 < j < N-1 </code></li>
 *   <li><code>grid[i][j] > grid[i-1][j]</code> for <code>0 < i < M-1 </code></li>
 * </ul>
 *
 * <p>You must find if a given number exists in this grid at all.</p>
 * <p>Oh, and this grid can be really huge, so optimize your execution speed.</p>
 * @author rahulsomasunderam
 * @since 1/27/13 9:58 AM
 */
class GridSearch {
  static class Position {
    int i, j
  }

  /**
   * Finds the element in the grid
   * @param grid The grid
   * @param num the number to find
   * @return the position of the number or null
   */
  Position findInGrid(grid, int num) {
    // TODO 1: Implement this function
    // Yes! In this test, you get to do the design as well as the implementation
    null
  }

}
