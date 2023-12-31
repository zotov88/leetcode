package javasolution.easy.contains_duplicate;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
           if (!set.add(num)) {
               return true;
           }
        }
        return false;
    }
}
