package javasolution.easy.Merge_Sorted_Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {};
        int m = 1;
        int n = 0;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        for (int i = 0, j = 0; j < n; i++) {
            if ((i < m + count) && nums1[i] < nums2[j]) {
                continue;
            }
            numsToRight(nums1, i, m - 1 + count++);
            nums1[i] = nums2[j];
            j++;
        }
    }

    private static void numsToRight(int[] nums1, int start, int end) {
        for (int i = end; i >= start; i--) {
            nums1[i + 1] = nums1[i];
        }
    }
}
