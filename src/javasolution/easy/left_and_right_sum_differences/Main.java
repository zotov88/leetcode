package javasolution.easy.left_and_right_sum_differences;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = rightSum[rightSum.length - 1] = 0;
        int left = nums[0];
        int right = nums[nums.length - 1];

        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            leftSum[i] = left;
            left += nums[i];
            rightSum[j] = right;
            right += nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return nums;
    }
}
