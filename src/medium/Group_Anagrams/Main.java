package medium.Group_Anagrams;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = Arrays.toString(array);
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
}
