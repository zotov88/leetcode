package javasolution.easy.valid_anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            putToMap(sMap, s.charAt(i));
            putToMap(tMap, t.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (!isSameKeyAndValue(sMap, tMap, s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSameKeyAndValue(Map<Character, Integer> sMap,
                                             Map<Character, Integer> tMap,
                                             char c) {
        return sMap.containsKey(c) && tMap.containsKey(c) &&
                Objects.equals(tMap.get(c), sMap.get(c));
    }

    private static void putToMap(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            map.put(c, 1);
        } else {
            map.put(c, map.get(c) + 1);
        }
    }

}
