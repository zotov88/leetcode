package medium.set_matrix_zeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 3, 2, 6},
                {3, 4, 5, 2},
                {3, 1, 2, 0},
                {3, 6, 2, 5},
        };
        setZeroes(matrix);
        printMatrix(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        List<Point> zeroPositions = getZeroPosition(matrix);
        for (Point zeroPosition : zeroPositions) {
            setColAndRowZeroes(matrix, zeroPosition);
        }
    }

    private static void setColAndRowZeroes(int[][] matrix, Point zeroPosition) {
        setRowZeroes(matrix, zeroPosition.getX());
        printMatrix(matrix);
        setColZeroes(matrix, zeroPosition.getY());
        printMatrix(matrix);
    }

    private static void setRowZeroes(int[][] matrix, int rowIdx) {
        int size = matrix[rowIdx].length;
        for (int i = 0; i < size; i++) {
            matrix[rowIdx][i] = 0;
        }
    }

    private static void setColZeroes(int[][] matrix, int colIdx) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIdx] = 0;
        }
    }

    private static List<Point> getZeroPosition(int[][] matrix) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    points.add(new Point(i, j));
                }
            }
        }
        return points;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    static class Point {

        private final int x;

        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
