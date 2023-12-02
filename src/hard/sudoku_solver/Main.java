package hard.sudoku_solver;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.',     '.', '7', '.',     '.', '.', '.'},
                {'6', '.', '.',     '1', '9', '5',     '.', '.', '.'},
                {'.', '9', '8',     '.', '.', '.',     '.', '6', '.'},

                {'8', '.', '.',     '.', '6', '.',     '.', '.', '3'},
                {'4', '.', '.',     '8', '.', '3',     '.', '.', '1'},
                {'7', '.', '.',     '.', '2', '.',     '.', '.', '6'},

                {'.', '6', '.',     '.', '.', '.',     '2', '8', '.'},
                {'.', '.', '.',     '4', '1', '9',     '.', '.', '5'},
                {'.', '.', '.',     '.', '8', '.',     '.', '7', '9'}
        };
//
//        char[][] board = new char[][]{
//                {'.','.','9',   '7','4','8',    '.','.','.'},
//                {'7','.','.',   '.','.','.',    '.','.','.'},
//                {'.','2','.',   '1','.','9',    '.','.','.'},
//                {'.','.','7',   '.','.','.',    '2','4','.'},
//                {'.','6','4',   '.','1','.',    '5','9','.'},
//                {'.','9','8',   '.','.','.',    '3','.','.'},
//                {'.','.','.',   '8','.','3',    '.','2','.'},
//                {'.','.','.',   '.','.','.',    '.','.','6'},
//                {'.','.','.',   '2','7','5',    '9','.','.'}
//        };

        printBoard(board);
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        BoardAudit boardAudit = new BoardAudit(board);
        boolean isChange = false;

        while (!boardAudit.allListFull()) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        board[i][j] = boardAudit.findNumber(i, j);
                        isChange = true;
                    }
                }
            }
            printBoard(board);
        }
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
//        System.out.print("[");
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]) + (i + 1 == board.length ? "" : ", "));
        }
        System.out.println();
    }


    static class BoardAudit {

        char[][] board;
        List<Set<Character>> rowList;
        List<Set<Character>> columnList;
        List<Set<Character>> squareList;
        int[][] indexesSquares = new int[][]{{0, 3, 6}, {1, 4, 7}, {2, 5, 8}};

        public BoardAudit(char[][] board) {
            this.board = board;
            this.rowList = getRowList();
            this.columnList = getColumnList();
            this.squareList = getSquareList();
        }

        private List<Set<Character>> getSquareList() {
            List<Set<Character>> squareList = new ArrayList<>();
            Set<Character> characters = null;
            int start = 0;

            while (start < 9) {
                for (int i = 0; i < board.length; i++) {
                    if (i % 3 == 0) {
                        characters = new HashSet<>();
                    }
                    for (int j = start; j < start + 3; j++) {
                        if (board[i][j] != '.') {
                            characters.add(board[i][j]);
                        }
                    }
                    if ((i + 1) % 3 == 0) {
                        squareList.add(characters);
                    }
                }
                start += 3;
            }

            return squareList;
        }

        private List<Set<Character>> getRowList() {
            List<Set<Character>> rowList = new ArrayList<>();
            for (char[] chars : board) {
                Set<Character> characters = new HashSet<>();
                for (char ch : chars) {
                    if (ch != '.') {
                        characters.add(ch);
                    }
                }
                rowList.add(characters);
            }
            return rowList;
        }

        private List<Set<Character>> getColumnList() {
            List<Set<Character>> columList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                Set<Character> characters = new HashSet<>();
                for (int j = 0; j < board[i].length; j++) {
                    if (board[j][i] != '.') {
                        characters.add(board[j][i]);
                    }
                }
                columList.add(characters);
            }
            return columList;
        }

        public boolean allListFull() {
            int sizeRows = rowList.stream().mapToInt(Set::size).sum();
            int sizeColumns = columnList.stream().mapToInt(Set::size).sum();
            int sizeSquares = squareList.stream().mapToInt(Set::size).sum();
            return sizeRows + sizeColumns + sizeSquares == 81 * 3;
        }

        private Set<Character> getFullSet() {
            return new HashSet<>(Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        }

        public char findNumber(int row, int column) {
            char ch = '.';
            HashSet<Character> destAllSet = new HashSet<>();

            destAllSet.addAll(rowList.get(row));
            destAllSet.addAll(columnList.get(column));
            destAllSet.addAll(squareList.get(indexesSquares[row / 3][column / 3]));

            Set<Character> tmpSet = getFullSet();
            tmpSet.removeAll(destAllSet);
            if (tmpSet.size() == 1) {
                for (Character c : tmpSet) {
                    ch = c;
                }
                rowList.get(row).add(ch);
                columnList.get(column).add(ch);
                squareList.get(indexesSquares[row / 3][column / 3]).add(ch);
            }
            return ch;
        }
    }
}
