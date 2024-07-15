package javasolution.medium.t_2610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> matrix = findMatrix(nums);
        IntStream.range(0, matrix.size())
                .forEach(i -> System.out.println(matrix.get(i)));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        while (nums.length > 0) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            result.add(new ArrayList<>(set));
            int[] tmp = new int[nums.length - set.size()];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                } else {
                    tmp[j++] = nums[i];
                }
            }
            nums = tmp;
        }
        return result;
    }
}
