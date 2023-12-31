package javasolution.medium.sum3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        List<Integer> integers = new ArrayList<>(map.keySet());
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i + 1; j < integers.size(); j++) {
                int find = (integers.get(i) + integers.get(j)) * (-1);
                if (map.containsKey(find)) {
                    if (((find == integers.get(i) || find == integers.get(j)) && map.get(find) > 1)
                            || find != integers.get(i) && find != integers.get(j)) {
                        List<Integer> triple = Arrays.asList(integers.get(i), integers.get(j), find);
                        Collections.sort(triple);
                        set.add(triple);
                    }
                }
            }
        }
        if (map.containsKey(0) && map.get(0) >= 3) {
            set.add(Arrays.asList(0, 0, 0));
        }
        return new ArrayList<>(set);
    }

}
