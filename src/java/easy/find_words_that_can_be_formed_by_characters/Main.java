package java.easy.find_words_that_can_be_formed_by_characters;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cct", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int lengthAllWords = 0;
        Map<Character, Integer> mainMap = new HashMap<>();
        Map<Character, Integer> tmpMap;

        fillMap(chars, mainMap);

        for (String word : words) {
            boolean isCan = true;
            tmpMap = new HashMap<>();
            fillMap(word, tmpMap);

            for (Character c : tmpMap.keySet()) {
                if (!mainMap.containsKey(c) || mainMap.get(c) < tmpMap.get(c)) {
                    isCan = false;
                    break;
                }
            }

            lengthAllWords = isCan ? lengthAllWords + word.length() : lengthAllWords;
        }

        return lengthAllWords;
    }

    private static void fillMap(String chars, Map<Character, Integer> mainMap) {
        for (int i = 0; i < chars.length(); i++) {
            if (!mainMap.containsKey(chars.charAt(i))) {
                mainMap.put(chars.charAt(i), 0);
            }
            mainMap.put(chars.charAt(i), mainMap.get(chars.charAt(i)) + 1);
        }
    }

}
