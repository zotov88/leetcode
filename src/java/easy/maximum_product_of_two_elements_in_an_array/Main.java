package java.easy.maximum_product_of_two_elements_in_an_array;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int nextMax = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= max) {
                nextMax = max;
                max = nums[i];
            } else if (nums[i] > nextMax) {
                nextMax = nums[i];
            }
        }
        return --max * --nextMax;
    }
}
