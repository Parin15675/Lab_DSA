package solutions.pack;

public class GridPaths {

    public static int numberOfPaths(int[][] grid) {
        return numberOfPath_helper(grid, 0, 0);
    }

    private static int numberOfPath_helper(int[][] grid, int column, int row) {
        // Base case
        if (column >= grid.length) {
            return 0;
        }

        if (row >= grid[column].length) {
            return numberOfPath_helper(grid, column + 1, 0);
        }

        int result = 0;
        if (grid[column][row] == 1) {
            result = 1;
        } else {
            result = 0;
        }

        return result + numberOfPath_helper(grid, column, row + 1);
    }
}
