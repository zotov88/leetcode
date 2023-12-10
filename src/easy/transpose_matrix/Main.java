package easy.transpose_matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2, 4, -1},
                {-10, 5, 11},
                {18, -7, 6}
        };
        for (int[] ints : transpose(matrix)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
