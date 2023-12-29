package java.medium.product_of_array_except_self;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{11, 5, 2, 7})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int pref = 1;
        int suf = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = pref;
            pref *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suf;
            suf *= nums[i];
        }

        return result;
    }

}

