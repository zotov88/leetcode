package javasolution.easy.special_positions_in_a_binary_matrix;

public class Main {

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {0, 1},
                {0, 1},
                {1, 0}
        };
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int specialCount = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && checkRowAndCol(mat, i, j)) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    private static boolean checkRowAndCol(int[][] mat, int row, int col) {
        return checkCol(mat, col) && checkRow(mat, row);
    }

    private static boolean checkRow(int[][] mat, int row) {
        int result = 0;
        for (int i = 0; i < mat[row].length; i++) {
            result += mat[row][i];
            if (result > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int[][] mat, int col) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            result += mat[i][col];
            if (result > 1) {
                return false;
            }
        }
        return true;
    }
}
