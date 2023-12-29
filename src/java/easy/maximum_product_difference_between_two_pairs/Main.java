package java.easy.maximum_product_difference_between_two_pairs;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,2,7,4};
        System.out.println(maxProductDifference(nums));
    }

    public static int maxProductDifference(int[] nums) {
        int firstMax = Math.max(nums[0], nums[1]);
        int firstMin = Math.min(nums[0], nums[1]);
        int secondMax = firstMin;
        int secondMin = firstMax;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
            if (nums[i] <= firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }

        return firstMax * secondMax - firstMin * secondMin;
    }
}
