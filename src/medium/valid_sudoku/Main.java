package medium.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0, j = 0; i < board.length; i++, j++) {
            if (!isValidRow(board, i) || !isValidColumn(board, j)) {
                return false;
            }
            if (isTimeToCheckSquares(i) && !isValidSquares(board, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidSquares(char[][] board, int index) {
        for (int i = 0; i < board.length; i += 3) {
            Set<Character> set = new HashSet<>();

            for (int j = index; j < index + 3; j++) {
                for (int k = i; k < i + 3; k++) {
                    if (board[j][k] != '.' && !set.add(board[j][k])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int index) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != '.' && !set.add(board[i][index])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidRow(char[][] board, int index) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            if (board[index][i] != '.' && !set.add(board[index][i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isTimeToCheckSquares(int index) {
        return index == 0 || index == 3 || index == 6;
    }
}
