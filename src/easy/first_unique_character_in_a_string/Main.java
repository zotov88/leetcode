package easy.first_unique_character_in_a_string;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("c"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> characters = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!characters.containsKey(ch)) {
                characters.put(ch, i);
            } else {
                characters.put(ch, -1);
            }
        }

        return characters.values().stream()
                .filter(i -> i > -1)
                .findFirst()
                .orElse(-1);
    }
}
