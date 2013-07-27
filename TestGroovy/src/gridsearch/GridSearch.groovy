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
		// Yes! In this test, you get to do the design as well as the implementation
		int size = grid.size() -1
		def pos = new Position()
		pos.i = 0;
		pos.j = size;

		//flag==0-> descending vertically flag==1 descending horizontally
		boolean flag = true;

		while(true){
			//to toggle between vertical and horizontal movements
			boolean localFlag = false;

			//Array out of bounds check true -> return null
			if(pos.i>size || pos.j<0){
				return null
			}

			//If the Element is present return position
			if(grid[pos.i][pos.j]==num){
				return pos
				break;
			}

			//move vertically
			if(flag==true && grid[pos.i][pos.j]<=num){
				pos.i += 1;
			}else
				localFlag = true

			//move horizontally
			if(flag==false && grid[pos.i][pos.j]>=num){
				pos.j -= 1;
			}else
				localFlag = true

			if(localFlag)
				flag = !flag
		}


		null
	}

}
