package javasolution.easy.t_1365;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{6, 5, 4, 19})));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] indexes = new int[max + 1];
        Arrays.stream(nums).forEach(i -> indexes[i]++);
        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = getSumIntervalArray(indexes, nums[i]);
        }
        return result;
    }

    private static Integer getSumIntervalArray(int[] indexes, int num) {
        if (num == 0) {
            return 0;
        }
        int[] tmp = Arrays.copyOfRange(indexes, 0, num);

        return Arrays.stream(tmp).sum();
    }
}
