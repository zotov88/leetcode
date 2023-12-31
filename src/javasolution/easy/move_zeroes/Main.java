package javasolution.easy.move_zeroes;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 4, 0, 2, 0, 9, 0, 6};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
