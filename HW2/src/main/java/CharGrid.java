// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.util.Set;
import java.util.TreeSet;

public class CharGrid {
	private char[][] grid;
	private int cnt;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */

	public int charArea(char ch) {
		TreeSet <Integer> row = new TreeSet<>();
		TreeSet <Integer> column = new TreeSet<>();
		for (int i=0;i< grid.length;++i){
			for(int j =0;j< grid[i].length;++j){
				if (grid[i][j] == ch){
					row.add(i);
					column.add(j);
				}
			}
		}
		return (row.last()-row.first()+1)*(column.last()-column.first()+1); // YOUR CODE HERE
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		for(int i=1;i<grid.length-1;++i){
			for(int j=1;j<grid[0].length-1;++j){
				if (grid[i][j]==grid[i-1][j] && grid[i][j]==grid[i+1][j] && grid[i][j]==grid[i][j+1] && grid[i][j]==grid[i][j-1]){
					cnt++;
				}
			}

		}
		return cnt; // YOUR CODE HERE
	}

}
