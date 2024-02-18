package javasolution.easy.pascals_triangle_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            int index1 = 0;
            int index2 = 1;

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    int one = lists.get(lists.size() - 1).get(index1++);
                    int two = lists.get(lists.size() - 1).get(index2++);
                    list.add(one + two);
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
