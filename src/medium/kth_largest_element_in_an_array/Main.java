package medium.kth_largest_element_in_an_array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((o1, o2) -> Integer.compare(o2, o1))
                .skip(k - 1)
                .findFirst()
                .orElse(-1); // nothing be returned
    }
}
