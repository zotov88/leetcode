package javasolution.medium.difference_between_ones_and_zeros_in_row_and_column;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 0, 1},
        };
        for (int[] ints : onesMinusZeros(grid)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int[][] diff = new int[grid.length][grid[0].length];
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        fillMaps(grid, rowMap, colMap);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                diff[i][j] = rowMap.get(i) + colMap.get(j);
            }
        }
        return diff;
    }

    private static void fillMaps(int[][] grid,
                                 Map<Integer, Integer> rowMap,
                                 Map<Integer, Integer> colMap) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            rowMap.put(i, getRowValue(grid, i));
        }
        for (int i = 0; i < n; i++) {
            colMap.put(i, getColValue(grid, i));
        }
    }

    private static Integer getColValue(int[][] grid, int col) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

    private static Integer getRowValue(int[][] grid, int row) {
        int result = 0;
        for (int i = 0; i < grid[row].length; i++) {
            if (grid[row][i] == 1) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}
