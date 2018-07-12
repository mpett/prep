package test;

import java.io.*;
import java.util.*;

public class GridSolution {
	private int rows;
	private int cols;
	private int[][] grid;
	
	public GridSolution(int n, int m, int[][] grid) {
		this.rows = n;
		this.cols = m;
		this.grid = grid;
	}
	
	// Returns true if cell is filled and not visited.
	public boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= rows || y >= cols || 
				grid[x][y] < 1) {
			return false;
		} else {
			return true;
		}
	}
	
	// Use DFS to count number of cells connected to x,y
	public int dfs(int x, int y) {
		if (isValid(x,y) == false) {
			return 0;
		}
		
		int count = 1;
		int newX = x;
		int newY = y;
		grid[x][y] = -1;
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				newX = x+i;
				newY = y+j;
				count = count + dfs(newX, newY);
			}
		}
		
		return count;
	}
	
	// Find the largest region in the matrix.
	public int solve() {
		int maxVal = 0;
		int tempVal = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				tempVal = dfs(i,j);
				if (tempVal > maxVal) {
					maxVal = tempVal;
				}
			}
		}
		
		return maxVal;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] matrix = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		GridSolution gs = new GridSolution(n,m,matrix);
		System.out.println(gs.solve());
	}
}
