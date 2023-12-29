package java.easy.Longest_Common_Prefix;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(longestCommonPrefix2(strs));
    }

    private static String longestCommonPrefix2(String[] strs) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (true) {
            if (index >= strs[0].length()) {
                return result.toString();
            }
            result.append(strs[0].charAt(index));
            for (String str : strs) {
                if (!str.startsWith(result.toString())) {
                    return result.deleteCharAt(result.length() - 1).toString();
                }
            }
            index++;
        }
    }

    private static String longestCommonPrefix1(String[] strs) {
        String result = "";
        String key = "";
        int index = 1;
        Map<String, Integer> map = new HashMap<>();

        while (true) {
            for (String str : strs) {
                if (index > str.length()) {
                    return result;
                }
                key = str.substring(0, index);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
            if (map.get(key) != strs.length) {
                return result;
            }
            result = key;
            index++;
        }
    }
}
