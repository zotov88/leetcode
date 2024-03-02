package javasolution.easy.squares_of_a_sorted_array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int x = 0;

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = nums.length - 1; j > nums.length - 1 - i; j--) {
                if (Math.abs(nums[j]) < Math.abs(nums[j - 1])) {
                    swap(nums, j, j - 1);
                }
            }
            nums[x] = nums[x] * nums[x];
            x++;
        }
        nums[x] = nums[x] * nums[x];
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
