package java.medium.kth_smallest_element_in_a_sorted_matrix;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 4));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], 0);
                }
                map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
            }
        }

        int result = 0;
        int sum = 0;
        for (Integer i : map.keySet()) {
            while (map.get(i) > 0 && sum != k) {
                sum++;
                map.put(i, map.get(i) - 1);
            }
            if (sum == k) {
                result = i;
                break;
            }
        }

        return result;
    }
}
