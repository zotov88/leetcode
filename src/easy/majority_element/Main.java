package easy.majority_element;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int result = 0;
//
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 0);
//            }
//            map.put(num, map.get(num) + 1);
//            if (map.get(num) > nums.length / 2) {
//                result = num;
//                break;
//            }
//        }
//
//        return result;
//    }
}
