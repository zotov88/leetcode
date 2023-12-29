package java.medium.number_of_islands;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'0', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '0', '0'},
                {'1', '1', '1', '0', '0'}};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        char marker = '2';

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j, marker);
                    marker++;
                }
            }
        }
        return marker - 2 - 48;
    }

    private static void markIsland(char[][] grid, int i, int j, char marker) {
        grid[i][j] = marker;
        List<Point> points = getEarthCoordinateIfNear(grid, i, j);
        if (!points.isEmpty()) {
            for (Point point : points) {
                markIsland(grid, point.x, point.y, marker);
            }
        }

    }

    private static List<Point> getEarthCoordinateIfNear(char[][] grid, int i, int j) {
        List<Point> points = new ArrayList<>();

        if (i != 0 && grid[i - 1][j] == '1') {
            points.add(new Point(i - 1, j));
        }
        if (i != grid.length - 1 && grid[i + 1][j] == '1') {
            points.add(new Point(i + 1, j));
        }
        if (j != 0 && grid[i][j - 1] == '1') {
            points.add(new Point(i, j - 1));
        }
        if (j != grid[i].length - 1 && grid[i][j + 1] == '1') {
            points.add(new Point(i, j + 1));
        }

        return points;
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
