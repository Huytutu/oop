//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid=grid;
	}
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		clearRowsFromRow();
	}

	/**
	 * Identify all rows, at "row" number or higher, which are in need
	 * of being cleared. If a row is identified, we (a) clear the row;
	 * and (b) recursively re-invoke this method at that same row number
	 * to continue looking for rows to clear.
	 *
	 * @param row Starting looking at this row number (and higher) for rows to clear.
	 */
	private void clearRowsFromRow() {
		for(int i=0; i < grid[0].length;++i){
			boolean shouldClear = true;
			for (int j=0;j < grid.length;++j){
				if(!grid[j][i]){
					shouldClear=false;
				}
			}
			// clear this row (if necessary) and then recursively clear from same spot
			if ( shouldClear ) {
				collapseRowsFromRow(i);
				clearRowsFromRow();
			}
		}
	}

	/**
	 * Clear the row identified by the argument "row". All rows "above"
	 * the argument row are collapsed down by 1, and the argument "row"
	 * itself is removed. The "top" row is filled with "false" values.
	 *
	 * @param row Integer identifying the row to be cleared.
	 */
	private void collapseRowsFromRow(int row) {
		for ( int y=row+1; y < grid[0].length; ++y ) {
			for ( int x=0; x < grid.length; ++x ) {
				grid[x][y-1] = grid[x][y];
			}
		}

		// clear the "top" row, setting to false
		for ( int x=0; x < grid.length; ++x ) {
			grid[x][grid[0].length-1] = false;
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}
