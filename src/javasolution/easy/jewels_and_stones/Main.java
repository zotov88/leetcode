package javasolution.easy.jewels_and_stones;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String jewels = "A";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }

    // 1
    public static int numJewelsInStones(String jewels, String stones) {
        return stones.length() - stones.replaceAll("[" + jewels + "]", "").length();
    }

    // 2
    public static int numJewelsInStones2(String jewels, String stones) {
        Map<Character, Integer> stonesMap = getStonesMap(stones);

        return jewels.chars()
                .mapToObj(c -> (char) c)
                .filter(stonesMap::containsKey)
                .mapToInt(stonesMap::get)
                .sum();
    }

    private static Map<Character, Integer> getStonesMap(String stones) {
        return stones.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));
    }
}
