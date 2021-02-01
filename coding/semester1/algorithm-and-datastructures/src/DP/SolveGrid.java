package DP;

import java.util.Arrays;

public class SolveGrid {

    public static void main(String[] args) {
        // searches for the shortest path from top to bottom of the grid
        // sample input
        int[][] grid = { { 13, 5, 12, 16 }, { 1, 10, 7, 14 }, { 2, 11, 15, 8 }, { 3, 6, 4, 9 } };

        System.out.println("expected: 11\noutput: " + solveGrid(grid));

        int[][] grid2 = { { 8, 9, 3, 5 }, { 10, 7, 12, 4 }, { 15, 14, 6, 16 }, { 11, 1, 13, 2 }, };

        System.out.println("expected: 14\noutput: " + solveGrid(grid2));
    }

    public static int solveGrid(int[][] grid) {
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                if (j == 0) {
                    // on left edge
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i - 1][j + 1]);
                } else if (j == grid.length - 1) {
                    // on right edge
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i - 1][j - 1]);
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], Math.min(grid[i - 1][j - 1], grid[i - 1][j + 1]));
                }

            }
        }

        for (int i = 0; i < grid.length; i++) {
            ans = Math.min(ans, grid[grid.length - 1][i]);
        }

        return ans;
    }
}
