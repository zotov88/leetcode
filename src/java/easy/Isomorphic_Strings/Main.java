package java.easy.Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        boolean result = false;
        if (s.length() == t.length()) {
            result = true;
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sch = s.charAt(i);
                char tch = t.charAt(i);
                if (!map1.containsKey(sch)) {
                    map1.put(sch, tch);
                } else if (map1.get(sch) != tch) {
                    result = false;
                    break;
                }
                if (!map2.containsKey(tch)) {
                    map2.put(tch, sch);
                } else if (map2.get(tch) != sch) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
