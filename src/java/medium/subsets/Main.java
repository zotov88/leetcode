package java.medium.subsets;

import java.util.ArrayList;
import java.util.List;

// TODO переделать, есть ошибка
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
        }
        return lists;
    }
}
