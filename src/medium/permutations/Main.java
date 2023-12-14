package medium.permutations;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return List.of(List.of(nums[0]));
        }

        if (nums.length == 2) {
            return List.of(List.of(nums[0], nums[1]), List.of(nums[1], nums[0]));
        }

        List<List<Integer>> lists = new ArrayList<>();

        return null;
    }
}
