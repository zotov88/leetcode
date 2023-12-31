package javasolution.medium.find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (end + start) / 2;
            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
            if (nums[middle] == target) {
                return getResult(nums, middle, target);
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] getResult(int[] nums, int middle, int target) {
        int left = middle;
        int right = middle;

        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right <= nums.length - 1 && nums[right] == target) {
            right++;
        }

        return new int[] {++left, --right};
    }
}
