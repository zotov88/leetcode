package javasolution.medium.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String num = "234";
        System.out.println(letterCombinations(num));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        if (digits.length() == 1) {
            return Data.getListLettersOnKey(Integer.parseInt(digits));
        }

        List<List<String>> listOfLetterLists = new ArrayList<>();
        fillListOfLetters(listOfLetterLists, digits);
        List<String> resultList = new ArrayList<>();
        int[] indexes = new int[listOfLetterLists.size()];

        while (indexes[0] < listOfLetterLists.get(0).size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < listOfLetterLists.size(); i++) {
                sb.append(listOfLetterLists.get(i).get(indexes[i]));
                if (i == indexes.length - 2) { // если мы дошли до предпоследнего списка с буквами
                    int index = i + 1;
                    while (indexes[index] < listOfLetterLists.get(index).size()) {
                        String word = sb + listOfLetterLists.get(index).get(indexes[index]);
                        resultList.add(word);
                        indexes[index]++;
                    }
                    correctRankNumbers(indexes, listOfLetterLists);
                }
            }
        }
        return resultList;
    }

    private static void fillListOfLetters(List<List<String>> listOfLetters, String digits) {
        for (int i = 0; i < digits.length(); i++) {
            listOfLetters.add(Data.getListLettersOnKey(digits.charAt(i) - 48));
        }
    }

    private static void correctRankNumbers(int[] indexes, List<List<String>> listList) {
        for (int i = indexes.length - 1; i > 0; i--) {
            if (indexes[i] == listList.get(i).size()) {
                indexes[i] = 0;
                indexes[i - 1]++;
            }
        }
    }

    public static class Data {

        private static Map<Integer, List<String>> listLettersMap;

        private Data() {
        }

        private static List<String> getListLettersOnKey(final int keyNumber) {
            if (listLettersMap == null) {
                init();
            }
            return listLettersMap.get(keyNumber);
        }

        private static void init() {
            listLettersMap = new HashMap<>();
            listLettersMap.put(0, new ArrayList<>(List.of()));
            listLettersMap.put(1, new ArrayList<>(List.of()));
            listLettersMap.put(2, new ArrayList<>(List.of("a", "b", "c")));
            listLettersMap.put(3, new ArrayList<>(List.of("d", "e", "f")));
            listLettersMap.put(4, new ArrayList<>(List.of("g", "h", "i")));
            listLettersMap.put(5, new ArrayList<>(List.of("j", "k", "l")));
            listLettersMap.put(6, new ArrayList<>(List.of("m", "n", "o")));
            listLettersMap.put(7, new ArrayList<>(List.of("p", "q", "r", "s")));
            listLettersMap.put(8, new ArrayList<>(List.of("t", "u", "v")));
            listLettersMap.put(9, new ArrayList<>(List.of("w", "x", "y", "z")));
        }
    }
}
