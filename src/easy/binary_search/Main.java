package easy.binary_search;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12, 14};
        int target = 12;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
}
